package com.bancobts.apphexagonal.exception;

import com.bancobts.apphexagonal.application.exception.NenhumConteudoEncontradoException;
import com.bancobts.apphexagonal.core.exception.RegistroNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NenhumConteudoEncontradoException.class)
    public final ResponseEntity<Void> nenhumConteudoHandler(Exception exception) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public final ResponseEntity<MensagemExceptionDto> registroNaoEncontradoHandler(Exception exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiTipoProblemaEnum tipoProblema = ApiTipoProblemaEnum.RECURSO_NAO_ENCONTRADO;

        MensagemExceptionDto mensagemExceptionDto = MensagemExceptionDto.builder()
                .status(httpStatus.value())
                .tipo(tipoProblema.getUri())
                .titulo(tipoProblema.getTitulo())
                .detalhe(exception.getMessage())
                .horario(OffsetDateTime.now())
                .build();

        return new ResponseEntity<>(mensagemExceptionDto, httpStatus);
    }
}
