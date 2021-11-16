package com.bancobts.apphexagonal.core.domain.usecase;

import com.bancobts.apphexagonal.core.domain.exception.ClienteNaoEncontradoException;
import com.bancobts.apphexagonal.core.domain.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.domain.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.domain.ports.in.ClienteUseCasePort;
import com.bancobts.apphexagonal.core.domain.ports.out.ClientePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CadastroClienteUseCaseImpl implements ClienteUseCasePort {

    private final ClientePersistencePort clientePersistencePort;

    @Override
    public List<ClienteResponse> buscarClientesCadastrados() {
        return clientePersistencePort.buscarClientesCadastrados();
    }

    @Override
    public ClienteResponse buscarClientePorId(Long clienteId) {
        return clientePersistencePort.buscarClienteCadastradoPorId(clienteId)
                .orElseThrow(() -> new ClienteNaoEncontradoException(
                        String.format("O cliente com o id %d não foi encontrado", clienteId)));
    }

    @Override
    public ClienteResponse cadastrarNovoCliente(ClienteRequest novoCliente) {
        return clientePersistencePort.salvarNovoCliente(novoCliente);
    }
}