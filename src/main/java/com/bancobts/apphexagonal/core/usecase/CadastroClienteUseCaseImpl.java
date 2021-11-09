package com.bancobts.apphexagonal.core.usecase;

import com.bancobts.apphexagonal.core.exception.ClienteNaoEncontradoException;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.ports.in.ClienteUseCasePort;
import com.bancobts.apphexagonal.core.ports.out.ClientePersistencePort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CadastroClienteUseCaseImpl implements ClienteUseCasePort {

    private final ClientePersistencePort clientePersistencePort;

    @Override
    public Flux<ClienteResponse> buscarClientesCadastrados() {
        return clientePersistencePort.buscarClientesCadastrados();
    }


    @Override
    public Mono<ClienteResponse> buscarClientePorId(Long clienteId) {
        Mono<ClienteResponse> clienteResponseMono = clientePersistencePort.buscarClienteCadastradoPorId(clienteId);

        if (ObjectUtils.isEmpty(clienteResponseMono.block())) {
            throw new ClienteNaoEncontradoException(
                    String.format("O cliente com o id %d não foi encontrado", clienteId));
        }

        return clienteResponseMono;
    }

    @Override
    public Mono<ClienteResponse> cadastrarNovoCliente(ClienteRequest novoCliente) {
        return clientePersistencePort.salvarNovoCliente(novoCliente);
    }
}
