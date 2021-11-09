package com.bancobts.apphexagonal.core.ports.out;

import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientePersistencePort {

    Flux<ClienteResponse> buscarClientesCadastrados();

    Mono<ClienteResponse> buscarClienteCadastradoPorId(Long clienteId);

    Mono<ClienteResponse> salvarNovoCliente(ClienteRequest novoCliente);
}
