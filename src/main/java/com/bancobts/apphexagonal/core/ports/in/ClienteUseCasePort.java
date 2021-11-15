package com.bancobts.apphexagonal.core.ports.in;

import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;

import java.util.List;

public interface ClienteUseCasePort {

    List<ClienteResponse> buscarClientesCadastrados();

    ClienteResponse buscarClientePorId(Long clienteId);

    ClienteResponse cadastrarNovoCliente(ClienteRequest novoCliente);
}