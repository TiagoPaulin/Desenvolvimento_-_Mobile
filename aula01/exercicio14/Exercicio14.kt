package aula01.exercicio14

fun main(args : Array<String>){
// 14. Crie uma função de extensão chamada isPalindromo para a classe String que verifica se a string é um palíndromo.
// A função deve ignorar espaços em branco e ser case-insensitive (não distinguir maiúsculas de minúsculas).
// Em seguida, use essa função para verificar se algumas palavras são palíndromos.

    // criando função de extensão
    fun String.isPalindromo() : Boolean{
        return this.trim().equals(this.reversed().trim(), ignoreCase = true);
    }

    //printando resultados
    var palavra : String = "Aba   ";
    if(palavra.isPalindromo()){
        println("A palavra $palavra é um palindromo");
    } else  {
        println("A palavra $palavra não é um palindromo");
    }
}