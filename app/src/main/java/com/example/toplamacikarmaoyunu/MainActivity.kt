package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toplama = findViewById<TextView>(R.id.toplama)
        val cikarma = findViewById<TextView>(R.id.cikarma)
        val yarisma = findViewById<TextView>(R.id.yarisma)
        val egitimButton = findViewById<TextView>(R.id.egitim)

        toplama.setOnClickListener {
            var i = Intent(this,toplamaIslemi::class.java)
            startActivity(i)
        }
        cikarma.setOnClickListener {
            var i = Intent(this,cikarmaIslemi::class.java)
            startActivity(i)
        }
        yarisma.setOnClickListener {
            var i = Intent(this,yarismaTanitim::class.java)
            startActivity(i)
        }
        egitimButton.setOnClickListener {
            var i = Intent(this,saymaSayilar::class.java)
            startActivity(i)
        }
    }
}