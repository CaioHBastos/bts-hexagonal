package com.bancobts.apphexagonal.core.domain.ports.in;

import com.bancobts.apphexagonal.core.domain.model.response.ContaBancariaResponse;

public interface ContaBancariaUseCasePort {

    ContaBancariaResponse associarContaComCliente(Long clienteId);
}