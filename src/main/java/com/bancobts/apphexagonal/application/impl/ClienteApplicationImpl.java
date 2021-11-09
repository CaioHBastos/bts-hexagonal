package com.bancobts.apphexagonal.application.impl;

import com.bancobts.apphexagonal.application.ClienteApplication;
import com.bancobts.apphexagonal.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.application.dto.input.ClienteInput;
import com.bancobts.apphexagonal.application.exception.NenhumConteudoEncontradoException;
import com.bancobts.apphexagonal.application.mapper.ClienteApplicationMapper;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.ports.in.ClienteUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class ClienteApplicationImpl implements ClienteApplication {

    private final ClienteUseCasePort cadastroClienteUseCase;

    @Override
    public Flux<ClienteResumoDto> buscarClientes() {

        return cadastroClienteUseCase.buscarClientesCadastrados()
                .switchIfEmpty(Mono.error(new NenhumConteudoEncontradoException()))
                .flatMap(ClienteApplicationMapper::unmarshall);
    }

    @Override
    public Mono<ClienteCompletoDto> buscarClientePorId(Long clienteId) {
        Mono<ClienteResponse> clienteCadastrado = cadastroClienteUseCase.buscarClientePorId(clienteId);
        return ClienteApplicationMapper.unmarshallCompleto(clienteCadastrado);
    }

    @Override
    public Mono<ClienteResumoDto> cadastrarCliente(ClienteInput novoClienteInput) {
        ClienteRequest novoCliente = ClienteApplicationMapper.marshall(novoClienteInput);
        Mono<ClienteResponse> novoClienteCadastrado = cadastroClienteUseCase.cadastrarNovoCliente(novoCliente);
        return ClienteApplicationMapper.unmarshall(novoClienteCadastrado);
    }

}
