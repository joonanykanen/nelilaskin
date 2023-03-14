package main.nelilaskin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var luku1: EditText
    private lateinit var luku2: EditText
    private lateinit var plusButton: Button
    private lateinit var miinusButton: Button
    private lateinit var kertoButton: Button
    private lateinit var jakoButton: Button
    private lateinit var tulos: TextView

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        luku1 = findViewById(R.id.luku1)
        luku2 = findViewById(R.id.luku2)
        plusButton = findViewById(R.id.plusButton)
        miinusButton = findViewById(R.id.miinusButton)
        kertoButton = findViewById(R.id.kertoButton)
        jakoButton = findViewById(R.id.jakoButton)
        tulos = findViewById(R.id.tulos)

        plusButton.setOnClickListener {
            val summa = laskeSumma()
            tulos.text = summa.toString()
        }

        miinusButton.setOnClickListener {
            val erotus = laskeErotus()
            tulos.text = erotus.toString()
        }

        kertoButton.setOnClickListener {
            val tulo = laskeTulo()
            tulos.text = tulo.toString()
        }

        jakoButton.setOnClickListener {
            val jako = laskeJako()
            if (jako != null) {
                tulos.text = jako.toString()
            } else {
                tulos.text = "Virheellinen syöte"
            }
        }
    }

    private fun laskeSumma(): Int {
        val luku1 = luku1.text.toString().toInt()
        val luku2 = luku2.text.toString().toInt()
        return luku1 + luku2
    }

    private fun laskeErotus(): Int {
        val luku1 = luku1.text.toString().toInt()
        val luku2 = luku2.text.toString().toInt()
        return luku1 - luku2
    }

    private fun laskeTulo(): Int {
        val luku1 = luku1.text.toString().toInt()
        val luku2 = luku2.text.toString().toInt()
        return luku1 * luku2
    }

    private fun laskeJako(): Double? {
        val luku1 = luku1.text.toString().toDoubleOrNull()
        val luku2 = luku2.text.toString().toDoubleOrNull()
        return if (luku1 != null && luku2 != null && luku2 != 0.0) {
            luku1 / luku2
        } else {
            null
        }
    }
}