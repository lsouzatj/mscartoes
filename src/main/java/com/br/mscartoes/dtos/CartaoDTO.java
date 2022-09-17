package com.br.mscartoes.dtos;

import com.br.mscartoes.enuns.BandeiraCartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoDTO {

    private String nome;
    private BandeiraCartao bandeiraCartao;
    private BigDecimal renda;
    private BigDecimal limiteBasico;
}
