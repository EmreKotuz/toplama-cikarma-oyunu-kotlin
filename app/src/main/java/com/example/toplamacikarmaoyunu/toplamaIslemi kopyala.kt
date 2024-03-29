/*
* package com.example.toplamacikarmaoyunu

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class toplamaIslemi : AppCompatActivity() {
    private var soruSayi = 1

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
        val degistir = findViewById<TextView>(R.id.degistir)
        val ekrann = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.ekran)
        val soruCozz = findViewById<TextView>(R.id.soruCoz2)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)



        progressBar.max = 100

        val currentProgress = 100
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(13000)
            .start()




        val ilkCarpimRandom = Random.nextInt(0, 15)
        val ikinciÇarpimRandom = Random.nextInt(0, 15)

        ilkCarpim.text = ilkCarpimRandom.toString()
        ikinciCarpim.text = ikinciÇarpimRandom.toString()

        val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()


        val rastgeleList = Random.nextInt(1, 4)
        if (rastgeleList == 1) {
            cevapBir.text = i.toString()
            val randomlar = Random.nextInt(0, 30)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapIkı.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapIkı.text = randomlar.toString()
            } else {
                cevapIkı.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 30)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 30)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.alkis)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                geciss()
                cevapBir.setTextColor(Color.parseColor("#ffffff"))

            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
            }
        } else if (rastgeleList == 2) {
            cevapIkı.text = i.toString()
            val randomlar = Random.nextInt(0, 30)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 30)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapUc.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapUc.text = randomlarIki.toString()
            } else {
                cevapUc.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 30)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.alkis)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                geciss()

            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
            }
        } else if (rastgeleList == 3) {
            cevapUc.text = i.toString()
            val randomlar = Random.nextInt(0, 30)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 30)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 30)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapDort.text = randomlarUc.toString()
            } else {
                cevapDort.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.alkis)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
                geciss()

            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
            }
        } else if (rastgeleList == 4) {
            cevapDort.text = i.toString()
            val randomlar = Random.nextInt(0, 30)
            if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else if (i.toString() == randomlar.toString()) {
                val randomlar = Random.nextInt(0, 30)
                cevapBir.text = randomlar.toString()
            } else {
                cevapBir.text = randomlar.toString()
            }

            val randomlarIki = Random.nextInt(0, 30)
            if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapIkı.text = randomlarIki.toString()
            } else if (i.toString() == randomlarIki.toString()) {
                val randomlarIki = Random.nextInt(0, 30)
                cevapIkı.text = randomlarIki.toString()
            } else {
                cevapIkı.text = randomlarIki.toString()
            }

            val randomlarUc = Random.nextInt(0, 30)
            if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapUc.text = randomlarUc.toString()
            } else if (i.toString() == randomlarUc.toString()) {
                val randomlarUc = Random.nextInt(0, 30)
                cevapUc.text = randomlarUc.toString()
            } else {
                cevapUc.text = randomlarUc.toString()
            }


            cevapBir.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapBir.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapIkı.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapIkı.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapUc.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.kaybetti)
                ply?.start()
                cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                cevapUc.setTextColor(Color.parseColor("#ffffff"))
            }
            cevapDort.setOnClickListener {
                val ply = MediaPlayer.create(this, R.raw.alkis)
                ply?.start()
                cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                cevapDort.setTextColor(Color.parseColor("#ffffff"))
                geciss()

            }
        }

        degistir.setOnClickListener {
            soruSayi++
            cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapBir.setTextColor(Color.parseColor("#A66A11"))
            cevapIkı.setTextColor(Color.parseColor("#A66A11"))
            cevapUc.setTextColor(Color.parseColor("#A66A11"))
            cevapDort.setTextColor(Color.parseColor("#A66A11"))



            if (soruSayi <= 10) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 20) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 30) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 45) {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#ff8c00"))
            } else if (soruSayi <= 65) {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#ee6a50"))
            } else {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#c60000"))
            }

            val ilkCarpimRandom = Random.nextInt(0, 15)
            val ikinciÇarpimRandom = Random.nextInt(0, 15)
            ilkCarpim.text = ilkCarpimRandom.toString()
            ikinciCarpim.text = ikinciÇarpimRandom.toString()

            val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()

            val rastgeleList = Random.nextInt(1, 4)
            if (rastgeleList == 1) {
                cevapBir.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapIkı.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapIkı.text = randomlar.toString()
                } else {
                    cevapIkı.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 2) {
                cevapIkı.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 3) {
                cevapUc.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 4) {
                cevapDort.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapUc.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapUc.text = randomlarUc.toString()
                } else {
                    cevapUc.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }

            }

        }


    }










    private fun geciss(){
        val view = View.inflate(this@toplamaIslemi,R.layout.yildiz,null)
        val builder = AlertDialog.Builder(this@toplamaIslemi)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource((android.R.color.transparent))

        val rastgeleAcilirPencere = view.findViewById<ImageView>(R.id.acilirPencereRsgl)
        val menuPencere = view.findViewById<ImageView>(R.id.menuGec)

        menuPencere.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        rastgeleAcilirPencere.setOnClickListener {
            dialog.dismiss()
            val ilkCarpim = findViewById<TextView>(R.id.ilkcarpim)
            val ikinciCarpim = findViewById<TextView>(R.id.ikincicarpim)
            val cevapBir = findViewById<TextView>(R.id.cevapbir)
            val cevapIkı = findViewById<TextView>(R.id.cevapiki)
            val cevapUc = findViewById<TextView>(R.id.cevapuc)
            val cevapDort = findViewById<TextView>(R.id.cevapdort)
            val soruCozz = findViewById<TextView>(R.id.soruCoz2)

            soruSayi++
            cevapBir.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapIkı.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapUc.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapDort.setBackgroundColor(Color.parseColor("#ffffff"))
            cevapBir.setTextColor(Color.parseColor("#A66A11"))
            cevapIkı.setTextColor(Color.parseColor("#A66A11"))
            cevapUc.setTextColor(Color.parseColor("#A66A11"))
            cevapDort.setTextColor(Color.parseColor("#A66A11"))



            if (soruSayi <= 10) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 20) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 30) {
                soruCozz.text = soruSayi.toString()+"."
            } else if (soruSayi <= 45) {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#ff8c00"))
            } else if (soruSayi <= 65) {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#ee6a50"))
            } else {
                soruCozz.text = soruSayi.toString()+"."
                soruCozz.setBackgroundColor(Color.parseColor("#c60000"))
            }

            val ilkCarpimRandom = Random.nextInt(0, 15)
            val ikinciÇarpimRandom = Random.nextInt(0, 15)
            ilkCarpim.text = ilkCarpimRandom.toString()
            ikinciCarpim.text = ikinciÇarpimRandom.toString()

            val i = ilkCarpim.text.toString().toInt() + ikinciCarpim.text.toString().toInt()

            val rastgeleList = Random.nextInt(1, 4)
            if (rastgeleList == 1) {
                cevapBir.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapIkı.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapIkı.text = randomlar.toString()
                } else {
                    cevapIkı.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                    geciss()

                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 2) {
                cevapIkı.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapUc.text = randomlarIki.toString()
                } else {
                    cevapUc.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                    geciss()

                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 3) {
                cevapUc.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapDort.text = randomlarUc.toString()
                } else {
                    cevapDort.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                    geciss()

                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                }
            } else if (rastgeleList == 4) {
                cevapDort.text = i.toString()
                val randomlar = Random.nextInt(0, 30)
                if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else if (i.toString() == randomlar.toString()) {
                    val randomlar = Random.nextInt(0, 30)
                    cevapBir.text = randomlar.toString()
                } else {
                    cevapBir.text = randomlar.toString()
                }

                val randomlarIki = Random.nextInt(0, 30)
                if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else if (i.toString() == randomlarIki.toString()) {
                    val randomlarIki = Random.nextInt(0, 30)
                    cevapIkı.text = randomlarIki.toString()
                } else {
                    cevapIkı.text = randomlarIki.toString()
                }

                val randomlarUc = Random.nextInt(0, 30)
                if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapUc.text = randomlarUc.toString()
                } else if (i.toString() == randomlarUc.toString()) {
                    val randomlarUc = Random.nextInt(0, 30)
                    cevapUc.text = randomlarUc.toString()
                } else {
                    cevapUc.text = randomlarUc.toString()
                }


                cevapBir.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapBir.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapBir.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapIkı.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapIkı.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapIkı.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapUc.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.kaybetti)
                    ply?.start()
                    cevapUc.setBackgroundColor(Color.parseColor("#e01a00"))
                    cevapUc.setTextColor(Color.parseColor("#ffffff"))
                }
                cevapDort.setOnClickListener {
                    val ply = MediaPlayer.create(this, R.raw.alkis)
                    ply?.start()
                    cevapDort.setBackgroundColor(Color.parseColor("#19db00"))
                    cevapDort.setTextColor(Color.parseColor("#ffffff"))
                    geciss()

                }

            }

        }
    }
}
*
* */