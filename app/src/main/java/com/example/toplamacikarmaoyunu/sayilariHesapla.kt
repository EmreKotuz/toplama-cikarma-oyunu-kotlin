package com.example.toplamacikarmaoyunu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlin.random.Random

class sayilariHesapla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var time:Long=1
        lateinit var mAdView : AdView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayilari_hesapla)

        soruDegistir()

        MobileAds.initialize(this) {}
        val adView = AdView(this)
        //adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/6523225562"
        mAdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
    private fun soruDegistir(){
        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
        val cevapYaz = findViewById<TextView>(R.id.cevapYazz)
        val testEt = findViewById<TextView>(R.id.testEt)
        val arkaPlan = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.arkaPlanRengi)


        cevapYaz.requestFocus()
        val ilkCarpimRandom = Random.nextInt(0, 50)
        val ikinciÇarpimRandom = Random.nextInt(0, 50)
        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()
        val cevap = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()


        testEt.setOnClickListener {

            if(cevapYaz.text.toString() == ""){
                Toast.makeText(this,"Lütfen Boş Bırakmayınız.",Toast.LENGTH_SHORT).show()
            }else{
                if (cevapYaz.text.toString() == cevap.toString()) {
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevapYaz.text = ""
                                    arkaPlan.setBackgroundColor(Color.WHITE)
                                    soruDegistir()
                                }
                                override fun onTick(p0: Long) {
                                    time--
                                }
                            }.start()
                        }

                        override fun onTick(p0: Long) {
                            timeSayac--
                        }
                    }.start()
                }else{
                    arkaPlan.setBackgroundColor(Color.RED)
                    object : CountDownTimer(timeSayac * 400, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 400, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevapYaz.text = ""
                                    arkaPlan.setBackgroundColor(Color.WHITE)
                                }
                                override fun onTick(p0: Long) {
                                    time--
                                }
                            }.start()
                        }

                        override fun onTick(p0: Long) {
                            timeSayac--
                        }
                    }.start()
                }

            }
        }
    }
}