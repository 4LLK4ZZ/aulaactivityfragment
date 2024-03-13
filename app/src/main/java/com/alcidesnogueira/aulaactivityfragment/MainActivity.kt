package com.alcidesnogueira.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonAbrir = findViewById(R.id.button_abrir)
        buttonAbrir.setOnClickListener {

            val intent = Intent(
                this,
                DetalhesActivity::class.java
            )

            //Passando parâmetros para a nova tela

            /*intent.putExtra("Filme", "All the Bright places")
            intent.putExtra("Classificação", 18)
            intent.putExtra("Avaliações", 9.8)*/

            val filme = Filme(
                "Sem Limites",
                "Teste",
                7.2,
                "Alcides Nogueira",
                "Star Plus"
            )

            intent.putExtra("filme", filme)


            //Iniciar uma nova tela
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        //Carregar dados
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        //Carregar dados
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        //Carregar dados
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        //Carregar dados
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        //Carregar dados
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        Log.i("ciclo_vida", "onDestroy")
        super.onDestroy()
        //Carregar dados
    }
}
