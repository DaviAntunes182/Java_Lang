package br.com.empresa.projeto.modelo;

import java.math.BigDecimal;

public class CalculadorImposto {

    private BigDecimal totalImposto = new BigDecimal("0");

    public CalculadorImposto() {

    }

    public void registra(Tributavel t){
        BigDecimal tributo = t.getValorImposto();
        this.totalImposto = this.totalImposto.add(tributo);
    }

    public BigDecimal getTotalImposto() {
        return totalImposto;
    }
}
