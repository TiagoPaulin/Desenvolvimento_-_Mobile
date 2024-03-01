package aula01.exercicio09

fun main(args : Array<String>){
// 9. Crie uma função que receba uma lista de números inteiros e retorne uma lista com os números em ordem crescente, sem usar o método de ordenação da linguagem.

    // criando a lista
    var lista : MutableList<Int> = mutableListOf(56, 80, 3, 13, 7, 90, 25);

    // implementação de um algoritmo bubbleSotrt para ordenação
    fun bubbleSort(lista : MutableList<Int>, tamanho : Int){
        var auxiliar : Int = 0;
        for (i in  0 until tamanho){
            for (j in  0 until (tamanho - 1)){
                if (lista[j] > lista[j + 1]){
                    auxiliar = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = auxiliar;
                }
            }
        }
    }

    // printando resultados
    println("Lista: " + lista);
    bubbleSort(lista, lista.size);
    println("Lista ordenada: " + lista);
}