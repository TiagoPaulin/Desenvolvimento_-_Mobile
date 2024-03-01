package aula01.exercicio06

fun main(args : Array<String>){
// 6. Crie uma classe "ContaBancaria" com os atributos "saldo" e "limite".
// Adicione um método chamado "saque" que recebe um valor como parâmetro e subtrai do saldo da conta.
// Se o valor do saque for maior que o saldo da conta, o método deve lançar uma exceção com a mensagem "Saldo insuficiente".

    // instanciando conta
    val conta : ContaBancaria = ContaBancaria(100,  50);

    println("Seu saldo atual é de R$ " + conta.getSaldo());
    print("Insira o valor que desjea sacar (valor maximo permitido R$ " + conta.getSLimite() + "): " );
    var valor : Int = readLine()!!.toInt();
    conta.saque(valor);

}