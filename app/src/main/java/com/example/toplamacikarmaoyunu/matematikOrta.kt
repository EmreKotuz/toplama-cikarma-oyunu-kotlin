package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class matematikOrta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matematik_orta)

        val toplama = findViewById<TextView>(R.id.toplama2)
        val cikarma = findViewById<TextView>(R.id.cikarma2)

        toplama.setOnClickListener {
            var i = Intent(this,toplamaIslemi::class.java)
            startActivity(i)
        }
        cikarma.setOnClickListener {
            var i = Intent(this,cikarmaIslemi::class.java)
            startActivity(i)
        }
    }
}