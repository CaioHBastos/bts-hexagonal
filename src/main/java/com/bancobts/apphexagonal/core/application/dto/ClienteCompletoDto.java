package com.bancobts.apphexagonal.core.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteCompletoDto {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private String ddd;
    private String celular;
    private ContaBancariaDto contaBancaria;
}

