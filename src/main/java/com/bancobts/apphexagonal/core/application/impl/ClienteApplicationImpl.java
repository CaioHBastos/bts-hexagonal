package com.bancobts.apphexagonal.core.application.impl;

import com.bancobts.apphexagonal.core.application.ClienteApplication;
import com.bancobts.apphexagonal.core.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.core.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.core.application.dto.input.ClienteInput;
import com.bancobts.apphexagonal.core.application.exception.NenhumConteudoEncontradoException;
import com.bancobts.apphexagonal.core.application.mapper.ClienteApplicationMapper;
import com.bancobts.apphexagonal.core.domain.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.domain.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.domain.ports.in.ClienteUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ClienteApplicationImpl implements ClienteApplication {

    private final ClienteUseCasePort cadastroClienteUseCase;

    @Override
    public List<ClienteResumoDto> buscarClientes() {
        List<ClienteResponse> clientesCadastrados = cadastroClienteUseCase.buscarClientesCadastrados();

        if (clientesCadastrados.isEmpty()) {
            throw new NenhumConteudoEncontradoException();
        }

        return ClienteApplicationMapper.unmarshall(clientesCadastrados);
    }

    @Override
    public ClienteCompletoDto buscarClientePorId(Long clienteId) {
        ClienteResponse clienteCadastrado = cadastroClienteUseCase.buscarClientePorId(clienteId);
        return ClienteApplicationMapper.unmarshallCompleto(clienteCadastrado);
    }

    @Override
    public ClienteResumoDto cadastrarCliente(ClienteInput novoClienteInput) {
        ClienteRequest novoCliente = ClienteApplicationMapper.marshall(novoClienteInput);
        ClienteResponse novoClienteCadastrado = cadastroClienteUseCase.cadastrarNovoCliente(novoCliente);
        return ClienteApplicationMapper.unmarshall(novoClienteCadastrado);
    }

}