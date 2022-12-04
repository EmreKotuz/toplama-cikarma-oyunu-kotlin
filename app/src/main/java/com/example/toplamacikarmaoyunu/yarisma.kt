package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class yarisma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yarisma)
        val yarismaButton = findViewById<TextView>(R.id.yarismaButton)
        val siralamaButton = findViewById<TextView>(R.id.siralamaButton)

        yarismaButton.setOnClickListener {
            var i = Intent(this,yarismaMain::class.java)
            startActivity(i)
        }
        siralamaButton.setOnClickListener {
            var i = Intent(this,siralama::class.java)
            startActivity(i)
        }
    }
}