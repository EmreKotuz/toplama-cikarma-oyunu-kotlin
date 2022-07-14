package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val i = findViewById<TextView>(R.id.toplama)
        val ii = findViewById<TextView>(R.id.cikarma)

        i.setOnClickListener {
            var i = Intent(this,toplamaIslemi::class.java)
            startActivity(i)
        }
        ii.setOnClickListener {
            var i = Intent(this,cikarmaIslemi::class.java)
            startActivity(i)
        }
    }
}