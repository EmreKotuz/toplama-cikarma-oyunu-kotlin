package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.firebase.database.FirebaseDatabase
import kotlin.random.Random

private var soruSayi = 1
lateinit var mAdView : AdView
private var skorSayi = 0
var time:Long=1
var timeSayac:Long=1
private var mInterstitialAd: InterstitialAd? = null
private var TAG = "yarismaMain"
private var saniyeHesaplamaa = 0
var sureSaniye:Long = 10
var zamaniDurdur:Long=0
private var soruSayisi = 0
class yarismaMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yarisma_main)


        MobileAds.initialize(this) {}
        val adView = AdView(this)
        //adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/6523225562"
        mAdView = findViewById(R.id.adViewReklam)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        skorSayi = 0
        //değişkenler
        val view = View.inflate(this@yarismaMain,R.layout.kaybettin,null)
        val builder = AlertDialog.Builder(this@yarismaMain)
        val cevapBir = findViewById<TextView>(R.id.cevapbir)
        val cevapIkı = findViewById<TextView>(R.id.cevapiki)
        val cevapUc = findViewById<TextView>(R.id.cevapuc)
        val cevapDort = findViewById<TextView>(R.id.cevapdort)
        val eksiArti = findViewById<TextView>(R.id.eksiArti)
        val kronometre = findViewById<Chronometer>(R.id.kronometre)
        val anaSayfa = findViewById<ImageView>(R.id.anaSayfa)

        soruSayi++
        cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapBir.setTextColor(Color.parseColor("#A66A11"))
        cevapIkı.setTextColor(Color.parseColor("#A66A11"))
        cevapUc.setTextColor(Color.parseColor("#A66A11"))
        cevapDort.setTextColor(Color.parseColor("#A66A11"))

        anaSayfa.setOnClickListener {
            var anasayfaGecis = Intent(this,MainActivity::class.java)
            startActivity(anasayfaGecis)
        }

        // + ve - arasındaki seçime göre soru üretme

        val artiEksiList = Random.nextInt(1, 3)
        if (artiEksiList == 1) {
            eksiArti.text = "-"
            eksi()
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.start()
        }else {
            eksiArti.text = "+"
            geciss()
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.start()
        }
    }
    private fun rastgeleSoru(){
        val eksiArti = findViewById<TextView>(R.id.eksiArti)
        val artiEksiList = Random.nextInt(1, 3)
        if (artiEksiList == 1) {
            eksiArti.text = "-"
            eksi()
        }else {
            eksiArti.text = "+"
            geciss()
        }

    }
    private fun eksi() {
        val view = View.inflate(this@yarismaMain, R.layout.yildiz, null)
        val builder = AlertDialog.Builder(this@yarismaMain)
        builder.setView(view)
        val skor = findViewById<TextView>(R.id.skor)
        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
        val cevapBir = findViewById<TextView>(R.id.cevapbir)
        val cevapIkı = findViewById<TextView>(R.id.cevapiki)
        val cevapUc = findViewById<TextView>(R.id.cevapuc)
        val cevapDort = findViewById<TextView>(R.id.cevapdort)
        val kronometre = findViewById<Chronometer>(R.id.kronometre)

        soruSayi++
        cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapBir.setTextColor(Color.parseColor("#A66A11"))
        cevapIkı.setTextColor(Color.parseColor("#A66A11"))
        cevapUc.setTextColor(Color.parseColor("#A66A11"))
        cevapDort.setTextColor(Color.parseColor("#A66A11"))
        //cevaplar
        var kbir: Int = 0
        var kiki: Int = 0
        var kuc: Int = 0
        var kdort: Int = 0

        zamaniDurdur = kronometre.base - SystemClock.elapsedRealtime()
        if (zamaniDurdur.toDouble() <= -120000) {
            eksiElli()
        }

        saniyeee()


        val ilkCarpimRandom = Random.nextInt(0, 15)
        val ikinciÇarpimRandom = Random.nextInt(0, 15)
        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() - ikinciCarpim.text.toString().toInt()
        val rastgeleList = Random.nextInt(1, 4)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(-20, 20)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-20, 20)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-20, 20)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }

            cevapBir.setOnClickListener {
                if (kbir.toString().toInt() == 0) {
                    kbir++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                    rastgeleSoru()
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                } else {
                    Toast.makeText(this, "Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                }

            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
        } else if (rastgeleList == 2) {
            cevapIkı.text = i.toString()
            val randomlar = Random.nextInt(-20, 20)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-20, 20)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-20, 20)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapIkı.setOnClickListener {
                if (kiki.toString().toInt() == 0) {
                    kiki++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    rastgeleSoru()
                    cevapIkı.setTextColor(Color.parseColor("#19db00"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                } else {
                    Toast.makeText(this, "Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                }

            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
        } else if (rastgeleList == 3) {
            cevapUc.text = i.toString()
            val randomlar = Random.nextInt(-20, 20)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-20, 20)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-20, 20)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapUc.setOnClickListener {
                if (kuc.toString().toInt() == 0) {
                    kuc++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    rastgeleSoru()
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                } else {
                    Toast.makeText(this, "Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                }

            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                eksiElli()
            }
        } else if (rastgeleList == 4) {
            cevapDort.text = i.toString()
            val randomlar = Random.nextInt(-20, 20)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-20, 20)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-20, 20)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-20, 20)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-20, 20)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-20, 20)
                cevapUc.text = randomlarUc.toString()
            } else {
                cevapUc.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))

                eksiElli()
            }
            cevapDort.setOnClickListener {
                if (kdort.toString().toInt() == 0) {
                    kdort++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    rastgeleSoru()
                    cevapDort.setTextColor(Color.parseColor("#005700"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                } else {
                    Toast.makeText(this, "Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    //+
        private fun geciss() {
            val view = View.inflate(this@yarismaMain, R.layout.yildiz, null)
            val builder = AlertDialog.Builder(this@yarismaMain)
            builder.setView(view)
            val skor = findViewById<TextView>(R.id.skor)
            val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
            val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
            val cevapBir = findViewById<TextView>(R.id.cevapbir)
            val cevapIkı = findViewById<TextView>(R.id.cevapiki)
            val cevapUc = findViewById<TextView>(R.id.cevapuc)
            val cevapDort = findViewById<TextView>(R.id.cevapdort)
            val kronometre = findViewById<Chronometer>(R.id.kronometre)

            soruSayi++
            cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapBir.setTextColor(Color.parseColor("#A66A11"))
            cevapIkı.setTextColor(Color.parseColor("#A66A11"))
            cevapUc.setTextColor(Color.parseColor("#A66A11"))
            cevapDort.setTextColor(Color.parseColor("#A66A11"))
            //cevaplar
            var kbir:Int = 0
            var kiki:Int = 0
            var kuc:Int = 0
            var kdort:Int = 0

            zamaniDurdur = kronometre.base-SystemClock.elapsedRealtime()
            if(zamaniDurdur.toDouble() <= -120000){
                eksiElli()
            }

            saniyeee()


            val ilkCarpimRandom = Random.nextInt(0, 20)
            val ikinciÇarpimRandom = Random.nextInt(0, 20)
            ilkCarpim.text = ilkCarpimRandom.toString()
            ikinciCarpim.text = ikinciÇarpimRandom.toString()

            val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()
            val rastgeleList = Random.nextInt(1, 4)
            if (rastgeleList == 1) {
                cevapBir.text = i.toString()
                val randomlar = Random.nextInt(0, 45)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapIkı.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapIkı.text = randomlar.toString()
                } else {
                    cevapIkı.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 45)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 45)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }

                cevapBir.setOnClickListener {
                    if (kbir.toString().toInt() == 0)
                    {
                        kbir++
                        val ply = MediaPlayer.create(this, R.raw.alkis)
                        ply?.start()
                        cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                        rastgeleSoru()
                        cevapBir.setTextColor(Color.parseColor("#ffffff"))
                        skorSayi += 25
                        skor.text = "Skor = " + skorSayi.toString()
                        artiOn()
                    }else{
                        Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    }

                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
            } else if (rastgeleList == 2) {
                cevapIkı.text = i.toString()
                val randomlar = Random.nextInt(0, 45)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 45)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 45)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapIkı.setOnClickListener {
                    if (kiki.toString().toInt() == 0)
                    {
                        kiki++
                        val ply = MediaPlayer.create(this, R.raw.alkis)
                        ply?.start()
                        cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                        rastgeleSoru()
                        cevapIkı.setTextColor(Color.parseColor("#19db00"))
                        skorSayi += 25
                        skor.text = "Skor = " + skorSayi.toString()
                        artiOn()
                    }else{
                        Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    }

                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
            } else if (rastgeleList == 3) {
                cevapUc.text = i.toString()
                val randomlar = Random.nextInt(0, 45)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 45)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 45)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapUc.setOnClickListener {
                    if (kuc.toString().toInt() == 0)
                    {
                        kuc++
                        val ply = MediaPlayer.create(this, R.raw.alkis)
                        ply?.start()
                        cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                        rastgeleSoru()
                        cevapUc.setTextColor(Color.parseColor("#ffffff"))
                        skorSayi += 25
                        skor.text = "Skor = " + skorSayi.toString()
                        artiOn()
                    }else{
                        Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    }

                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    eksiElli()
                }
            } else if (rastgeleList == 4) {
                cevapDort.text = i.toString()
                val randomlar = Random.nextInt(0, 45)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 45)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 45)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 45)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 45)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapUc.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 45)
                    cevapUc.text = randomlarUc.toString()
                } else {
                    cevapUc.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))

                    eksiElli()
                }
                cevapDort.setOnClickListener {
                    if (kdort.toString().toInt() == 0)
                    {
                        kdort++
                        val ply = MediaPlayer.create(this, R.raw.alkis)
                        ply?.start()
                        cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                        rastgeleSoru()
                        cevapDort.setTextColor(Color.parseColor("#005700"))
                        skorSayi += 25
                        skor.text = "Skor = " + skorSayi.toString()
                        artiOn()
                    }else{
                        Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    }
                }



            }

        }
        private fun artiOn(){
            val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
            val cevapBir = findViewById<TextView>(R.id.cevapbir)
            val cevapIkı = findViewById<TextView>(R.id.cevapiki)
            val cevapUc = findViewById<TextView>(R.id.cevapuc)
            val cevapDort = findViewById<TextView>(R.id.cevapdort)

            animasyonYazi.visibility = View.VISIBLE
            animasyonYazi.text = "+25"

            rastgeleSoru()
/*

            var saniyeHesaplama = progressBar.progress.toString().toInt()/10

            if (saniyeHesaplama <= 3)
            {
                Toast.makeText(this,"Mükemmell Zamanlama",Toast.LENGTH_SHORT).show()
                progressBar.max = 0

            }else if (saniyeHesaplama <= 6)
            {
                Toast.makeText(this,"Daha Hızlı",Toast.LENGTH_SHORT).show()
                progressBar.max = 0


            }else if (saniyeHesaplama <= 9)
            {
                Toast.makeText(this,"Kıl Payı",Toast.LENGTH_SHORT).show()
                progressBar.max = 0



            }else{
                Toast.makeText(this,"Neyi Başaramadınn?",Toast.LENGTH_SHORT).show()
                progressBar.max = 0
                eksiElli()

            }
*/

            sureSaniye = 10
            cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapBir.setTextColor(Color.parseColor("#A66A11"))
            cevapIkı.setTextColor(Color.parseColor("#A66A11"))
            cevapUc.setTextColor(Color.parseColor("#A66A11"))
            cevapDort.setTextColor(Color.parseColor("#A66A11"))

            object : CountDownTimer(time*1000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.INVISIBLE
                    time=1
                }
                override fun onTick(p0: Long) {
                    time--
                }
            }.start()
        }
        private fun eksiElli(){


            //veri ekleme

            val view = View.inflate(this@yarismaMain, R.layout.kaybettin, null)
            val builder = AlertDialog.Builder(this@yarismaMain)
            val gizliEkran = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.Gizliekran)
            var kullaniciKaydet = view.findViewById<TextView>(R.id.kullaniciKaydet)
            var isimEkle = view.findViewById<EditText>(R.id.isimEkle)
            var dereceText = view.findViewById<TextView>(R.id.dereceText)
            var skorGoster = view.findViewById<TextView>(R.id.skorGoster)
            var boslukBir = view.findViewById<TextView>(R.id.boslukBir)
            var boslukiki = view.findViewById<TextView>(R.id.boslukiki)
            var menuGecbaba = view.findViewById<ImageView>(R.id.menuGecbaba)
            var liste = view.findViewById<ImageView>(R.id.liste)
            var tekrarla = view.findViewById<ImageView>(R.id.tekrarlaGardas)
            val kronometre = findViewById<Chronometer>(R.id.kronometre)
            val skor = findViewById<TextView>(R.id.skor)

            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource((android.R.color.transparent))
            gizliEkran.visibility = View.GONE

            var isimii = isimEkle.text.toString()
            var skori : Int = skorSayi.toString().toInt()


            menuGecbaba.setOnClickListener {
                var gecis = Intent(this,MainActivity::class.java)
                startActivity(gecis)
            }
            liste.setOnClickListener {
                var gecis = Intent(this,siralama::class.java)
                startActivity(gecis)
            }
            tekrarla.setOnClickListener {
                skorSayi = 0
                dialog.dismiss()
                zamaniDurdur=0
                kronometre.base = SystemClock.elapsedRealtime()
                rastgeleSoru()
                gizliEkran.visibility = View.VISIBLE
                skor.text = "Skor = " + skorSayi.toString()

            }

            skorGoster.text = " Skorun = " + skori.toString()

            if (skori <= 1000){
                kullaniciKaydet.visibility = View.GONE
                isimEkle.visibility = View.GONE
                boslukBir.visibility = View.GONE
                boslukiki.visibility = View.GONE
                dereceText.visibility = View.GONE

            }else{
                kullaniciKaydet.visibility = View.VISIBLE
                isimEkle.visibility = View.VISIBLE
                boslukBir.visibility = View.VISIBLE
                boslukiki.visibility = View.VISIBLE
            }

            if (skori <= 300){
                var adRequest = AdRequest.Builder().build()
                InterstitialAd.load(
                    this,
                    "ca-app-pub-6537190103014639/8087867913",
                    adRequest,
                    object : InterstitialAdLoadCallback() {
                        override fun onAdFailedToLoad(adError: LoadAdError) {
                            mInterstitialAd = null
                        }

                        override fun onAdLoaded(interstitialAd: InterstitialAd) {
                            mInterstitialAd = interstitialAd
                        }
                    })
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this)
                } else {

                }
            }

            kullaniciKaydet.setOnClickListener {

                if (isimEkle.text.toString() == "") {
                    Toast.makeText(this, "Boş Alanları Doldurunuz", Toast.LENGTH_SHORT)
                        .show()
                }else {
                    var isimii = isimEkle.text.toString()
                    var skori: Int = skorSayi.toString().toInt()


                    var database = FirebaseDatabase.getInstance().reference

                    //Toast.makeText(this,"Buttona tiklandi",Toast.LENGTH_SHORT).show()

                    if (isimii.toString().isNotEmpty()!!) {

                        //val random1 = (0..10000).shuffled().last()
                        database.child(isimii.toString()+" "+skori.toString())
                            .setValue(kullaniciEkle(isimii, skori))
                        Toast.makeText(this, "Yazınız Yayınlanmıştır.", Toast.LENGTH_SHORT).show()
                        isimEkle.text.clear()
                        intent = Intent(this, siralama::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                        startActivity(intent)

                        skorSayi = 0
                        zamaniDurdur = 0
                    } else {
                        database.child(isimii.toString()+" "+skori.toString())
                            .setValue(kullaniciEkle(isimii, skori))
                        Toast.makeText(
                            this,
                            "Lütfen internet bağlantınızı kontrol edip tekrar deneyiniz.",
                            Toast.LENGTH_SHORT
                        ).show()
                        intent = Intent(this, siralama::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)       //geri tıklandığında hafızadan silecek işlem..
                        startActivity(intent)
                        skorSayi = 0
                    }
                }

            }
            if(skorSayi.toString().toInt() <= -30000){
                Toast.makeText(this,"Sorun Sende Değil Bende :)) Bilerek Mi Yapıyorsunnn", Toast.LENGTH_SHORT).show()
                var i = Intent(this,MainActivity::class.java)
                startActivity(i)
                skorSayi = 0
            }
            object : CountDownTimer(time*1000, 1000) {
                override fun onFinish() {
                    //animasyonYazi.visibility = View.INVISIBLE
                    time=1
                }
                override fun onTick(p0: Long) {
                    time--
                }
            }.start()
        }
    private fun saniyeee(){

        sureSaniye = 10
    }
    }
