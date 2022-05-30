package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import java.util.jar.Manifest

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
            val permissionChecking = checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)

            getPermission()

            if (permissionChecking == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permission Location Granted!",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Permission Location Not Granted!",Toast.LENGTH_LONG).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun getPermission(){
        requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 201)
    }
}