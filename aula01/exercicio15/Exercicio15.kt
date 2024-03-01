package aula01.exercicio15

fun main(args : Array<String>){
//15. Vamos criar um programa que utilize funções de alta ordem para operar em um array de números inteiros.
// Você deve criar funções de alta ordem para realizar as seguintes operações: filtrarPares:
// Uma função que filtra e retorna apenas os números pares do array;
// dobrarValores: Uma função que dobra o valor de cada número no array;
// somarValores: Uma função que calcula a soma de todos os valores no array.
// Em seguida, crie um array de números inteiros e utilize as funções de alta ordem para realizar essas operações.

    // criando o array
    var array : Array<Int> = arrayOf(23, 69, 3, 59, 60, 24, 70, 4, 8, 10);

    // implementando funcoes lambda
    val pares : (Array<Int>) -> Array<Int> = {array ->
        var pares : Array<Int> = arrayOf();
        for (i in array){
            if (i % 2 ==0){
                pares = pares.plus(i);
            }
        }
        pares;
    }
    val dobra : (Array<Int>) -> Array<Int> = {array ->
        var dobro : Array<Int> = arrayOf();
        for (i in array){
            dobro = dobro.plus(i * 2);
        }
        dobro;
    }
    val soma : (Array<Int>) -> Int = {array ->
        var soma : Int = 0;
        for (i in array){
            soma += i;
        }
        soma;
    }

    // implementando funcao superior
    fun filtrarPares(array : Array<Int>, lambda : (Array<Int>) -> Array<Int>) :  Array<Int>{
        return lambda(array);
    }
    fun dobraValores(array : Array<Int>, lambda : (Array<Int>) -> Array<Int>) :  Array<Int>{
        return lambda(array);
    }
    fun somaValores(array : Array<Int>, lambda : (Array<Int>) -> Int) :  Int {
        return lambda(array);
    }

    // printando resultados
    println("Array: ${array.joinToString()}");
    println("Pares: ${filtrarPares(array, pares).joinToString()}");
    println("Dobro: ${dobraValores(array, dobra).joinToString()}");
    println("Soma: ${somaValores(array, soma)}");

}