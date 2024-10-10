package br.com.empresa.projeto.especial;

import br.com.empresa.projeto.modelo.Conta;

public class ContaEspecial extends Conta {

    public ContaEspecial(int agencia, int numero) {
        super(agencia, numero);
    }

    @Override
    public void depositar(String valor) {
//        Mesmo sendo filhas, classes que não estão no pacote não podem acessar atributos de
//        default de outras classses
//        BigDecimal convertido = new BigDecimal(valor);
//        if(convertido.doubleValue() > 0) {
//            this.setSaldo(super.saldo.add(convertido));
//            System.out.printf("""
//                    Valor depositado: %.2f
//                    Saldo atual: %.2f
//                    """, convertido, super.saldo);
//        }else{
//            System.out.println("Não tem como depositar um valor negativo");
//        }
    }
}
