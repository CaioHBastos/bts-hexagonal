package com.bancobts.apphexagonal.adapter.out.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContaBancariaEntity {

    @Column(name = "cliente_codigo_banco")
    private String codigoBanco;

    @Column(name = "cliente_numero_conta")
    private String numeroConta;

    @Column(name = "cliente_digito_conta")
    private String digitoConta;
}
