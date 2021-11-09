package com.bancobts.apphexagonal.core.usecase;

import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import com.bancobts.apphexagonal.core.ports.in.ContaBancariaUseCasePort;
import com.bancobts.apphexagonal.core.ports.out.ContaBancariaPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class CadastroContaBancariaUseCaseImpl implements ContaBancariaUseCasePort {

    private final ContaBancariaPersistencePort contaBancariaPersistencePort;
    private final CadastroClienteUseCaseImpl cadastroClienteUseCase;

    @Override
    public ContaBancariaResponse associarContaComCliente(Long clienteId) {
        Mono<ClienteResponse> clienteEncontrado = cadastroClienteUseCase.buscarClientePorId(clienteId);
        ContaBancariaResponse contaBancariaCriada = gerarDadosBancariosCliente();
        return contaBancariaPersistencePort.associarContaComCliente(clienteEncontrado.block(), contaBancariaCriada);
    }

    private ContaBancariaResponse gerarDadosBancariosCliente() {

        Random gerarNumeroAleatorio = new Random();
        String numeroAleatorio = String.valueOf(gerarNumeroAleatorio.nextInt(999999));

        String numeroConta = numeroAleatorio.substring(0, 5);
        String digitoConta = numeroAleatorio.substring(5);

        if (digitoConta.isEmpty()) {
            digitoConta = "X";
        }

        return ContaBancariaResponse.builder()
                .codigoBanco("268")
                .numeroConta(numeroConta)
                .digitoConta(digitoConta)
                .build();
    }

}
