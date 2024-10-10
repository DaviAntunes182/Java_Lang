package br.com.empresa.projeto.modelo;

import java.math.BigDecimal;

public class SeguroDeVida implements Tributavel {

    @Override
    public BigDecimal getValorImposto() {
        return new BigDecimal("42");
    }
}
