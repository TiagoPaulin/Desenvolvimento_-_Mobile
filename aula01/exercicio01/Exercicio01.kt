package aula01.exercicio01

fun main(args : Array<String>){
// 1. Crie uma função que receba um número inteiro e retorne verdadeiro se o número for par e falso caso contrário.

    // recebendo o input
    print("Digite um número para descobrir se ele é impar ou par: ");
    var numero : Int = readLine()!!.toInt(); // !! força a converção

    // declarando função
    fun verificaPar(num : Int) : Boolean{
        if (num % 2 == 0){ // verifica se op parâmetro recebido é par
            return true; // se sim retorna true
        }
        return false; // se for impar retorna false
    }

    // verificando resultado
    if (verificaPar(numero)){
        println("O número $numero é par!");
    } else {
        println("O número $numero é ímpar!");
    }
}