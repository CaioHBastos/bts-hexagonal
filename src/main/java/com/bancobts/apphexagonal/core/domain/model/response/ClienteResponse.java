package com.bancobts.apphexagonal.core.domain.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteResponse {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private String ddd;
    private String celular;
    private ContaBancariaResponse contaBancaria;
}
