package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class matematigeGiris : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matematige_giris)
        val rakam = findViewById<TextView>(R.id.rakam2)
        val egitimButton = findViewById<TextView>(R.id.egitim2)
        val sayilariHesapla = findViewById<TextView>(R.id.hesapla2)

        rakam.setOnClickListener {
            var i = Intent(this, rakamlariYaz::class.java)
            startActivity(i)
        }
        egitimButton.setOnClickListener {
            var i = Intent(this, saymaSayilar::class.java)
            startActivity(i)
        }
        sayilariHesapla.setOnClickListener {
            var i = Intent(this, com.example.toplamacikarmaoyunu.sayilariHesapla::class.java)
            startActivity(i)
        }
    }
}