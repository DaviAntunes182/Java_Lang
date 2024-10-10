package modelo;

import java.math.BigDecimal;

public abstract class Conta {
    BigDecimal saldo = new BigDecimal("0");
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;



    public Conta(int agencia, int numero) {
        this.agencia = agencia;
        this.numero = numero;
        Conta.total++;
        //System.out.println("Criando uma conta: "+ this.numero);
    }

    public abstract void depositar(String valor);
    public void sacar(String valor) throws SaldoInsucienteException{
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
    public boolean tranferir(Conta destino, String valor) throws SaldoInsucienteException{
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

    @Override
    public String toString() {
        return "\nNumero: " + numero +
                "\nAgencia: " + agencia;
    }
}
