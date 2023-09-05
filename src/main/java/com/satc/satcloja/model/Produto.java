package com.satc.satcloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Produto extends ItemVendavel {
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "preco_compra", nullable = false)
    private Double precoCompra;
    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;
    @Column(name = "data_prazo", nullable = false)
    private LocalDate dataPrazo;
    @Column(name = "status")
    private Status status;

    private Double precoVenda;

    public Produto(String descricao, String nome) {
        this.nome = nome;

        super.setDescricao(descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double calcularMargemDeLucro(){
        double lucro = super.getValorUnitario() - precoCompra;
        double margemLucro = (lucro / super.getValorUnitario()) * 100;
        return margemLucro;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) throws MargemLucroException {
        super.setValorUnitario(precoVenda);

        if(this.calcularMargemDeLucro() < 20.0){
          throw new MargemLucroException();
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                "descricao='" + super.getDescricao() + '\'' +
                '}';
    }
}
