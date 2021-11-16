package com.bancobts.apphexagonal.core.application;

import com.bancobts.apphexagonal.core.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.core.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.core.application.dto.input.ClienteInput;

import java.util.List;

public interface ClienteApplication {

    List<ClienteResumoDto> buscarClientes();

    ClienteCompletoDto buscarClientePorId(Long clienteId);

    ClienteResumoDto cadastrarCliente(ClienteInput novoClienteInput);
}