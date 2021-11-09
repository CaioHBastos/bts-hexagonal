package com.bancobts.apphexagonal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ApiTipoProblemaEnum {

    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");

    private String uri;
    private String titulo;

    ApiTipoProblemaEnum(String path, String titulo) {
        this.uri = "https://bancobts.com.br" + path;
        this.titulo = titulo;
    }
}
