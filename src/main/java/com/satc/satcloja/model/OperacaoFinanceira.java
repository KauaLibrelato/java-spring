package com.satc.satcloja.model;

import java.time.LocalDate;

public interface OperacaoFinanceira {
    public LocalDate getDataOperacao();
    public Double getValorTotalDaOperacao();
    public TipoOperacao getTipoOperacao();
}
