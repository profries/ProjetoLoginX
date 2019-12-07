package com.example.projetologinx

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.projetologinx.model.Usuario

class MainActivity : AppCompatActivity() {

    var listaUsuarios = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iniciaListaUsuarios()

        setContentView(R.layout.activity_main)
    }

    private fun iniciaListaUsuarios() {
        listaUsuarios.add(Usuario("usuario1","senha1"))
        listaUsuarios.add(Usuario("usuario2","senha2"))
        listaUsuarios.add(Usuario("usuario3","senha3"))
    }

    fun realizaLogin(view: View) {

        var textoNome = findViewById(R.id.editNome) as EditText
        //var textoSenha = findViewById<EditText>(R.id.editSenha)
        var textoSenha: EditText = findViewById(R.id.editSenha)

        val nomeString = textoNome.text.toString()
        val senhaString = textoSenha.text.toString()

        Log.i("Campo Nome", nomeString)
        Log.i("Campo Senha",senhaString)

        if(listaUsuarios.contains(Usuario(nomeString,senhaString))){
            Toast.makeText(this,
                this.getString(R.string.msg_ok_login), Toast.LENGTH_SHORT).show()

            var intent = Intent(this, BemVindoActivity::class.java).apply {
                putExtra("usuario",nomeString)
            }

            //intent.putExtra("usuario",nomeString)
            startActivityForResult(intent, 1)
        }
        else{
            Toast.makeText(this,
                this.getString(R.string.msg_error_login), Toast.LENGTH_SHORT).show()
        }

        textoSenha.setText("")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                var username = data?.getStringExtra("usuario")
                var senha = data?.getStringExtra("senha")
                Log.d("onActivityResultUsuario",username)
                Log.d("onActivityResultSenha",senha)
            }
        }
    }
}
