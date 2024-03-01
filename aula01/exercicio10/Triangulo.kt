package aula01.exercicio10

class Triangulo(base : Int, altura : Int) {
    // definindo atributos
    private var base : Int = base;
    private var altura : Int = altura;

    // metodos get
    fun getBase() : Int{
        return base;
    }
    fun getAltura() : Int{
        return altura;
    }
    // metodos set
    fun setBase(base : Int){
        this.base = base;
    }
    fun setAltura(altura : Int){
        this.altura = altura;
    }

    // metodo que calcula area
    fun area() : Int{
        return ((getBase() * getAltura()) / 2);
    }

}