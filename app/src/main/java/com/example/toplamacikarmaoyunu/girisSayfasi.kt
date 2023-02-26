package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class girisSayfasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_sayfasi)
        val mk = findViewById<TextView>(R.id.matematikkolay)
        val mo = findViewById<TextView>(R.id.matematikorta)
        val mz = findViewById<TextView>(R.id.matematikzor)
        val teknoekCome = findViewById<TextView>(R.id.teknoekCome)
        val destekButton = findViewById<TextView>(R.id.destekOl2)


        teknoekCome.setOnClickListener {
            val url = "https://teknoek.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        destekButton.setOnClickListener {
            var i = Intent(this,destek::class.java)
            startActivity(i)
        }
        mk.setOnClickListener {
            var i = Intent(this,matematigeGiris::class.java)
            startActivity(i)
        }
        mo.setOnClickListener {
            var i = Intent(this,matematikOrta::class.java)
            startActivity(i)
        }
        mz.setOnClickListener {
            var i = Intent(this,yarismaTanitim::class.java)
            startActivity(i)
        }
    }
}