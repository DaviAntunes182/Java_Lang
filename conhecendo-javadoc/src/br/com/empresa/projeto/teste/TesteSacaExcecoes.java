package br.com.empresa.projeto.teste;

import br.com.empresa.projeto.modelo.Conta;
import br.com.empresa.projeto.modelo.ContaCorrente;
import br.com.empresa.projeto.modelo.SaldoInsucienteException;
import br.com.empresa.projeto.modelo.ValorNegativoException;

public class TesteSacaExcecoes {
    public static void main(String[] args) {

        Conta conta = new ContaCorrente(123, 321);

        conta.depositar("200");
        try {// O try é usado na classe main por que o método chamado pode gerar um erro
            conta.sacar("210");
        }catch (SaldoInsucienteException ex){
            System.out.println(ex.getMessage());
        }
        try{
            conta.sacar("-1");
        }catch (SaldoInsucienteException | ValorNegativoException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(conta.getSaldo());
    }
}
