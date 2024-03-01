package aula01.exercicio13

fun main(args : Array<String>) {
// 13. Crie uma função de ordem superior chamada operacaoMatematica que aceita dois números e uma função lambda.
// A função operacaoMatematica deve aplicar a função lambda aos dois números e retornar o resultado.
// Em seguida, crie algumas funções lambda para realizar operações matemáticas, como soma, subtração, multiplicação e divisão.
// Use a função de ordem superior para realizar essas operações com diferentes pares de números.

    // implementando funcos lambda
    val soma : (Int, Int) -> Int = {n1, n2 -> n1 + n2};
    val subtracao : (Int, Int) -> Int = {n1, n2 -> n1 - n2};
    val multiplicacao : (Int, Int) -> Int = {n1, n2 -> n1 * n2};
    val divisao : (Int, Int) -> Int = {n1, n2 -> n1 / n2};

    // implementando funcao de ordem superior
    fun operacaoMatematica(n1 : Int, n2 : Int, lambda : (Int, Int) -> Int) : Int {
        return lambda(n1, n2);
    }

    // printando resultados
    println("n1 = 8 | n2 = 2");
    println("Soma: " + operacaoMatematica(8, 2, soma));
    println("Multiplicacao: " + operacaoMatematica(8, 2, multiplicacao));
    println("Subtracao: " + operacaoMatematica(8, 2, subtracao));
    println("Divisao: " + operacaoMatematica(8, 2, divisao));
}