package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.graphics.Color
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
        var database = FirebaseDatabase.getInstance().reference
        var istagCikti = StringBuilder()//metin birleştirme sınıfı

        soruCoz.setOnClickListener {
            var i = Intent(this,yarismaMain::class.java)
            startActivity(i)
        }





        var deneme = database.child("isim").orderByChild("skor").limitToLast(5)

        var getData = object :ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var istagCikti = StringBuilder()//metin birleştirme sınıfı
                var yaziCikti = StringBuilder()//metin birleştirme sınıfı
                var denemeCikti = ""

                for(postSnapshot in dataSnapshot.children){
                    var isim = postSnapshot.child("isim").getValue()
                    var skor = postSnapshot.child("skor").getValue()
                    var array = listOf<Int>(skor.toString().toInt()).sortedDescending()

                        istagCikti.append("ismi    = $isim \nSkoru = $skor \n\n")
                    


                }
                yazii.text = istagCikti.toString()


            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        database.addValueEventListener(getData)
        database.addListenerForSingleValueEvent(getData)






        /*
        val query = database.orderByChild("skor").limitToLast(5)
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    //istagCikti.append("$query")
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
*/
    }
}