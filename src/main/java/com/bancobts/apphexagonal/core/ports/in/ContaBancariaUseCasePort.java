package com.bancobts.apphexagonal.core.ports.in;

import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;

public interface ContaBancariaUseCasePort {

    ContaBancariaResponse associarContaComCliente(Long clienteId);
}