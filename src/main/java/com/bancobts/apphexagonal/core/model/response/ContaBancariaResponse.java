package com.bancobts.apphexagonal.core.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContaBancariaResponse {

    private String codigoBanco;
    private String numeroConta;
    private String digitoConta;
}
