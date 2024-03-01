package aula01.exercicio02

fun main(args : Array<String>){
// 2. Crie uma função que receba um array de inteiros e retorne o maior número.

    // criando o array
    var numeros : List<Int> = listOf<Int>(40, 59, 15, 26, 89, 90, 45, 5);

    // funcao lambda que retorna o maior valor
    val retornaMaior : (List<Int>) -> Int = { lista ->
        var maior : Int = lista[0];
        for (i in lista){
            if (i > maior){
                maior = i;
            }
        }
        maior
    }

    // printando resultado
    println("Lista: $numeros");
    println("O maior valor da lista é: " + retornaMaior(numeros));
}