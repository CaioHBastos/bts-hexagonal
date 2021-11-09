package com.bancobts.apphexagonal.application;

import com.bancobts.apphexagonal.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.application.dto.input.ClienteInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteApplication {

    Flux<ClienteResumoDto> buscarClientes();

    Mono<ClienteCompletoDto> buscarClientePorId(Long clienteId);

    Mono<ClienteResumoDto> cadastrarCliente(ClienteInput novoClienteInput);
}
