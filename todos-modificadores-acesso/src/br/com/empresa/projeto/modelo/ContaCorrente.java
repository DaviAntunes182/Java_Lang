package br.com.empresa.projeto.modelo;

import java.math.BigDecimal;

public class ContaCorrente extends Conta implements Tributavel{

    public ContaCorrente(int agencia, int numero) {
        //Chama um contrutor da classe super
        super(agencia, numero);
    }

    @Override
    public void depositar(String valor) {
        BigDecimal convertido = new BigDecimal(valor);
        if(convertido.doubleValue() > 0) {
            this.setSaldo(this.getSaldo().add(convertido));
            System.out.printf("""
                    Valor depositado: %.2f
                    Saldo atual: %.2f
                    """, convertido, this.getSaldo());
        }else{
            System.out.println("Não tem como depositar um valor negativo");
        }
    }

    //Redefinindo um método, sobrescrevendo
    @Override
    public void sacar(String valor) throws SaldoInsucienteException{
        BigDecimal taxa = new BigDecimal("0.25");
        String valorASacar = new BigDecimal(valor).add(taxa).toString();
        super.sacar(valorASacar);
    }

    @Override
    public BigDecimal getValorImposto() {
        BigDecimal taxaCorrente = new BigDecimal("0.1");
        return super.getSaldo().multiply(taxaCorrente);
    }
}
