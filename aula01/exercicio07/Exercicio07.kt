package aula01.exercicio07

fun main(args : Array<String>){
    // 7. Crie uma função que receba uma lista de strings e retorne a string mais longa da lista.

    // criando lista
    val lista : List<String> = listOf("pralelepipedo", "cubo", "priramide", "esfera");

    // declarando a funcao
    fun maiorString(lista : List<String>) : String{
        var maior : String = "";
        for (i in lista){
            if (i.length > maior.length){
                maior = i;
            }
        }
        return maior;
    }

    println(lista);
    println("A maior String da lista é: " + maiorString(lista))
}