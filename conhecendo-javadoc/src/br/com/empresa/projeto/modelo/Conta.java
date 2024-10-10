package br.com.empresa.projeto.modelo;

import java.math.BigDecimal;
//Estes comentários especiais podem ser adicionados em cima de membros públicos
/**
 * Classe que representa um conceito de conta no Banco do curso.
 *
 * @author Davi
 * @version 0.1
 *
 */
public abstract class Conta {
    BigDecimal saldo = new BigDecimal("0");
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    /**
     * Construtor para representar a inicialização de uma conta
     * a partir de numero e agência
     *
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        Conta.total++;
        System.out.println("Criando uma conta: "+ this.numero);
    }

    public abstract void depositar(String valor);
    public void sacar(String valor) throws SaldoInsucienteException {
        BigDecimal convertido = new BigDecimal(valor);
        if(convertido.doubleValue() < 0){
            throw new ValorNegativoException("Não se pode sacar um valor negativo, isso se chama depósito!");
        }else{
            if(this.getSaldo().doubleValue() < convertido.doubleValue()){
                //problema
                throw new SaldoInsucienteException(
                        "Saldo: " + this.getSaldo().doubleValue()
                                + ", Valor: " + convertido.doubleValue());
            }
            else{
                this.setSaldo(this.saldo.subtract(convertido));
            }
        }
    }
    public boolean tranferir(Conta destino, String valor) throws SaldoInsucienteException {
        BigDecimal convertido = new BigDecimal(valor);
        if(convertido.doubleValue() < 0){
            throw new ValorNegativoException("Não se pode realizar uma tranferência de valor negativo");
        }else{
            //O try catch deve ser usado por quem quer fazer uso da classe
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        }
    }

    //Getters & Setters
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        if(saldo.doubleValue() < 0){
            System.out.println("Uma conta não pode ser iniciada com valor negativo");
            return;
        }
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            System.out.println("O valor da agência não pode ser negativo");
            return;
        }
        this.agencia = agencia;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("O número não pode ser negativo ou 0");
            return;
        }
        this.numero = numero;
    }
    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
