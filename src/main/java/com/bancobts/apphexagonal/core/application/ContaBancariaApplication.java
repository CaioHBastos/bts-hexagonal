package com.bancobts.apphexagonal.core.application;

import com.bancobts.apphexagonal.core.application.dto.ContaBancariaDto;

public interface ContaBancariaApplication {

    ContaBancariaDto associarContaComCliente(Long clienteId);
}