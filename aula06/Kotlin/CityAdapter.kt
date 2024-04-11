package com.example.aula06

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aula06.databinding.ItemViewBinding

// Classe do adaptador para o RecyclerView que exibe uma lista de cidades
class CityAdapter(val clickListener: OnCityClickListener)
    :RecyclerView.Adapter<CityAdapter.ViewHolder>(){

    // Interface para lidar com eventos de clique e longo clique em uma cidade na lista
    interface OnCityClickListener{
        fun onCityClick(view:View,position: Int)
        fun onCityLongClick(view:View,position: Int)
    }

    // Classe ViewHolder que mantém uma referência ao layout de item e define o método bind
    inner class ViewHolder(val binding: ItemViewBinding)
        :RecyclerView.ViewHolder(binding.root){

        // Método para vincular os dados de uma cidade à exibição
        fun bind(city: City){
            binding.textView1.text = city.name
            binding.textView2.text = city.population.toString()
            binding.root.setOnClickListener{
                clickListener.onCityClick(it,adapterPosition)
            }
            binding.root.setOnLongClickListener{
                clickListener.onCityLongClick(it,adapterPosition)
                true
            }
        }
    }

    // Contador para rastrear a criação de ViewHolders (utilizado apenas para depuração)
    var counter = 0

    // Método chamado quando o RecyclerView precisa de um novo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // Infla o layout do item usando o ItemViewBinding e retorna um novo ViewHolder com o layout inflado
        val binding = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        counter++
        Log.d("Adapter","Created:$counter") // Registro de evento de criação de ViewHolder (depuração)
        return ViewHolder(binding)
    }

    // Método chamado para vincular os dados de uma cidade a um ViewHolder específico
    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        // Obtém a cidade da lista Singleton.cities com base na posição fornecida e chama o método bind do ViewHolder para atualizar as exibições com os dados da cidade
        Singleton.cities[position].apply {
            holder.bind(this)
        }
        Log.d("Adapter","Bind:$position") // Registro de evento de vinculação de ViewHolder (depuração)
    }

    // Método que retorna o número total de itens na lista
    override fun getItemCount() = Singleton.cities.size
}
