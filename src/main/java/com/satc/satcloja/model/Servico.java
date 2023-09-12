package com.satc.satcloja.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("servico")
public class Servico extends ItemVendavel {
    @Column(name = "quantidade_horas", nullable = true)
    private Double quantidadeHoras;

public Servico(){}
    public Servico(String descricao, Double valorUnitario, Double quantidadeHoras) {
        super.setDescricao(descricao);
        this.quantidadeHoras = quantidadeHoras;
        super.setValorUnitario(valorUnitario);
    }


    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public Boolean getEstocavel() {
        return false;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "quantidadeHoras=" + quantidadeHoras +
                '}';
    }
}
