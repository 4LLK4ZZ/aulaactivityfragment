package com.alcidesnogueira.aulaactivityfragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textFilme: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)


        buttonFechar = findViewById(R.id.button_fechar)
        textFilme = findViewById(R.id.textFilme)

        val bundle = intent.extras // recupera todos os parâmetros
        if (bundle != null)
        {
            /*val filme = bundle.getString("Filme")
            val classificacao = bundle.getInt("Classificação")
            val avaliacoes = bundle.getDouble("Avaliações")*/

            val filme = if( Build.VERSION.SDK_INT >= 33)//nova versão >= 33
            {
                //bundle.getSerializable("filme", Filme::class.java)
                bundle.getParcelable("filme", Filme::class.java)
            }
            else
            {
                //bundle.getSerializable("filme") as Filme
                bundle.getParcelable("filme")
            }

            //val filme = bundle.getSerializable("filme") as Filme

            //val resultado = "filme: $filme - class: $classificacao - aval: $avaliacoes"

            textFilme.text = "${filme?.nome} - ${filme?.distribuidor}"
        }

        buttonFechar.setOnClickListener {
            finish()//finalizar
        }
        }
    }
