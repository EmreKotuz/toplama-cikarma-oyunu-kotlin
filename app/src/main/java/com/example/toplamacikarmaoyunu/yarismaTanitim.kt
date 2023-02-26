package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class yarismaTanitim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yarisma_tanitim)
        var yarismaButton = findViewById<TextView>(R.id.yarismayaBasla)
        var siralamayaBak = findViewById<TextView>(R.id.siralamayaBak)

        yarismaButton.setOnClickListener {
            var yarismaButton = Intent(this,yarismaMain::class.java)
            startActivity(yarismaButton)
        }
        siralamayaBak.setOnClickListener {
            var siralamaButton = Intent(this,siralama::class.java)
            startActivity(siralamaButton)
        }

    }
}