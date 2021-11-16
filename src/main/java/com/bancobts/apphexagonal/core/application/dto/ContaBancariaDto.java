package com.bancobts.apphexagonal.core.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaBancariaDto {

    private String codigoBanco;
    private String numeroConta;
    private String digitoConta;
}
