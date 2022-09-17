package com.br.mscartoes.controllers;

import com.br.mscartoes.dtos.CartaoDTO;
import com.br.mscartoes.entities.Cartao;
import com.br.mscartoes.entities.ClienteCartao;
import com.br.mscartoes.servicies.CartaoService;
import com.br.mscartoes.servicies.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "/cartoes")
public class CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping(value = "/status")
    public String status(){
        log.info("Testando status do servico de cartao.");
        return ("Stastus servico cartao ok.");
    }

    @PostMapping(value = "/saveCartao")
    public ResponseEntity saveCartao(@RequestBody CartaoDTO cartaoDTO){
        var cartao = new Cartao();
        BeanUtils.copyProperties(cartaoDTO, cartao);
        cartaoService.save(cartao);
        log.info("Dados do cartao cadastrados com sucesso {}", cartao);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
    }

    @GetMapping(value = "/getCartoesPorLimite", params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        var listCartoes = cartaoService.getCartoesRendaMenorIgual(renda);
        log.info("Consultando os cartoes.");
        return ResponseEntity.status(HttpStatus.OK).body(listCartoes);
    }

    @GetMapping(value = "/getCartoesCliente", params = "cpf")
    public ResponseEntity<List<ClienteCartao>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        var listCartoes = clienteCartaoService.listCartoesByCpf(cpf);
        log.info("Consultando a lista de cartoes.");
        return ResponseEntity.status(HttpStatus.OK).body(listCartoes);
    }
}
