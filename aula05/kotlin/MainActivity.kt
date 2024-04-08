package com.example.aula04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.aula04.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //Configura a URL base do retrofit, da api
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.waifu.im")
        .addConverterFactory(GsonConverterFactory.create())//Transforma o resultado em JSON
        .build()

    //Configura os métodos que devem ser usados pela api
    private val api = retrofit.create(WaifuAPI::class.java)//Pegamos a classe que criamos anteriormente e sao implementadas na API

    //Defino o binding
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Define a tela, passando a atividade e o layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        gerarImagem()

        //Define evento de botáo
        binding.button.setOnClickListener {
            //Define a Thread que irá executar a funcao assincrona da API
            gerarImagem()
        }
    }


    private fun gerarImagem () {
        CoroutineScope(Dispatchers.Main).launch {
            //Defino o texto do textView como uma random joke da API
            val responseBody = api.getRandomWaifu()
            val body = responseBody.string()
            val imageUrl = JSONObject(body).getJSONArray("images").getJSONObject(0).getString("url")
            Glide.with(this@MainActivity)
                .load(imageUrl)
                .into(binding.imageView)
        }
    }

}