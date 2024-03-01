package aula01.exercicio10

fun main(args : Array<String>){
// 10. Crie uma classe "Triangulo" com os atributos "base" e "altura".
// Adicione um método chamado "area" que calcula e retorna a área do triângulo.

    // instanciando o triangulo
    var triangulo : Triangulo = Triangulo(10,5);

    // printando resultados
    println("O triangulo de base ${triangulo.getBase()}cm e altura ${triangulo.getAltura()}cm possui area de ${triangulo.area()}cm²")
}