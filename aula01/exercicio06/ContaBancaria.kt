package aula01.exercicio06

class ContaBancaria(saldo : Int, limite : Int) {
    // definindo atributos
    private var saldo : Int = saldo;
    private var limite : Int = limite;

    // metodos get
    fun getSaldo() : Int{
        return this.saldo;
    }
    fun getSLimite() : Int{
        return this.limite;
    }

    // metodos set
    fun setSaldo(saldo : Int){
        this.saldo = saldo;
    }
    fun setLimite(limite : Int){
        this.limite = limite;
    }

    // implemetacao do metodo saque
    fun saque(valor : Int){
        if (valor > saldo || valor > limite){
            println("Saldo insuficiente");
        } else {
            println("Seu saldo atual é de R$ " + getSaldo())
            setSaldo(saldo - valor);
            println("Saque de R$ $valor realizado. Saldo atual R$ " + getSaldo());
        }
    }
}