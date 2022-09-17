package com.br.mscartoes.servicies;

import com.br.mscartoes.entities.Cartao;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoService {
    Cartao save(Cartao cartao);
    List<Cartao> getCartoesRendaMenorIgual(Long renda);
}
