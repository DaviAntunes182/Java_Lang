import modelo.ContaCorrente;
import modelo.ContaPoupanca;

public class Principal {
    public static void main(String[] args) {
        Object cc = new ContaCorrente(22, 33);
        Object cp = new ContaPoupanca(33,22);

        System.out.println(cc.toString());
        System.out.println(cp.toString());
    }
}

/*
        System.out.println();
        System - classe
        out - atributo, publico, statico referência a outra classe
        println - metodo, publico, não estático, não joga checked exception

        O println fornece diversos tipos de parâmetro por quê usa do Polimorfismo
        passando como parâmetro a classe Objetc que é uma classe muito primitiva
        e quase todas as classes são filhas.
        Essas filhas absorvem diversos métodos da classe Object

 */