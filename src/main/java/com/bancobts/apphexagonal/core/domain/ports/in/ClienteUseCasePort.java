package com.bancobts.apphexagonal.core.domain.ports.in;

import com.bancobts.apphexagonal.core.domain.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.domain.model.response.ClienteResponse;

import java.util.List;

public interface ClienteUseCasePort {

    List<ClienteResponse> buscarClientesCadastrados();

    ClienteResponse buscarClientePorId(Long clienteId);

    ClienteResponse cadastrarNovoCliente(ClienteRequest novoCliente);
}