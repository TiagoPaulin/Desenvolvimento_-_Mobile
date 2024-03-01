package aula01.exercicio05

fun main(args : Array<String>){
    // 5. Implemente uma função lambda que retorne o maior valor entre dois números.

    // recebendo os numeros
    print("Digite o primeiro numero: ");
    var n1 : Int = readLine()!!.toInt();
    print("Digite o segundo numero: ");
    var n2 : Int = readLine()!!.toInt();

    // funcao lambda
    val maiorNumero : (Int, Int) -> Int = {a, b ->
        var maior : Int = b;
        if (a > b){
            maior = a;
        }
        maior;
    }

    println("O maior numero é: " + maiorNumero(n1, n2));
}