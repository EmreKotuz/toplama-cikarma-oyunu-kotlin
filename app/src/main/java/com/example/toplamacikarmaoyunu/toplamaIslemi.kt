package com.example.toplamacikarmaoyunu

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.ads.*
import nl.dionsegijn.konfetti.KonfettiView
import kotlin.random.Random
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class toplamaIslemi : AppCompatActivity() {
    private var soruSayi = 1
    lateinit var mAdView : AdView
    private var skorSayi = 0
    var time:Long=1
    var timeSayac:Long=1
    var canSayisi = 3
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "toplamaIslemi"
    private var saniyeHesaplamaa = 0

    private var reklamSayımı = 0


    //cevaplar
    var kbir:Int = 0
    var kiki:Int = 0
    var kuc:Int = 0
    var kdort:Int = 0

    private var mRewardedAd: RewardedAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toplama_islemi)

        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
        val cevapBir = findViewById<TextView>(R.id.cevapbir)
        val cevapIkı = findViewById<TextView>(R.id.cevapiki)
        val cevapUc = findViewById<TextView>(R.id.cevapuc)
        val cevapDort = findViewById<TextView>(R.id.cevapdort)
        val cevap = findViewById<TextView>(R.id.cevap)
        val ekrann = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.ekran)
        val soruCozz = findViewById<TextView>(R.id.soruSayi)
        val anaSayfa = findViewById<ImageView>(R.id.anaSayfa)
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val skor = findViewById<TextView>(R.id.skor)
        //val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        var kazandi:Int = 0
        var kazandiIki:Int = 0
        var kazandiUc:Int = 0
        var kazandiDort:Int = 0


        //ads

        MobileAds.initialize(this) {}
        val adView = AdView(this)
        //adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/6523225562"
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)



        anaSayfa.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        progressBar.max = 100

        val currentProgresse = 100
        ObjectAnimator.ofInt(progressBar,"progress",currentProgresse)
            .setDuration(10000)
            .start()

        saniyeHesaplamaa = progressBar.progress.toString().toInt()

        /*
        object : CountDownTimer(timeSayac*1000, 1000) {
        override fun onFinish() {
            animasyonYazi.visibility = View.VISIBLE
            animasyonYazi.text = "Süren Bitti -50"
            skorSayi -= 50
            skor.text = "Skor = " + skorSayi.toString()
            timeSayac=10
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
            override fun onTick(p0: Long) {
                timeSayac--
            }
        }.start()

         */

        val ilkCarpimRandom = Random.nextInt(0, 30)
        val ikinciÇarpimRandom = Random.nextInt(0, 30)

        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()


        val rastgeleList = Random.nextInt(1, 5)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                if (kazandi.toString().toInt() == 0)
                {
                    kazandi++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }

            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
        } else if (rastgeleList == 2) {
            cevapIkı.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                if (kazandiIki.toString().toInt() == 0)
                {
                    kazandiIki++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
        } else if (rastgeleList == 3) {
            cevapUc.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                if (kazandiUc.toString().toInt() == 0)
                {
                    kazandiUc++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }

            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
        } else if (rastgeleList == 4) {
            cevapDort.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapUc.text = randomlarUc.toString()
            } else {
                cevapUc.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                if (kazandiDort.toString().toInt() == 0)
                {
                    kazandiDort++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }

            }


        }


    }


    private fun geciss() {
        reklamSayımı++

        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val view = View.inflate(this@toplamaIslemi, R.layout.yildiz, null)
        val builder = AlertDialog.Builder(this@toplamaIslemi)
        builder.setView(view)
        val soruSaniyeText = view.findViewById<TextView>(R.id.soruSaniye)
        val uyariMesaj = view.findViewById<TextView>(R.id.uyariMesaj)
        val yildizBir = view.findViewById<ImageView>(R.id.yildizBir)
        val yildizIki = view.findViewById<ImageView>(R.id.yildizIki)
        val yildizUc = view.findViewById<ImageView>(R.id.yildizUc)
        val skor = findViewById<TextView>(R.id.skor)
        //val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)



        if (reklamSayımı.toString().toInt() % 6 == 0) {
            reklamSayımı = 0
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



/*
        SÜRE (BETA)


        object : CountDownTimer(timeSayac*1000, 1000) {
        override fun onFinish() {
            animasyonYazi.visibility = View.VISIBLE
            animasyonYazi.text = "Süren Bitti -50"
            skorSayi -= 50
            skor.text = "Skor = " + skorSayi.toString()
            timeSayac=10
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
            override fun onTick(p0: Long) {
                timeSayac--
            }
        }.start()
*/
        var saniyeHesaplama = progressBar.progress.toString().toInt()/10
        if(saniyeHesaplama <= 9){
            soruSaniyeText.text = "Soruyu "+saniyeHesaplama.toString()+" Saniyede Çözdünnn"
        }else{
            soruSaniyeText.text = "Sanırım zaman yetmedi, Haydi Tekrar Yapalım!"
        }

        val konfetti = view.findViewById<KonfettiView>(R.id.viewKonfetti)

        konfetti.build()
            .addColors(Color.GREEN,Color.YELLOW,Color.WHITE,Color.GRAY,Color.RED)
            .setDirection(0.0, 0.1)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(3000L)
            .addShapes(nl.dionsegijn.konfetti.models.Shape.RECT, nl.dionsegijn.konfetti.models.Shape.CIRCLE)
            .addSizes(nl.dionsegijn.konfetti.models.Size(13))

            .setPosition(-100f, konfetti.width + 100f, -100f, -100f)
            .streamFor(50, 5000L)

        if (saniyeHesaplama <= 3)
        {
            uyariMesaj.text="Muhteşemmm!"
            yildizBir.visibility = View.VISIBLE
            yildizIki.visibility = View.VISIBLE
            yildizUc.visibility = View.VISIBLE
            uyariMesaj.setBackgroundColor(Color.BLACK)
            object : CountDownTimer(timeSayac*2000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.VISIBLE
                    animasyonYazi.text = "Erkenci +25"
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    timeSayac=1
                    object : CountDownTimer(time*2000, 1000) {
                        override fun onFinish() {
                            animasyonYazi.visibility = View.INVISIBLE
                            time=1
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


        }else if (saniyeHesaplama <= 6)
        {
            uyariMesaj.text="Mükemmell!!"
            yildizBir.visibility = View.VISIBLE
            yildizIki.visibility = View.VISIBLE
            object : CountDownTimer(timeSayac*2000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.VISIBLE
                    animasyonYazi.text = "Zamanında +15"
                    skorSayi += 15
                    skor.text = "Skor = " + skorSayi.toString()
                    timeSayac=1
                    object : CountDownTimer(time*2000, 1000) {
                        override fun onFinish() {
                            animasyonYazi.visibility = View.INVISIBLE
                            time=1
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
        }else if (saniyeHesaplama <= 9)
        {
            uyariMesaj.text="Süperr"
            uyariMesaj.setBackgroundColor(Color.WHITE)
            yildizIki.visibility = View.VISIBLE
            uyariMesaj.setTextColor(Color.BLACK)
            object : CountDownTimer(timeSayac*2000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.VISIBLE
                    animasyonYazi.text = "Geç +5"
                    skorSayi += 10
                    skor.text = "Skor = " + skorSayi.toString()
                    timeSayac=1
                    object : CountDownTimer(time*2000, 1000) {
                        override fun onFinish() {
                            animasyonYazi.visibility = View.INVISIBLE
                            time=1
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
            uyariMesaj.text="Başardınn!"
            uyariMesaj.setBackgroundColor(Color.WHITE)
            uyariMesaj.setTextColor(Color.BLACK)

        }

        progressBar.max = 0

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource((android.R.color.transparent))



        val rastgeleAcilirPencere = view.findViewById<ImageView>(R.id.acilirPencereRsgl)
        val menuPencere = view.findViewById<ImageView>(R.id.menuGecbaba)




        menuPencere.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        rastgeleAcilirPencere.setOnClickListener {
            sorular()
            dialog.dismiss()

        }
    }
    private fun artiOn(){
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val skor = findViewById<TextView>(R.id.skor)

        animasyonYazi.visibility = View.VISIBLE
        animasyonYazi.text = "+10"
        object : CountDownTimer(time*1000, 1000) {
            override fun onFinish() {
                animasyonYazi.visibility = View.INVISIBLE
                time=1
            }
            override fun onTick(p0: Long) {
                time--
            }
        }.start()

        if (skorSayi >= 99000000000){
            Toast.makeText(this,"Maksimum Sayıya Ulaştınız Tebrik Ederim! Skorunuz Sıfırlanacaktır.",Toast.LENGTH_SHORT).show()
            skorSayi = 0
            skor.text = "Şampiyon Oldun!"

        }

    }
    private fun eksiElli(){
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val canBir = findViewById<ImageView>(R.id.canBir)
        val canIki = findViewById<ImageView>(R.id.canIki)
        val canUc = findViewById<ImageView>(R.id.canUc)
        val ekran = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.ekran)
        val view = View.inflate(this@toplamaIslemi, R.layout.kybttin, null)
        val builder = AlertDialog.Builder(this@toplamaIslemi)
        builder.setView(view)
        val reklamizle = view.findViewById<ImageView>(R.id.reklamizle)
        val tekrarlaa = view.findViewById<ImageView>(R.id.tekrarlaGardas)
        val menuGecla = view.findViewById<ImageView>(R.id.menulagardas)
        val cevapBir = findViewById<TextView>(R.id.cevapbir)
        val cevapIkı = findViewById<TextView>(R.id.cevapiki)
        val cevapUc = findViewById<TextView>(R.id.cevapuc)
        val cevapDort = findViewById<TextView>(R.id.cevapdort)
        val skorGoster = view.findViewById<TextView>(R.id.skorGoster)
        val soruCozz = findViewById<TextView>(R.id.soruSayi)
        val skor = findViewById<TextView>(R.id.skor)
        val dialog = builder.create()


        MobileAds.initialize(this) {}

        var adRequest = AdRequest.Builder().build()
        RewardedAd.load(this,"ca-app-pub-6537190103014639/3523891627", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mRewardedAd = null
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                mRewardedAd = rewardedAd
            }
        })

        skorGoster.text = "Skorun = " + skorSayi.toString()
        animasyonYazi.visibility = View.VISIBLE
        animasyonYazi.text = "-50"

        canSayisi--
        if (canSayisi.toString().toInt() == 2){
            canBir.visibility = View.GONE
        }else if (canSayisi.toString().toInt() == 1){
            canIki.visibility = View.GONE
        }else if(canSayisi.toString().toInt() == 0){
            canUc.visibility = View.GONE
            dialog.show()
            ekran.visibility = View.GONE
        }else{

        }


        tekrarlaa.setOnClickListener {
            sorular()
            ekran.visibility = View.VISIBLE
            canSayisi = 3
            skorSayi = 0
            skor.text = "0"
            dialog.dismiss()
            soruCozz.text = "ilk sorudasın"
            canBir.visibility = View.VISIBLE
            canIki.visibility = View.VISIBLE
            canUc.visibility = View.VISIBLE
            soruSayi = 1
        }

        menuGecla.setOnClickListener {
            var int = Intent(this,MainActivity::class.java)
            startActivity(int)
        }

        reklamizle.setOnClickListener {
            if (mRewardedAd != null) {
                Toast.makeText(this,"Reklamdan Sonra Devam Edebileceksiniz.",Toast.LENGTH_SHORT).show()
                ekran.visibility = View.VISIBLE
                canSayisi = 3
                dialog.dismiss()
                canBir.visibility = View.VISIBLE
                canIki.visibility = View.VISIBLE
                canUc.visibility = View.VISIBLE
                mRewardedAd?.show(this, OnUserEarnedRewardListener() {
                    fun onUserEarnedReward(rewardItem: RewardItem) {
                        var rewardAmount = rewardItem.amount
                        var rewardType = rewardItem.type
                    }
                })
            } else {
                Toast.makeText(this,"Sanırım internetle ilgili sorun yaşanıyor :( Lütfen Tekrar Deneyin",Toast.LENGTH_SHORT).show()
            }
        }



        if(skorSayi.toString().toInt() <= -30000){
            Toast.makeText(this,"Sorun Sende Değil Bende :)) Bilerek Mi Yapıyorsunnn", Toast.LENGTH_SHORT).show()
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
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

    private fun pencere(){
        val view = View.inflate(this@toplamaIslemi, R.layout.yildiz, null)
        val builder = AlertDialog.Builder(this@toplamaIslemi)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource((android.R.color.transparent))
        val rastgeleAcilirPencere = view.findViewById<ImageView>(R.id.acilirPencereRsgl)
        val menuPencere = view.findViewById<ImageView>(R.id.menuGecbaba)

        menuPencere.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        rastgeleAcilirPencere.setOnClickListener {
            sorular()
            dialog.dismiss()

        }

    }
    private fun sorular(){
        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
        val cevapBir = findViewById<TextView>(R.id.cevapbir)
        val cevapIkı = findViewById<TextView>(R.id.cevapiki)
        val cevapUc = findViewById<TextView>(R.id.cevapuc)
        val cevapDort = findViewById<TextView>(R.id.cevapdort)
        val soruCozz = findViewById<TextView>(R.id.soruSayi)
        val skor = findViewById<TextView>(R.id.skor)
        //val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        kbir = 0
        kiki = 0
        kuc = 0
        kdort = 0

        soruSayi++
        cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
        cevapBir.setTextColor(Color.parseColor("#A66A11"))
        cevapIkı.setTextColor(Color.parseColor("#A66A11"))
        cevapUc.setTextColor(Color.parseColor("#A66A11"))
        cevapDort.setTextColor(Color.parseColor("#A66A11"))



        if (soruSayi <= 1) {
            soruCozz.text = soruSayi.toString()+". Soru"
        } else if (soruSayi <= 20) {
            soruCozz.text = soruSayi.toString()+". Soru"
            soruCozz.setTextColor(Color.parseColor("#730202"))

        } else if (soruSayi <= 32) {
            soruCozz.text = soruSayi.toString()+". Soru"
            soruCozz.setTextColor(Color.parseColor("#FF3F51B5"))
        } else if (soruSayi <= 45) {
            soruCozz.text = soruSayi.toString()+". Soru"
            soruCozz.setTextColor(Color.parseColor("#FF3700B3"))
        } else if (soruSayi <= 66) {
            soruCozz.text = soruSayi.toString()+". Soru"
            soruCozz.setTextColor(Color.parseColor("#FF072533"))
        } else {
            soruCozz.text = soruSayi.toString()+". Soru"
            soruCozz.setTextColor(Color.BLACK)

        }

        val ilkCarpimRandom = Random.nextInt(0, 30)
        val ikinciÇarpimRandom = Random.nextInt(0, 30)
        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()

        progressBar.max = 100

        val currentProgress = 100
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(10000)
            .start()

        val rastgeleList = Random.nextInt(1, 5)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
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
                    geciss()
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }

            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
        } else if (rastgeleList == 2) {
            cevapIkı.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                if (kiki.toString().toInt() == 0)
                {
                    kiki++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
                }

            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
        } else if (rastgeleList == 3) {
            cevapUc.text = i.toString()
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                if (kuc.toString().toInt() == 0)
                {
                    kuc++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)",Toast.LENGTH_SHORT).show()
                    pencere()
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
            val randomlar = Random.nextInt(0, 60)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 60)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 60)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 60)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 60)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 60)
                cevapUc.text = randomlarUc.toString()
            } else {
                cevapUc.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                skorSayi -= 50
                skor.text = "Skor = " + skorSayi.toString()
                eksiElli()
            }
            cevapDort.setOnClickListener {
                if (kdort.toString().toInt() == 0) {
                    kdort++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    geciss()
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    skorSayi += 25
                    skor.text = "Skor = " + skorSayi.toString()
                    artiOn()
                } else {
                    Toast.makeText(this, "Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
                }
            }
        }
    }
}