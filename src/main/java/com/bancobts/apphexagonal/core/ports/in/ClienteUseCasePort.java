package com.bancobts.apphexagonal.core.ports.in;

import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteUseCasePort {

    Flux<ClienteResponse> buscarClientesCadastrados();

    Mono<ClienteResponse> buscarClientePorId(Long clienteId);

    Mono<ClienteResponse> cadastrarNovoCliente(ClienteRequest novoCliente);
}
