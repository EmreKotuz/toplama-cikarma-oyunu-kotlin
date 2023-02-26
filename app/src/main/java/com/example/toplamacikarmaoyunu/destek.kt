package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import org.w3c.dom.Text

class destek : AppCompatActivity() {
    private var mRewardedAd: RewardedAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destek)
        var yildiz = findViewById<TextView>(R.id.yildizver)
        var reklem = findViewById<TextView>(R.id.reklamizle)

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
        yildiz.setOnClickListener {
            val webSite = Intent(Intent.ACTION_VIEW)
            webSite.data = Uri.parse("https://play.google.com/store/apps/details?id=com.kotuzstudio.toplamacikarmaoyunu")
            startActivity(webSite)
        }

        reklem.setOnClickListener {

            if (mRewardedAd != null) {
                mRewardedAd?.show(this, OnUserEarnedRewardListener() {
                    fun onUserEarnedReward(rewardItem: RewardItem) {
                        var rewardAmount = rewardItem.amount
                        var rewardType = rewardItem.type
                        Toast.makeText(this,"Teşekkür ederiz <3",Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this,"Sanırım internetle ilgili sorun yaşanıyor :( Lütfen Tekrar Deneyin",Toast.LENGTH_SHORT).show()
            }

        }
    }
}