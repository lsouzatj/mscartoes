package com.br.mscartoes.servicies.impl;

import com.br.mscartoes.entities.Cartao;
import com.br.mscartoes.repositories.CartaoRepository;
import com.br.mscartoes.servicies.CartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoImpl implements CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao save(Cartao cartao){
        cartaoRepository.save(cartao);
        return cartao;
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
