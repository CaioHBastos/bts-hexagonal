package com.bancobts.apphexagonal.core.application.dto.input;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
public class ClienteInput {

    @NotBlank
    private String primeiroNome;

    @NotBlank
    private String ultimoNome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String ddd;

    @NotBlank
    private String celular;
}
