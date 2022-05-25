package com.example.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
  @RequiresApi(Build.VERSION_CODES.R)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportActionBar?.hide()

    val btnSignUp = findViewById<TextView>(R.id.btnNavigateToSignup)
    val btnSignIn = findViewById<Button>(R.id.btnSignin)

    btnSignUp.setOnClickListener{
      val navigateSignUp = Intent(this@MainActivity, RegisterActivity::class.java)
      startActivity(navigateSignUp)
    }

    btnSignIn.setOnClickListener{
      val navigateSpinner = Intent(this@MainActivity, SpinnerActivity::class.java)
      startActivity(navigateSpinner)
    }
  }
}