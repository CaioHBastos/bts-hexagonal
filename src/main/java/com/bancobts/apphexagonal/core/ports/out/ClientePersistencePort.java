package com.bancobts.apphexagonal.core.ports.out;

import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;

import java.util.List;
import java.util.Optional;

public interface ClientePersistencePort {

    List<ClienteResponse> buscarClientesCadastrados();

    Optional<ClienteResponse> buscarClienteCadastradoPorId(Long clienteId);

    ClienteResponse salvarNovoCliente(ClienteRequest novoCliente);
}