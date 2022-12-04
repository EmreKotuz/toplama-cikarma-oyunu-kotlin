package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class egitimAnaSayfa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egitim_ana_sayfa)
        var sayilar = findViewById<TextView>(R.id.sayilar)
        var sayma = findViewById<TextView>(R.id.sayma)


        sayilar.setOnClickListener {
            var sayilar = Intent(this,saymaSayilar::class.java)
            startActivity(sayilar)
        }
    }
}