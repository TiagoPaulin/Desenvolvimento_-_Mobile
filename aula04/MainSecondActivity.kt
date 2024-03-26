package com.example.aula03

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainSecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity_main_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var campo1 = findViewById<EditText>(R.id.editTextUsuario);
        var campo2 = findViewById<EditText>(R.id.editTextSenha);
        var botaoSalvar = findViewById<Button>(R.id.buttonSalvar);

        campo1.addTextChangedListener {
            verificarCampos(campo1, campo2, botaoSalvar);
        }
        campo2.addTextChangedListener {
            verificarCampos(campo1, campo2, botaoSalvar);
        }

        botaoSalvar.setOnClickListener{
            salvar(campo1.text.toString(), campo2.text.toString())
        }
    }

    fun verificarCampos(campo1 : EditText, campo2 : EditText, botaoSalvar : Button){
        if ((campo1.text.isNotEmpty()) && (campo2.text.isNotEmpty())){
            botaoSalvar.visibility = View.VISIBLE;
        }
    }

    fun salvar(novoUsuario: String, novaSenha: String){


        val intent = Intent()
        intent.putExtra("newUsername", novoUsuario)
        intent.putExtra("newPassword", novaSenha)
        setResult(Activity.RESULT_OK, intent)
        finish()

    }


}