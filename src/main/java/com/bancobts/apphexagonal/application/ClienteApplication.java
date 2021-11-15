package com.bancobts.apphexagonal.application;

import com.bancobts.apphexagonal.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.application.dto.input.ClienteInput;

import java.util.List;

public interface ClienteApplication {

    List<ClienteResumoDto> buscarClientes();

    ClienteCompletoDto buscarClientePorId(Long clienteId);

    ClienteResumoDto cadastrarCliente(ClienteInput novoClienteInput);
}