package com.example.aula03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var campo1 = findViewById<EditText>(R.id.editTextUsuario);
        var campo2 = findViewById<EditText>(R.id.editTextSenha);
        var campo3 = findViewById<EditText>(R.id.editTextConfirmarSenha);
        var button = findViewById<Button>(R.id.buttonCadastrar);
        val arquivo = File(filesDir, "arquivo.txt");
        arquivo.createNewFile();

        val itens = listOf("user", "admin", "mkt")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        var spinner = findViewById<Spinner>(R.id.spinner);
        spinner.adapter = adapter;

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity3, "Selected ${itens[position]}", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        campo1.addTextChangedListener {
            verificarCampos(campo1, campo2, campo3, button)
        }
        campo2.addTextChangedListener {
            verificarCampos(campo1, campo2, campo3, button)
        }
        campo3.addTextChangedListener {
            verificarCampos(campo1, campo2, campo3, button)
        }

        button.setOnClickListener{
            cadastrar(campo1, campo2, campo3, button, arquivo)
        }
    }

    fun verificarCampos(campo1 : EditText, campo2 : EditText, campo3 : EditText, botaLogin : Button) {

        if (((campo1.text.isNotEmpty()) && (campo2.text.isNotEmpty()) && (campo3.text.isNotEmpty()))
            && (campo2.text.toString() == campo3.text.toString())
        ) {

            botaLogin.visibility = View.VISIBLE;

        }
    }

    fun cadastrar(campo1 : EditText, campo2 : EditText, campo3 : EditText, button : Button, arquivo : File){

        if (verificarUsername(arquivo, campo1)){

            exibirAlerta(campo1, campo2, campo3);
            button.visibility = View.INVISIBLE

        } else {

            var dados : List<String> = listOf(campo1.text.toString(), campo2.text.toString())

            gravarDados(dados, arquivo);

            telaLogin();

        }

    }

    fun verificarUsername(arquivo : File, campo1 : EditText) : Boolean {

        try {

            val reader = BufferedReader(FileReader(arquivo));


            val primeiraLinha: String? = reader.readLine();

            if (primeiraLinha == campo1.text.toString()){

                return true;

            }

            reader.close()

        } catch (ex: Exception) {

            println("Ocorreu um erro ao ler o arquivo: ${ex.message}")

        }

        return false

    }

    fun gravarDados(dados : List<String>, arquivo : File) {

        try {

            val writer = FileWriter(arquivo, false)

            for (dado in dados) {
                writer.write("$dado\n")
            }
            writer.close()

            Toast
                .makeText(this, "Saved", Toast.LENGTH_LONG)
                .show()

        } catch (ex: Exception) {

            println("Erro ao gravar em '$arquivo': ${ex.message}")

        }

    }

    fun exibirAlerta(campo1 : EditText, campo2 : EditText, campo3 : EditText){

        val alerta = AlertDialog.Builder(this);

        alerta.setTitle("Cadastro inválido!");
        alerta.setMessage("O nome de usuário já está cadastrado no sistema");

        alerta.setPositiveButton("OK") {mensagem, which ->
            campo1.text.clear()
            campo2.text.clear()
            campo3.text.clear()
            mensagem.dismiss()
        }

        alerta.show();

    }

    fun telaLogin(){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}