package com.example.toplamacikarmaoyunu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.util.*

class rakamlariYaz : AppCompatActivity() {
    lateinit var mAdView : AdView
    var rakamSayi = 1
    var secim = ""
        val rakalmarCek = arrayListOf(
        R.mipmap.birrakam,
        R.mipmap.ikirakam,
        R.mipmap.ucrakam,
        R.mipmap.dortrakam,
        R.mipmap.besrakam,
        R.mipmap.altirakam,
        R.mipmap.yedirakam,
        R.mipmap.sekizrakam,
        R.mipmap.dokuzrakam
    )

    override fun onCreate(savedInstanceState: Bundle?) {
               super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rakamlari_yaz)
        var cevaplama = findViewById<TextView>(R.id.cevaplama)
        var kontrolEt = findViewById<TextView>(R.id.kontrolEt)
        var rakamYeri = findViewById<ImageView>(R.id.rakamYeri)
        val view = View.inflate(this@rakamlariYaz, R.layout.secim, null)
        val builder = AlertDialog.Builder(this@rakamlariYaz)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        MobileAds.initialize(this) {}
        val adView = AdView(this)
        //adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6537190103014639/6523225562"
        mAdView = findViewById(R.id.adView3)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        if (secim.toString() == ""){
            kontrolEt.text = "Seçim yap"
            cevaplama.visibility = View.INVISIBLE
            kontrolEt.setOnClickListener {
                dialog.show()
            }
        }

        var rastgeleButtone = view.findViewById<TextView>(R.id.rastgeleButton)
        var siraliButtone = view.findViewById<TextView>(R.id.siraliButton)




        rastgeleButtone.setOnClickListener {
            secim = "rastgele"
            rastgele()
            dialog.dismiss()
            kontrolEt.text = "Kontrol Et"
            cevaplama.visibility = View.VISIBLE
        }
        siraliButtone.setOnClickListener {
            secim = "sirali"
            sirali()
            dialog.dismiss()
            kontrolEt.text = "Kontrol Et"
            cevaplama.visibility = View.VISIBLE
        }
    }
    private fun rastgele() {
        var cevaplama = findViewById<TextView>(R.id.cevaplama)
        var kontrolEt = findViewById<TextView>(R.id.kontrolEt)
        var rakamYeri = findViewById<ImageView>(R.id.rakamYeri)

        var arkaPlan =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.arkaPlanRakam)

        val random = Random()
        val button = random.nextInt(rakalmarCek.count())
        rakamYeri.setImageResource(rakalmarCek[button])

            kontrolEt.setOnClickListener {
                if (button.toString().toInt() == 0) {

                    if (cevaplama.text.toString() == "") {
                    Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                } else {
                    if (cevaplama.text.toString() == "bir" || cevaplama.text.toString() == "Bir") {
                        Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                        rakamSayi++



                        arkaPlan.setBackgroundColor(Color.GREEN)
                        object : CountDownTimer(timeSayac * 600, 1000) {
                            override fun onFinish() {
                                object : CountDownTimer(time * 600, 1000) {
                                    override fun onFinish() {
                                        time = 1
                                        cevaplama.text = ""
                                        arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                        rastgele()
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
                    else {
                        arkaPlan.setBackgroundColor(Color.RED)
                        object : CountDownTimer(timeSayac * 400, 1000) {
                            override fun onFinish() {
                                object : CountDownTimer(time * 400, 1000) {
                                    override fun onFinish() {
                                        time = 1
                                        cevaplama.text = ""
                                        arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
                else if (button.toString().toInt() == 1) {

                    if (cevaplama.text.toString() == "") {
                        Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                    } else {
                        if (cevaplama.text.toString() == "iki" || cevaplama.text.toString() == "İki") {
                            Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                            rakamSayi++



                            arkaPlan.setBackgroundColor(Color.GREEN)
                            object : CountDownTimer(timeSayac * 600, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 600, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                            rastgele()
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
                        else {
                            arkaPlan.setBackgroundColor(Color.RED)
                            object : CountDownTimer(timeSayac * 400, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 400, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
                }else if (button.toString().toInt() == 2) {

                    if (cevaplama.text.toString() == "") {
                        Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                    } else {
                        if (cevaplama.text.toString() == "üç" || cevaplama.text.toString() == "Üç") {
                            Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                            rakamSayi++



                            arkaPlan.setBackgroundColor(Color.GREEN)
                            object : CountDownTimer(timeSayac * 600, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 600, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                            rastgele()
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
                        else {
                            arkaPlan.setBackgroundColor(Color.RED)
                            object : CountDownTimer(timeSayac * 400, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 400, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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

                }else if (button.toString().toInt() == 3) {

                    if (cevaplama.text.toString() == "") {
                        Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                    } else {
                        if (cevaplama.text.toString() == "dört" || cevaplama.text.toString() == "Dört") {
                            Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                            rakamSayi++



                            arkaPlan.setBackgroundColor(Color.GREEN)
                            object : CountDownTimer(timeSayac * 600, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 600, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                            rastgele()
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
                        else {
                            arkaPlan.setBackgroundColor(Color.RED)
                            object : CountDownTimer(timeSayac * 400, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 400, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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

                }else if (button.toString().toInt() == 4) {

                    if (cevaplama.text.toString() == "") {
                        Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                    } else {
                        if (cevaplama.text.toString() == "beş" || cevaplama.text.toString() == "Beş") {
                            Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                            rakamSayi++



                            arkaPlan.setBackgroundColor(Color.GREEN)
                            object : CountDownTimer(timeSayac * 600, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 600, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                            rastgele()
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
                        else {
                            arkaPlan.setBackgroundColor(Color.RED)
                            object : CountDownTimer(timeSayac * 400, 1000) {
                                override fun onFinish() {
                                    object : CountDownTimer(time * 400, 1000) {
                                        override fun onFinish() {
                                            time = 1
                                            cevaplama.text = ""
                                            arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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

                }else if (button.toString().toInt() == 5) {

                        if (cevaplama.text.toString() == "") {
                            Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                        } else {
                            if (cevaplama.text.toString() == "alti" || cevaplama.text.toString() == "Alti") {
                                Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                                rakamSayi++



                                arkaPlan.setBackgroundColor(Color.GREEN)
                                object : CountDownTimer(timeSayac * 600, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 600, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                                rastgele()
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
                            else {
                                arkaPlan.setBackgroundColor(Color.RED)
                                object : CountDownTimer(timeSayac * 400, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 400, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
                }else if (button.toString() == "6") {

                        if (cevaplama.text.toString() == "") {
                            Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                        } else {
                            if (cevaplama.text.toString() == "yedi" || cevaplama.text.toString() == "Yedi") {
                                Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                                rakamSayi++



                                arkaPlan.setBackgroundColor(Color.GREEN)
                                object : CountDownTimer(timeSayac * 600, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 600, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                                rastgele()
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
                            else {
                                arkaPlan.setBackgroundColor(Color.RED)
                                object : CountDownTimer(timeSayac * 400, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 400, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
                }else if (button.toString() == "7") {

                        if (cevaplama.text.toString() == "") {
                            Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                        } else {
                            if (cevaplama.text.toString() == "sekiz" || cevaplama.text.toString() == "Sekiz") {
                                Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                                rakamSayi++



                                arkaPlan.setBackgroundColor(Color.GREEN)
                                object : CountDownTimer(timeSayac * 600, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 600, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                                rastgele()
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
                            else {
                                arkaPlan.setBackgroundColor(Color.RED)
                                object : CountDownTimer(timeSayac * 400, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 400, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
                else if (button.toString() == "8") {

                        if (cevaplama.text.toString() == "") {
                            Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
                        } else {
                            if (cevaplama.text.toString() == "dokuz" || cevaplama.text.toString() == "Dokuz") {
                                Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                                rakamSayi++



                                arkaPlan.setBackgroundColor(Color.GREEN)
                                object : CountDownTimer(timeSayac * 600, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 600, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                                rastgele()
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
                            else {
                                arkaPlan.setBackgroundColor(Color.RED)
                                object : CountDownTimer(timeSayac * 400, 1000) {
                                    override fun onFinish() {
                                        object : CountDownTimer(time * 400, 1000) {
                                            override fun onFinish() {
                                                time = 1
                                                cevaplama.text = ""
                                                arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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
    private fun sirali(){
        var cevaplama = findViewById<TextView>(R.id.cevaplama)
        var kontrolEt = findViewById<TextView>(R.id.kontrolEt)
        var rakamYeri = findViewById<ImageView>(R.id.rakamYeri)

        var arkaPlan = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.arkaPlanRakam)

        if (rakamSayi == 1){
            rakamYeri.setBackgroundResource(R.mipmap.birrakam)

        }
        kontrolEt.setOnClickListener {
            if (cevaplama.text.toString() == "") {
                Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show()
            } else {
                if (rakamSayi == 1 && cevaplama.text.toString() == "bir" || cevaplama.text.toString() == "Bir") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++



                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.ikirakam)
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


                } else if (rakamSayi == 2 && cevaplama.text.toString() == "iki" || cevaplama.text.toString() == "İki") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.ucrakam)
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
                } else if (rakamSayi == 3 && cevaplama.text.toString() == "üç" || cevaplama.text.toString() == "Üç") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.dortrakam)
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
                } else if (rakamSayi == 4 && cevaplama.text.toString() == "dört" || cevaplama.text.toString() == "Dört") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.besrakam)
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
                } else if (rakamSayi == 5 && cevaplama.text.toString() == "beş" || cevaplama.text.toString() == "Beş") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.altirakam)
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
                } else if (rakamSayi == 6 && cevaplama.text.toString() == "altı" || cevaplama.text.toString() == "Altı") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.yedirakam)
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

                } else if (rakamSayi == 7 && cevaplama.text.toString() == "yedi" || cevaplama.text.toString() == "Yedi") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.sekizrakam)
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
                } else if (rakamSayi == 8 && cevaplama.text.toString() == "sekiz" || cevaplama.text.toString() == "Sekiz") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi++
                    arkaPlan.setBackgroundColor(Color.GREEN)
                    object : CountDownTimer(timeSayac * 600, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 600, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
                                    rakamYeri.setBackgroundResource(R.mipmap.dokuzrakam)
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
                } else if (rakamSayi == 9 && cevaplama.text.toString() == "dokuz" || cevaplama.text.toString() == "Dokuz") {
                    Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show()
                    rakamSayi = 1
                    rakamYeri.setBackgroundResource(R.mipmap.birrakam)
                } else {
                    arkaPlan.setBackgroundColor(Color.RED)
                    object : CountDownTimer(timeSayac * 400, 1000) {
                        override fun onFinish() {
                            object : CountDownTimer(time * 400, 1000) {
                                override fun onFinish() {
                                    time = 1
                                    cevaplama.text = ""
                                    arkaPlan.setBackgroundColor(Color.parseColor("#03A9F4"))
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