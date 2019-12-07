package com.example.projetologinx

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    fun editarSenha(view: View){
        var usuario = intent.getStringExtra("usuario")

        var senhaEditText: EditText = findViewById(R.id.textoSenha)
        var senha = senhaEditText.text.toString()

        var data = Intent().apply {
            putExtra("usuario",usuario)
            putExtra("senha",senha)
        }

        setResult(Activity.RESULT_OK,data)
        finish()

    }
}
