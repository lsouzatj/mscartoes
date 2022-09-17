package com.br.mscartoes.servicies.impl;

import com.br.mscartoes.entities.ClienteCartao;
import com.br.mscartoes.repositories.ClienteCartaoRepository;
import com.br.mscartoes.servicies.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoImpl implements ClienteCartaoService {
    private final ClienteCartaoRepository cartaoRepository;

    @Override
    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return cartaoRepository.findByCpf(cpf);
    }
}
