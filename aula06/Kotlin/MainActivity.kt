package com.example.aula06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula06.databinding.ActivityMainBinding

// Classe de atividade principal que exibe a lista de cidades e permite adicionar ou visualizar detalhes das cidades
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o layout da atividade usando o DataBindingUtil
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main)

        // Configura o contexto para o Singleton
        Singleton.setContext(this)

        // Configura o adaptador e o gerenciador de layout para o RecyclerView
        binding.mainRecyclerView.adapter =
            CityAdapter(object : CityAdapter.OnCityClickListener{
                override fun onCityClick(view: View, position: Int) {
                    // Quando uma cidade é clicada, salva a cidade selecionada no Singleton e abre a atividade de detalhes da cidade
                    Singleton.citySelected = Singleton.cities[position]
                    val intent = Intent(this@MainActivity,
                        CityDetailsActivity::class.java)
                    startActivity(intent)
                }

                override fun onCityLongClick(view: View, position: Int) {
                    // Quando uma cidade é pressionada longamente, remove a cidade do Singleton e notifica o adaptador para atualizar a lista
                    Singleton.delete(Singleton.cities[position])
                    binding.mainRecyclerView.adapter?.notifyItemRemoved(position)
                }
            })

        // Configura o layout manager para o RecyclerView
        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(this)

        // Configura o botão de adição para abrir a atividade de detalhes da cidade
        binding.addButton.setOnClickListener {
            Singleton.citySelected = null
            val intent = Intent(this,
                CityDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Notifica o adaptador quando a atividade é retomada para garantir que a lista de cidades esteja atualizada
        binding.mainRecyclerView.adapter?.notifyDataSetChanged()
    }
}
