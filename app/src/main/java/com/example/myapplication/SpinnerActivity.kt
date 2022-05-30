package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.View

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
  // data yang ingin ditampilkan dalam spinner(drop down) berupa list
  val dataSet = arrayOf("SD", "SMP", "SMA", "Kuliah")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_spinner)
    supportActionBar?.hide()

    val btnSignOut = findViewById<Button>(R.id.btnSignOut)
    val btnImageLoaderPage = findViewById<Button>(R.id.btnNavigateToLoader)
    val spinner = findViewById<Spinner>(R.id.spinner)

    btnSignOut.setOnClickListener{
      val navigateSignIn = Intent(this@SpinnerActivity, MainActivity::class.java)
      startActivity(navigateSignIn)
    }

    btnImageLoaderPage.setOnClickListener {
      val navigateLoadImage = Intent(this@SpinnerActivity, LoadImageActivity::class.java)
      startActivity(navigateLoadImage)
    }

    // buat adapter, adapter digunakan untuk menghubungkan data-set dengan UI
    // pakai adapter bawaan android, support untuk 1 text
    val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
      this@SpinnerActivity,
      android.R.layout.simple_spinner_dropdown_item,
      dataSet
    )

    // set/pasang adapter ke spinner
    spinner.adapter = adapter
  }

  // buat toast saat salah satu data pada array dipilih
  override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
    // tampilkan toast dari list dataSet yang dipilih melalui spinner
    Toast.makeText(this@SpinnerActivity,
      dataSet[position],
      Toast.LENGTH_SHORT)
      .show()
  }
  override fun onNothingSelected(parent: AdapterView<*>?) {}
}