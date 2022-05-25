package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)
    supportActionBar?.hide()

    val btnLogin = findViewById<TextView>(R.id.btnNavigateToSignin)

    btnLogin.setOnClickListener{
      val navigateSignIn = Intent(this@RegisterActivity, MainActivity::class.java)
      startActivity(navigateSignIn)
    }
  }
}