package com.example.toplamacikarmaoyunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class saymaSayilar : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd? = null
    private var saymaSayi:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayma_sayilar)
        var anaSayfaSayilar = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.sayilarArti)
        var gec = findViewById<TextView>(R.id.gec)
        var cikis = findViewById<TextView>(R.id.cikis)

        cikis.setOnClickListener {
            saymaSayi = 1
            var anaSayfa = Intent(this,MainActivity::class.java)
            startActivity(anaSayfa)
        }

        gec.setOnClickListener {
            sayma()
        }


    }
    private fun sayma(){
        var gec = findViewById<TextView>(R.id.gec)
        var anaSayfaSayilar = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.sayilarArti)

        saymaSayi++

        if (saymaSayi == 1){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.bir)
        }else if (saymaSayi == 2){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.iki)
        }else if (saymaSayi == 3){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.uc)
        }else if (saymaSayi == 4){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.dort)
        }else if (saymaSayi == 5){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.bes)
        }else if (saymaSayi == 6){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.alti)
        }else if (saymaSayi == 7){
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
            anaSayfaSayilar.setBackgroundResource(R.mipmap.yedi)
        }else if (saymaSayi == 8){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.sekiz)
        }else if (saymaSayi == 9){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.dokuz)
        }else if (saymaSayi == 10){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.on)
        }else if (saymaSayi == 11){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.ebir)
        }else if (saymaSayi == 12){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.eiki)
        }else if (saymaSayi == 13){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.euc)
        }else if (saymaSayi == 14){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.edort)
        }else if (saymaSayi == 15){
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
            anaSayfaSayilar.setBackgroundResource(R.mipmap.ebes)
        }else if (saymaSayi == 16){
            anaSayfaSayilar.setBackgroundResource(R.mipmap.ealti)
        }else{
            saymaSayi = 1
            var anaSayfa = Intent(this,MainActivity::class.java)
            startActivity(anaSayfa)
        }
    }
}