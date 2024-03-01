package aula01.exercicio11

fun  main(args : Array<String>){
// 11. Crie uma função que receba uma lista de strings e retorne uma lista com todas as strings que
// começam com a letra "A", em ordem alfabética.

    // criando a lista
    var lista : List<String> = listOf("Gabriel", "Adalberto", "Adelino", "Lucas", "João", "Alisson", "Alan", "Arthur", "Bernardo");

    // criando a função
    fun retornaListaA(lista : List<String>) : List<String>{
        var listaA : MutableList<String> = mutableListOf();
        for (i in lista){
            if (i.startsWith("A")){
                listaA.add(i);
            }
        }
        return listaA.sorted();
    }

    // printando resultados
    println("Lista: " + lista);
    println("Lista filtrada: " + retornaListaA(lista));
}