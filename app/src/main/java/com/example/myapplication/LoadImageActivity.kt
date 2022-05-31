package com.example.myapplication

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide

class LoadImageActivity : AppCompatActivity() {
  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_load_image)
    
    val imageView = findViewById<ImageView>(R.id.loadImage)
    val btnLoad = findViewById<Button>(R.id.btnLoadImage)
    val btnSignOut = findViewById<Button>(R.id.btnSignOut)
    val btnCheck = findViewById<Button>(R.id.btnCheck)
    
    btnSignOut.setOnClickListener {
      val navigateToSignIn = Intent(this@LoadImageActivity, MainActivity::class.java)
      startActivity(navigateToSignIn)
    }
    
    btnLoad.setOnClickListener {
      Glide.with(this)
        .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
        .circleCrop()
        .into(imageView)
    }
    
    btnCheck.setOnClickListener {
      val permissionChecking = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

//    pengecekan apakah sudah punya permission
      if (permissionChecking == PackageManager.PERMISSION_GRANTED){
        getLatLong()
        Toast.makeText(this,"Permission Location Granted!",Toast.LENGTH_LONG).show()
      } else {
//      method untuk mendapatkan permission akan dipanggil apabila aplikasi masih belum mempunyai permission
//      untuk akses ke fine location
        getLocationPermission()
        Toast.makeText(this,"Permission Location Not Granted!",Toast.LENGTH_LONG).show()
      }
    }
  }

//  method  untuk menampilkan permission yang sudah ada terhadap aplikasi
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    if (requestCode == 201){
      if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
        Toast.makeText(this,"Permission Granted onRuntime",Toast.LENGTH_LONG).show()
      } else {
        Toast.makeText(this,"Permission Denied onRuntime",Toast.LENGTH_LONG).show()
      }
    }
    
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
  }

//  method yang digunakan untuk memberikan permission
  @RequiresApi(Build.VERSION_CODES.M)
  private fun getLocationPermission(){
    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 201)
  }

//  method untuk mendapatkan koordinat latitude dan longitude
  @SuppressLint("MissingPermission")
  private fun getLatLong(){
    val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
    
    Toast.makeText(
      this,
      "lat: ${location?.latitude}, long: ${location?.longitude}",
      Toast.LENGTH_LONG
    ).show()
  }
}