package aula01.exercicio04

fun main(args : Array<String>){
// 4. Crie uma função que receba uma string e retorne
// verdadeiro se a string for um palíndromo (ou seja, pode ser lida da mesma forma de trás para frente).

    // recebendo a string
    print("Digite uma palavra para ver se ela é um palindromo: ");
    var palavra : String = readLine()!!.toString();

    // declarando a funcao
    fun verificaPalindromo(palavra : String) : Boolean {
        if (palavra.equals(palavra.reversed())){
            return true;
        }
        return false;
    }

    // printando resultados
    if (verificaPalindromo(palavra)){
        println("A palavra $palavra é um palindromo!");
    } else {
        println("A palavra $palavra não é um palindromo!");
    }
}