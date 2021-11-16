package com.bancobts.apphexagonal.core.domain.model.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteRequest {

    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private String ddd;
    private String celular;
}
