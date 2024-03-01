package aula01.exercicio03

class Pessoa(nome : String, idade : Int) {
    // definindo atributos
    private var nome : String = nome;
    private var idade : Int = idade;
    //metodos get
    fun getNome() : String{
        return nome;
    }
    fun getIdade() : Int{
        return idade;
    }
    //metodos set
    fun setNome(nome : String){
        this.nome = nome;
    }
    fun setIdade(idade: Int){
        this.idade = idade;
    }

}