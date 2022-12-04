package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class siralama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siralama)

        val yazii = findViewById<TextView>(R.id.yaziYazdir)
        val soruCoz = findViewById<TextView>(R.id.sorulariCoz)

        soruCoz.setOnClickListener {
            var i = Intent(this,yarismaMain::class.java)
            startActivity(i)
        }
        //val denemeYazi = findViewById<TextView>(R.id.deneme)
        val tahta = findViewById<ListView>(R.id.tahta)
        val ies = String
        var database = FirebaseDatabase.getInstance().reference


        var getData = object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var istagCikti = StringBuilder()//metin birleştirme sınıfı
                var yaziCikti = StringBuilder()//metin birleştirme sınıfı
                var denemeCikti = ""
                for(i in snapshot.children){
                    var isim = i.child("isim").getValue()
                    var skor = i.child("skor").getValue(Int::class.java)
                    val ies = i.child("isim").getValue(String::class.java)

                    val denemeCikti = yaziCikti.append("$skor")

                    //denemeYazi.text = denemeCikti.toString()


                    val liste =
                        arrayOf(skor.toString()+",") //Dizi'mizi oluşturuyoruz


                    for (i in 0 until liste.size - 1) { //Dizimizin değerlerini sırası ile alıyoruz
                        var sayi = liste[i] //sıradaki değeri sayi değişkenine atıyoruz
                        var temp = i //sayi 'nin indeksini temp değerine atıyoruz
                        for (j in i + 1 until liste.size) { //dizimizde i' den sonraki elemanlara bakıyoruz
                            if (liste[j] < sayi) { //sayi değişkeninden küçük sayı var mı
                                sayi = liste[j] //varsa sayi değişkenimizide değiştiriyoruz
                                temp = j //indeks değerinide değiştiriyoruz
                            }
                        }
                        if (temp != i) { //temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden küçük sayı varsa onları yer değiştiriyoruz
                            liste[temp] = liste[i]
                            liste[i] = sayi
                        }
                    }

                    for (sayi in liste) {
                        //Bu kısım sıralama ile ilgili değil sadece sıralamanın doğru calısıp calısmadıgını kontrol etmek için
                        //println(sayi)


                        istagCikti.append("$isim \nSkoru = $skor \n\n")
                    }


                    //istagCikti.append("$isim \n $skor \n\n")
                    //yaziCikti.append("$ies")
                    //yaziCikti.append("$ies")
                    // tüm instagram adreslerini çekip giriş yapmaya çalışıyor

                }
                yazii.text = istagCikti.toString()

            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)
    }
}