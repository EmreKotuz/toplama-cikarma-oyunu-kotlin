package com.example.toplamacikarmaoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class sayiEgitim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayi_egitim)

        var sayi = findViewById<TextView>(R.id.gercekSayi)
        var sayiYazi = findViewById<EditText>(R.id.gercekSayiYazi)
        var testButton = findViewById<TextView>(R.id.gercekTest)

        //var rastgele = Random().nextInt(0,10)
        sayiYazi.requestFocus()
        testButton.setOnClickListener {
            if(sayiYazi.text.toString() == ""){
                Toast.makeText(this,"Boş Bırakmayınız!",Toast.LENGTH_SHORT).show()
                sayiYazi.requestFocus()
            }else{
                if (sayi.text == "1"){
                    if (sayiYazi.text.toString() == "Bir" || sayiYazi.text.toString() == "bir"){

                    }else{

                    }
                }
            }
        }
    }
}