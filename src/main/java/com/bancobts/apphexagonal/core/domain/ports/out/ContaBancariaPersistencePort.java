package com.bancobts.apphexagonal.core.domain.ports.out;

import com.bancobts.apphexagonal.core.domain.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.domain.model.response.ContaBancariaResponse;

public interface ContaBancariaPersistencePort {

    ContaBancariaResponse associarContaComCliente(ClienteResponse clienteEncontrado, ContaBancariaResponse contaBancariaCriada);
}