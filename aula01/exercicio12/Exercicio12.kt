package aula01.exercicio12

fun main(args : Array<String>){
// 12. Utilize um mapa para representar um dicionário de palavras e suas traduções.

    // criando mapa
    var mapa : Map<String, String> = mapOf("rabbit" to "coelho", "dog" to "cachorro", "cat" to "gato");

    // printando resultados
    for((chave, palavra) in mapa){
        println("Palavra: $chave | Tradução: $palavra");
    }
}