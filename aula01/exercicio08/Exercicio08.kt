package aula01.exercicio08

fun main(args : Array<String>) {
// 8. Crie uma classe "Funcionario" com os atributos "nome", "idade" e "salario".
// Crie uma função que receba uma lista de funcionários e retorne o funcionário com o maior salário.

    // criando a lista de funcionarios
    var lista : List<Funcionario> = listOf(Funcionario("Tiago", 21, 1200.00), Funcionario("Gabriel",  19, 1000.00), Funcionario("Brunno", 30, 3000.00));

    // implementando funcao
    fun retornaFuncionario(lista : List<Funcionario>) : Funcionario{
        var funcionario : Funcionario = Funcionario("fulano", 0, 0.00);
        for (i in lista){
            if (i.getSalario()  > funcionario.getSalario()){
                funcionario = i;
            }
        }
        return funcionario
    }

    // printando resultados
    var funcionario : Funcionario = retornaFuncionario(lista);
    println("O funcionario com o maior salario é " + funcionario.getNome() + " e ele ganha R$ " + funcionario.getSalario());
}