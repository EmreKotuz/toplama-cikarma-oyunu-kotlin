package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toplama = findViewById<TextView>(R.id.toplama)
        val cikarma = findViewById<TextView>(R.id.cikarma)
        val yarisma = findViewById<TextView>(R.id.yarisma)
        val sayilariHesapla = findViewById<TextView>(R.id.hesapla)
        val testSayfasi = findViewById<TextView>(R.id.destekOl)
        val teknoek = findViewById<TextView>(R.id.teknoekCom)
        val rakam = findViewById<TextView>(R.id.rakam)
        val egitimButton = findViewById<TextView>(R.id.egitim)

        teknoek.setOnClickListener {
            val url = "https://teknoek.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        rakam.setOnClickListener {
            var i = Intent(this,rakamlariYaz::class.java)
            startActivity(i)
        }
        testSayfasi.setOnClickListener {
            var i = Intent(this,destek::class.java)
            startActivity(i)
        }
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
        sayilariHesapla.setOnClickListener {
            var i = Intent(this,com.example.toplamacikarmaoyunu.sayilariHesapla::class.java)
            startActivity(i)
        }
    }
}