package com.example.martineze_exmgato

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var img1: ImageView? = null
    var img2: ImageView? = null
    var img3: ImageView? = null
    var img4: ImageView? = null
    var img5: ImageView? = null
    var img6: ImageView? = null
    var img7: ImageView? = null
    var img8: ImageView? = null
    var img9: ImageView? = null
    var imgX: ImageView? = null
    var imgO: ImageView? = null
    var turno = "x"
    val matrizGanador = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(3, 6, 9),
        intArrayOf(1, 5, 9),
        intArrayOf(3, 5, 7)
    )
    var posicionesX = IntArray(5)
    var posicionesO = IntArray(5)
    var cntX = 0
    var cntO = 0
    var ganador = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        img5 = findViewById(R.id.img5)
        img6 = findViewById(R.id.img6)
        img7 = findViewById(R.id.img7)
        img8 = findViewById(R.id.img8)
        img9 = findViewById(R.id.img9)
        imgX = findViewById(R.id.imgX)
        imgO = findViewById(R.id.imgO)
        imgX?.setBackgroundColor(Color.RED)
    }

    fun clickImagen(view: View) {
        val rutaNombre = resources.getResourceName(view.id)
        val nombreClick = rutaNombre.substring(rutaNombre.lastIndexOf("/") + 1)
        for (i in 1..9) {
            var nomConcatenado = "img$i"
            if (nombreClick == nomConcatenado) {
                if (turno == "x") {
                    posicionesX[cntX] = i
                    cntX++
                } else {
                    posicionesO[cntO] = i
                    cntO++
                }
            }
        }

        if (turno == "x") {
            view.setBackgroundResource(R.drawable.gato_x)
            imgX?.setBackgroundColor(Color.WHITE)
            imgO?.setBackgroundColor(Color.RED)
            turno = "o"
        } else {
            view.setBackgroundResource(R.drawable.gato_o)
            imgX?.setBackgroundColor(Color.RED)
            imgO?.setBackgroundColor(Color.WHITE)
            turno = "x"
        }
        var altoMatriz = matrizGanador.size
        for (i in 0 until cntX) {
            var gano = true
            for (j in 0 until altoMatriz) {
                gano = coincideGanador(matrizGanador[j], posicionesX)
                if (gano == true) {
                    ganador = "x"
                    Toast.makeText(this, "Ganó X", Toast.LENGTH_LONG).show()
                    dbLinea()
                    deshabilitar()
                    break
                }
            }
            if (gano == true) {
                break
            }
        }

        for (i in 0 until cntO) {
            var gano = true
            for (j in 0 until altoMatriz) {
                gano = coincideGanador(matrizGanador[j], posicionesO)
                if (gano == true) {
                    ganador = "o"
                    Toast.makeText(this, "Ganó O", Toast.LENGTH_LONG).show()
                    dbLinea()
                    deshabilitar()
                    break
                }
            }
            if (gano == true) {
                break
            }
        }
        view.isEnabled = false
    }

    fun coincideGanador(registroGanador: IntArray, posiciones: IntArray): Boolean {
        for (i in 0 until 3) {
            if (registroGanador[i] != posiciones[i]) {
                return false
            }
        }
        return true
    }

    fun dbLinea() {
        if (ganador == "x") {
            for (i in 0 until cntX) {
                if (posicionesX[i] == 1) {
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 2) {
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 3) {
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 4) {
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 5) {
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 6) {
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 7) {
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 8) {
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesX[i] == 9) {
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }else{
            for (i in 0 until cntO) {
                if (posicionesO[i] == 1) {
                    img1?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 2) {
                    img2?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 3) {
                    img3?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 4) {
                    img4?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 5) {
                    img5?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 6) {
                    img6?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 7) {
                    img7?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 8) {
                    img8?.setBackgroundColor(Color.BLUE)
                }
                if (posicionesO[i] == 9) {
                    img9?.setBackgroundColor(Color.BLUE)
                }
            }
        }
    }
    fun deshabilitar(){
        img1?.isEnabled=false
        img2?.isEnabled=false
        img3?.isEnabled=false
        img4?.isEnabled=false
        img5?.isEnabled=false
        img6?.isEnabled=false
        img7?.isEnabled=false
        img8?.isEnabled=false
        img9?.isEnabled=false

    }
    fun reinicio(view: View){
        val intento=intent
        finish()
        startActivity(intento)
    }
}