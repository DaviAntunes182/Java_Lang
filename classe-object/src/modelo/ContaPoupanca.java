package modelo;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int agencia, int numero){
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

    @Override
    public String toString() {
        return "ContaPoupanca{" + super.toString() +
                "\nsaldo=" + saldo +
                '}';
    }
}
