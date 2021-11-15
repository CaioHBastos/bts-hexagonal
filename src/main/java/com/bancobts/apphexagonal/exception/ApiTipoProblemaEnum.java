package com.bancobts.apphexagonal.exception;

import lombok.Getter;

@Getter
public enum ApiTipoProblemaEnum {

    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    UNPROCESSABLE_ENTITY("/regra-de-negocio-violada", "Regra de negocio violada");

    private String uri;
    private String titulo;

    ApiTipoProblemaEnum(String path, String titulo) {
        this.uri = "https://bancobts.com.br" + path;
        this.titulo = titulo;
    }
}
