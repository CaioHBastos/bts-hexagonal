package com.bancobts.apphexagonal.core.domain.mode.response;

import com.bancobts.apphexagonal.core.domain.model.response.ContaBancariaResponse;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaResponseTest {

    private ContaBancariaResponse contaBancariaResponse = new ContaBancariaResponse();
    private Random numeroAleatorio = new Random(999999);

    @Test
    void testeGerarCodigoBancoSucesso() {
        assertEquals("268", contaBancariaResponse.gerarCodigoBanco());
    }

    @Test
    void testeGerarNumeroContaSucesso() {
        String numeroContaGerado = contaBancariaResponse.gerarNumeroConta(String.valueOf(numeroAleatorio));
        assertEquals(numeroAleatorio.toString().substring(0,5), numeroContaGerado);
    }

    @Test
    void testeGerarDigitoContaSucesso() {
        String digitoContaGerado = contaBancariaResponse.gerarDigitoConta(String.valueOf(numeroAleatorio));
        assertEquals(numeroAleatorio.toString().substring(5), digitoContaGerado);
    }
}
