package com.example.aula02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val somaButton = findViewById<Button>(R.id.buttonSoma)
        somaButton.setOnClickListener {
            calcular('+')
        }

        val subtracaoButton = findViewById<Button>(R.id.buttonSubtracao)
        subtracaoButton.setOnClickListener {
            calcular('-')
        }

        val multiplicacaoButton = findViewById<Button>(R.id.buttonMultiplicacao)
        multiplicacaoButton.setOnClickListener {
            calcular('*')
        }

        val divisaoButton = findViewById<Button>(R.id.buttonDivisao)
        divisaoButton.setOnClickListener {
            calcular('/')
        }
    }

    fun calcular(operador: Char) {
        val num1 = findViewById<EditText>(R.id.editTextNum1).text.toString().toDoubleOrNull()
        val num2 = findViewById<EditText>(R.id.editTextNum2).text.toString().toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val resultado = when (operador) {
                '+' -> num1 + num2
                '-' -> num1 - num2
                '*' -> num1 * num2
                '/' -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }

            val resultadoFormatado = "Resultado: " + String.format("%.2f", resultado)
            findViewById<TextView>(R.id.textViewResultado).text = resultadoFormatado
        } else {
            findViewById<TextView>(R.id.textViewResultado).text = "Entrada inválida"
        }
    }
}