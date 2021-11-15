package com.bancobts.apphexagonal.core.ports.out;

import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;

public interface ContaBancariaPersistencePort {

    ContaBancariaResponse associarContaComCliente(ClienteResponse clienteEncontrado, ContaBancariaResponse contaBancariaCriada);
}