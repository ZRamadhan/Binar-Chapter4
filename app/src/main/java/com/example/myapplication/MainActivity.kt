package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
  @RequiresApi(Build.VERSION_CODES.R)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    supportActionBar?.hide()
    setContentView(R.layout.activity_main)
  }
}