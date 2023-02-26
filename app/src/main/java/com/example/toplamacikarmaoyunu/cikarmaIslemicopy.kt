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
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import kotlin.random.Random

class cikarmaIslemicopy : AppCompatActivity() {
    private var soruSayi = 1
    private var skorSayi = 0
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "cikarmaIslemi"
    private var reklamSayımı = 0

    var kbir:Int = 0
    var kiki:Int = 0
    var kuc:Int = 0
    var kdort:Int = 0
    var cansayisi = 3

    var timeSayac:Long=1
    var reklamSayıcı = 0
    var mediaPlayer: MediaPlayer? = null
    var time: Long = 1

    lateinit var mAdView: AdView
    private var mRewardedAd: RewardedAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cikarma_islemi)
        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpimm)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpimm)
        val cevapBir = findViewById<TextView>(R.id.cevapbirr)
        val cevapIkı = findViewById<TextView>(R.id.cevapikii)
        val cevapUc = findViewById<TextView>(R.id.cevapucc)
        val cevapDort = findViewById<TextView>(R.id.cevapdortt)
        val cevap = findViewById<TextView>(R.id.cevapp)
        //val degistir = findViewById<TextView>(R.id.degistir2)
        val ekrann = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.ekrana)
        val soruCozz = findViewById<TextView>(R.id.soruSayi2)
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi3)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val anaSayfa2 = findViewById<ImageView>(R.id.anaSayfa2)

        //cevaplar
        var kazandi:Int = 0
        var kazandiIki:Int = 0
        var kazandiUc:Int = 0
        var kazandiDort:Int = 0
        var kbir:Int = 0
        var kiki:Int = 0
        var kuc:Int = 0
        var kdort:Int = 0

        //ads
        MobileAds.initialize(this) {}
        val adView = AdView(this)
        //adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/6523225562"
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)




        anaSayfa2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //progressBar süre beta+
        progressBar.max = 100
        val currentProgress = 100
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(10000)
            .start()

        val ilkCarpimRandom = Random.nextInt(0, 15)
        val ikinciÇarpimRandom = Random.nextInt(0, 15)

        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() - ikinciCarpim.text.toString().toInt()
        val rastgeleList = Random.nextInt(1, 5)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(-15, 15)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-15, 15)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-15, 15)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-15, 15)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-15, 15)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-15, 15)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-15, 15)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-15, 15)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-15, 15)
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
                    fonksiyondegisken()
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
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
            val randomlar = Random.nextInt(-15, 15)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-15, 15)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-15, 15)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                if (kazandiIki.toString().toInt() == 0)
                {
                    kazandiIki++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    fonksiyondegisken()
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
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
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                if (kazandiUc.toString().toInt() == 0)
                {
                    kazandiUc++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    fonksiyondegisken()
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
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
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                if (kazandiDort.toString().toInt() == 0)
                {
                    kazandiDort++
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    fonksiyondegisken()
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
                }
            }
        }


    }

    private fun fonksiyondegisken() {
        reklamSayımı++
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val view = View.inflate(this@cikarmaIslemicopy, R.layout.yildiz, null)
        val builder = AlertDialog.Builder(this@cikarmaIslemicopy)
        builder.setView(view)
        val soruSaniyeText = view.findViewById<TextView>(R.id.soruSaniye)
        val uyariMesaj = view.findViewById<TextView>(R.id.uyariMesaj)
        val yildizBir = view.findViewById<ImageView>(R.id.yildizBir)
        val yildizIki = view.findViewById<ImageView>(R.id.yildizIki)
        val yildizUc = view.findViewById<ImageView>(R.id.yildizUc)
        val skorYazi = findViewById<TextView>(R.id.skorYazi)
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi3)

        //cevaplar




        if(reklamSayımı.toString().toInt() % 2 == 0){
            reklamSayımı = 0
            var adRequest = AdRequest.Builder().build()
            InterstitialAd.load(this,"ca-app-pub-6537190103014639/8087867913", adRequest, object : InterstitialAdLoadCallback() {
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



        var saniyeHesaplamaCikti = progressBar.progress.toString().toInt() / 10
        if (saniyeHesaplamaCikti <= 9) {
            soruSaniyeText.text = "Soruyu " + saniyeHesaplamaCikti.toString() + " Saniyede Çözdünnn"
        } else {
            soruSaniyeText.text = "Sanırım zaman yetmedi, Haydi Tekrar Yapalım!"
        }

        val konfetti = view.findViewById<KonfettiView>(R.id.viewKonfetti)

        konfetti.build()
            .addColors(Color.GREEN, Color.YELLOW, Color.WHITE, Color.GRAY, Color.RED)
            .setDirection(0.0, 0.1)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(3000L)
            .addShapes(Shape.RECT, Shape.CIRCLE)
            .addSizes(Size(13))

            .setPosition(
                -100f,
                konfetti.width + 100f,
                -100f,
                -100f
            ) // and change position from here
            .streamFor(50, 5000L)

        if (saniyeHesaplamaCikti <= 3) {
            uyariMesaj.text = "Muhteşemmm!"
            yildizBir.visibility = View.VISIBLE
            yildizIki.visibility = View.VISIBLE
            yildizUc.visibility = View.VISIBLE
            uyariMesaj.setBackgroundColor(Color.BLACK)


            object : CountDownTimer(timeSayac*2000, 1000) {
            override fun onFinish() {
                animasyonYazi.visibility = View.VISIBLE
                animasyonYazi.text = "Erkenci +25"
                skorSayi += 25
                skorYazi.text = "Skor = " + skorSayi.toString()
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

        } else if (saniyeHesaplamaCikti <= 6) {
            uyariMesaj.text = "Mükemmell!!"
            yildizBir.visibility = View.VISIBLE
            yildizIki.visibility = View.VISIBLE
            object : CountDownTimer(timeSayac*2000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.VISIBLE
                    animasyonYazi.text = "Zamanında +15"
                    skorSayi += 15
                    skorYazi.text = "Skor = " + skorSayi.toString()
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
        } else if (saniyeHesaplamaCikti <= 9) {
            uyariMesaj.text = "Süperr"
            uyariMesaj.setBackgroundColor(Color.WHITE)
            yildizIki.visibility = View.VISIBLE
            uyariMesaj.setTextColor(Color.BLACK)
            object : CountDownTimer(timeSayac*2000, 1000) {
                override fun onFinish() {
                    animasyonYazi.visibility = View.VISIBLE
                    animasyonYazi.text = "Geç +5"
                    skorSayi += 10
                    skorYazi.text = "Skor = " + skorSayi.toString()
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
        } else {
            uyariMesaj.text = "Başardınn!"
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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        rastgeleAcilirPencere.setOnClickListener {
            sorular()
            dialog.dismiss()
        }

    }

    private fun artiOn() {
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi3)
        val skorYazi = findViewById<TextView>(R.id.skorYazi)

        animasyonYazi.visibility = View.VISIBLE
        animasyonYazi.text = "+10"
        skorSayi += 10
        skorYazi.text = "Skor = "+skorSayi
        object : CountDownTimer(time * 1000, 1000) {
            override fun onFinish() {
                animasyonYazi.visibility = View.INVISIBLE
                time = 1
            }

            override fun onTick(p0: Long) {
                time--
            }
        }.start()
    }

    private fun eksiElli() {
        val animasyonYazi = findViewById<TextView>(R.id.animasyonYazi3)
        val skorYazi = findViewById<TextView>(R.id.skorYazi)
        val caniBir = findViewById<ImageView>(R.id.caniBir)
        val ekran = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.ekrana)
        val caniIki = findViewById<ImageView>(R.id.caniIki)
        val caniUc = findViewById<ImageView>(R.id.caniUc)
        val view = View.inflate(this@cikarmaIslemicopy, R.layout.kybttin, null)
        val builder = AlertDialog.Builder(this@cikarmaIslemicopy)
        builder.setView(view)
        val reklamizle = view.findViewById<ImageView>(R.id.reklamizle)
        val tekrarlaa = view.findViewById<ImageView>(R.id.tekrarlaGardas)
        val menuGecla = view.findViewById<ImageView>(R.id.menulagardas)
        val skorGoster = view.findViewById<TextView>(R.id.skorGoster)
        val soruCozz = findViewById<TextView>(R.id.soruSayi2)
        val skorYazii = findViewById<TextView>(R.id.skorYazi)

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

        val dialog = builder.create()

        animasyonYazi.visibility = View.VISIBLE
        animasyonYazi.text = "-50"
        skorSayi -= 50
        skorYazi.text = "Skor = "+skorSayi
        skorGoster.text = "Skorun = " + skorSayi.toString()

        cansayisi--
        if (cansayisi.toString().toInt() == 2){
            caniBir.visibility = View.GONE
        }else if (cansayisi.toString().toInt() == 1){
            caniIki.visibility = View.GONE
        }else if(cansayisi.toString().toInt() == 0){
            caniUc.visibility = View.GONE
            dialog.show()
            ekran.visibility = View.GONE
        }else{

        }
        tekrarlaa.setOnClickListener {
            sorular()
            ekran.visibility = View.VISIBLE
            cansayisi = 3
            skorSayi = 0
            skorYazii.text = "0"
            dialog.dismiss()
            soruCozz.text = "ilk sorudasın"
            caniBir.visibility = View.VISIBLE
            caniIki.visibility = View.VISIBLE
            caniUc.visibility = View.VISIBLE
            soruSayi = 1
        }
        reklamizle.setOnClickListener {
            if (mRewardedAd != null) {
                Toast.makeText(this,"Reklamdan Sonra Devam Edebileceksiniz.",Toast.LENGTH_SHORT).show()
                ekran.visibility = View.VISIBLE
                cansayisi = 3
                dialog.dismiss()
                caniBir.visibility = View.VISIBLE
                caniIki.visibility = View.VISIBLE
                caniUc.visibility = View.VISIBLE
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
        menuGecla.setOnClickListener {
            var int = Intent(this,MainActivity::class.java)
            startActivity(int)
        }

        if(skorSayi.toString().toInt() <= -30000){
            Toast.makeText(this,"Sorun Sende Değil Bende :)) Bilerek Mi Yapıyorsunnn", Toast.LENGTH_SHORT).show()
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        object : CountDownTimer(time * 1000, 1000) {
            override fun onFinish() {
                animasyonYazi.visibility = View.INVISIBLE
                time = 1
            }

            override fun onTick(p0: Long) {
                time--
            }
        }.start()
    }
    private fun pencere() {
        val view = View.inflate(this@cikarmaIslemicopy, R.layout.yildiz, null)
        val builder = AlertDialog.Builder(this@cikarmaIslemicopy)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource((android.R.color.transparent))
        val rastgeleAcilirPencere = view.findViewById<ImageView>(R.id.acilirPencereRsgl)
        val menuPencere = view.findViewById<ImageView>(R.id.menuGecbaba)

        menuPencere.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        rastgeleAcilirPencere.setOnClickListener {
            sorular()
            dialog.dismiss()

        }

    }
    private fun sorular(){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)

        val ilkCarpim = findViewById<TextView>(R.id.ilkcarpimm)
        val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpimm)
        val cevapBir = findViewById<TextView>(R.id.cevapbirr)
        val cevapIkı = findViewById<TextView>(R.id.cevapikii)
        val cevapUc = findViewById<TextView>(R.id.cevapucc)
        val cevapDort = findViewById<TextView>(R.id.cevapdortt)
        val cevap = findViewById<TextView>(R.id.cevapp)
        //val degistir = findViewById<TextView>(R.id.degistir2)
        val ekrann = findViewById<ConstraintLayout>(R.id.ekrana)
        val soruCozz = findViewById<TextView>(R.id.soruSayi2)
        soruSayi++
        cevapBir.setBackgroundColor(Color.parseColor("#FFFFFF"))
        cevapIkı.setBackgroundColor(Color.parseColor("#FFFFFF"))
        cevapUc.setBackgroundColor(Color.parseColor("#FFFFFF"))
        cevapDort.setBackgroundColor(Color.parseColor("#FFFFFF"))
        cevapBir.setTextColor(Color.parseColor("#A66A11"))
        cevapIkı.setTextColor(Color.parseColor("#A66A11"))
        cevapUc.setTextColor(Color.parseColor("#A66A11"))
        cevapDort.setTextColor(Color.parseColor("#A66A11"))

        kbir = 0
        kiki = 0
        kuc = 0
        kdort = 0


        if (soruSayi <= 10) {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
        } else if (soruSayi <= 2) {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
        } else if (soruSayi <= 3) {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
        } else if (soruSayi <= 4) {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
            soruCozz.setTextColor(Color.parseColor("#ff8c00"))
        } else if (soruSayi <= 5) {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
            soruCozz.setTextColor(Color.parseColor("#ee6a50"))
        } else {
            soruCozz.text = soruSayi.toString() + ". Sorudasın"
            soruCozz.setTextColor(Color.parseColor("#c60000"))
        }


        val ilkCarpimRandom = Random.nextInt(0, 15)
        val ikinciÇarpimRandom = Random.nextInt(0, 15)
        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() - ikinciCarpim.text.toString().toInt()

        progressBar.max = 100

        val currentProgress = 100
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(13000)
            .start()

        val rastgeleList = Random.nextInt(1, 5)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                    fonksiyondegisken()
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
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
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                    fonksiyondegisken()
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
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
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                    fonksiyondegisken()
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
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
            val randomlar = Random.nextInt(-21, 21)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(-21, 21)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(-21, 21)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(-21, 21)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(-21, 21)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(-21, 21)
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
                    fonksiyondegisken()
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    artiOn()
                }else{
                    Toast.makeText(this,"Çok Uyanıksın :)", Toast.LENGTH_SHORT).show()
                    pencere()
                }
            }

        }
    }
}