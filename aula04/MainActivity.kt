package com.example.aula03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var usuario = "user";
    var senha = "1234";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var campo1 = findViewById<EditText>(R.id.editTextUsuario);
        var campo2 = findViewById<EditText>(R.id.editTextSenha);
        var botaLogin = findViewById<Button>(R.id.buttonCadastrar);
        var botaoCadastro = findViewById<FloatingActionButton>(R.id.floatingActionButton);

        campo1.addTextChangedListener {
            verificarCampos(campo1, campo2, botaLogin);
        }
        campo2.addTextChangedListener {
            verificarCampos(campo1, campo2, botaLogin);
        }

        botaLogin.setOnClickListener{
            logar(campo1, campo2, usuario, senha, botaLogin)
        }
        botaoCadastro.setOnClickListener{
            telaCadastro();
        }
    }

    fun verificarCampos(campo1 : EditText, campo2 : EditText, botaLogin : Button){
        if ((campo1.text.isNotEmpty()) && (campo2.text.isNotEmpty())){
            botaLogin.visibility = View.VISIBLE;
        }
    }

    fun logar(campo1 : EditText, campo2 : EditText, usuario : String, senha : String, botaoLogin : Button){

        if (!(campo1.text.toString() == usuario) || !(campo2.text.toString() == senha)){

            exibirAlerta(campo1, campo2);
            botaoLogin.visibility = View.INVISIBLE

        } else {
            val intent = Intent(this, MainSecondActivity::class.java)
            intent.putExtra("usuarioAtual", usuario)
            intent.putExtra("senhaAtual", senha)
            startActivityForResult(intent, 1)

        }

    }

    fun exibirAlerta(campo1 : EditText, campo2 : EditText){

        val alerta = AlertDialog.Builder(this);

        alerta.setTitle("Login inválido!");
        alerta.setMessage("Voce digitou o usuário ou senha errados");

        alerta.setPositiveButton("OK") {mensagem, which ->
            campo1.text.clear()
            campo2.text.clear()
            mensagem.dismiss()
        }

        alerta.show();

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {

            val novoUsuario = data?.getStringExtra("newUsername")
            val novaSenha = data?.getStringExtra("newPassword")
            usuario = novoUsuario ?: usuario
            senha = novaSenha ?: senha

            val alerta = AlertDialog.Builder(this);

            alerta.setTitle("Dados salvos!");
            alerta.setMessage("O login e senha do usuário foram alterados");

            alerta.setPositiveButton("OK") {mensagem, which ->

                findViewById<EditText>(R.id.editTextUsuario).text.clear();
                findViewById<EditText>(R.id.editTextSenha).text.clear();

                mensagem.dismiss();
            }

            alerta.show();

        }
    }

    fun telaCadastro(){

        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)

    }

}