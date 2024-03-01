package aula01.exercicio08

class Funcionario(nome : String, idade :  Int, salario : Double) {
    // definindo atributos
    private var nome : String = nome;
    private var idade : Int = idade;
    private var salario : Double = salario;

    // metodos get
    fun getNome() : String {
        return nome;
    }
    fun getIdade() : Int {
        return idade;
    }
    fun getSalario() : Double {
        return salario;
    }

    // metodos set
    fun setNome(nome : String){
        this.nome = nome;
    }
    fun  setIdade(idade : Int) {
        this.idade = idade;
    }
    fun setSalario(salario : Double){
        this.salario = salario;
    }
}