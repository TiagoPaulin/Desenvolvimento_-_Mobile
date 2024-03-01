package aula01.exercicio03

fun main(args : Array<String>){
// 3. Crie uma classe chamada "Pessoa" com os atributos "nome" e "idade".
// Em seguida, crie uma lista de objetos "Pessoa" e ordene a lista em ordem alfabética pelo atributo "nome".

    // criando a lista de pessoas
    val lista : List<Pessoa> = listOf(Pessoa("Tiago", 21), Pessoa("Gabriel", 19), Pessoa("Alan", 34), Pessoa("Brunno", 95));

    // função lambda para ordenar em ordem alfabetica
    val ordenar : (List<Pessoa>) -> List<Pessoa> = {desordenada ->
        var ordenada : List<Pessoa> = desordenada.sortedBy {it.getNome()};
        ordenada;
    }

    // printanda resultados
    for (pessoa in lista) {
        print(pessoa.getNome() + ", ");
    }
    println(" ");
    for (pessoa in ordenar(lista)){
        print(pessoa.getNome()  + ", ");
    }
}