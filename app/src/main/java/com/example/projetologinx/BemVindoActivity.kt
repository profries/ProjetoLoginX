package com.example.projetologinx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class BemVindoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bem_vindo)

        var usuario = intent.getStringExtra("usuario")

        var textoBemVindo: TextView = findViewById(R.id.textoBemVindo)
        textoBemVindo.text = "Bem vindo, "+usuario
    }

    fun voltar(view: View){
        finish()
    }
}
