package com.satc.satcloja.model;

import java.time.LocalDate;

public class Produto extends ItemVendavel {
    private String nome;
    private Double precoCompra;

    private LocalDate dataValidade;
    private LocalDate dataPrazo;
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
