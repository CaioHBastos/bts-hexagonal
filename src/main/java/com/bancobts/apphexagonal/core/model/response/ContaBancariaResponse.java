package com.bancobts.apphexagonal.core.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaResponse {

    private String codigoBanco;
    private String numeroConta;
    private String digitoConta;

    public String gerarCodigoBanco() {
        return this.codigoBanco = "268";
    }

    public String gerarNumeroConta(String numeroGerado) {
        this.numeroConta = numeroGerado.substring(0, 5);
        return this.numeroConta;
    }

    public String gerarDigitoConta(String numeroGerado) {
        this.digitoConta = numeroGerado.substring(5);

        if (this.numeroConta.isEmpty()) {
            this.numeroConta = "X";
        }

        return this.numeroConta;
    }

    public void gerarDadosBancarios() {
        Random gerarNumeroAleatorio = new Random();
        String numeroAleatorio = String.valueOf(gerarNumeroAleatorio.nextInt(999999));

        this.gerarCodigoBanco();
        this.gerarNumeroConta(numeroAleatorio);
        this.gerarDigitoConta(numeroAleatorio);
    }
}
