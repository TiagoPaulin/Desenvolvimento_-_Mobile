package com.example.aula06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.aula06.databinding.ActivityCityDetailsBinding

// Classe de atividade que exibe os detalhes de uma cidade e permite editar ou adicionar uma nova cidade
class CityDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o layout da atividade usando o DataBindingUtil
        val binding = DataBindingUtil.setContentView<ActivityCityDetailsBinding>(
            this, R.layout.activity_city_details)

        // Verifica se há uma cidade selecionada no Singleton e preenche os campos de edição com os detalhes da cidade
        Singleton.citySelected?.apply {
            binding.nameEditText.setText(name)
            binding.populationEditText.setText(population.toString())
            binding.capitalCheckBox.isChecked = isCapital
        }

        // Configura o botão de salvar para adicionar ou atualizar a cidade no Singleton e fechar a atividade
        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val population = binding.populationEditText.text.toString().toInt()
            val isCapital = binding.capitalCheckBox.isChecked
            if (Singleton.citySelected == null) {
                // Se não houver cidade selecionada, adiciona uma nova cidade ao Singleton
                Singleton.add(City(0, name, population, isCapital))
            } else {
                // Se houver uma cidade selecionada, atualiza os detalhes da cidade no Singleton
                Singleton.citySelected?.apply {
                    this.name = name
                    this.population = population
                    this.isCapital = isCapital
                    Singleton.update(this)
                }
            }
            // Fecha a atividade após adicionar ou atualizar a cidade
            finish()
        }
    }
}
