package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class SpinnerActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_spinner)
    supportActionBar?.hide()

    val btnSignOut = findViewById<Button>(R.id.btnSignOut)
    val spinner = findViewById<Spinner>(R.id.spinner)

    btnSignOut.setOnClickListener{
      val navigateSignIn = Intent(this@SpinnerActivity, MainActivity::class.java)
      startActivity(navigateSignIn)
    }

    // data yang ingin ditampilkan dalam spinner(drop down) berupa list
    val dataSet = arrayOf("SD", "SMP", "SMA", "Kuliah")

    // buat adapter, adapter digunakan untuk menghubungkan data-set dengan UI
    // pakai adapter bawaan android, support untuk 1 text
    val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
      this@SpinnerActivity,
      android.R.layout.simple_spinner_dropdown_item,
      dataSet
    )

    // set/pasang adapter ke spinner
//    spinner.adapter = Spinner(this, dataSet)
  }
}