package com.br.mscartoes.servicies;

import com.br.mscartoes.entities.ClienteCartao;

import java.util.List;

public interface ClienteCartaoService {
    List<ClienteCartao> listCartoesByCpf(String cpf);
}
