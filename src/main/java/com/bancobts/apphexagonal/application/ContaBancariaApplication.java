package com.bancobts.apphexagonal.application;

import com.bancobts.apphexagonal.application.dto.ContaBancariaDto;

public interface ContaBancariaApplication {

    ContaBancariaDto associarContaComCliente(Long clienteId);
}
