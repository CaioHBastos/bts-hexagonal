package com.bancobts.apphexagonal.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder
public class MensagemExceptionDto {

    private Integer status;
    private String tipo;
    private String titulo;
    private String detalhe;
    private OffsetDateTime horario;
}
