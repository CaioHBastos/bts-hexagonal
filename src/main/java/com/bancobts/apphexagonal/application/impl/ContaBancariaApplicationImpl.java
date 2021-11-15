package com.bancobts.apphexagonal.application.impl;

import com.bancobts.apphexagonal.application.ContaBancariaApplication;
import com.bancobts.apphexagonal.application.dto.ContaBancariaDto;
import com.bancobts.apphexagonal.application.mapper.ContaBancariaApplicationMapper;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import com.bancobts.apphexagonal.core.ports.in.ContaBancariaUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ContaBancariaApplicationImpl implements ContaBancariaApplication {

    private final ContaBancariaUseCasePort contaBancariaUseCasePort;

    @Override
    public ContaBancariaDto associarContaComCliente(Long clienteId) {
        ContaBancariaResponse contaBancariaAssociada = contaBancariaUseCasePort.associarContaComCliente(clienteId);
        return ContaBancariaApplicationMapper.unmarshall(contaBancariaAssociada);
    }
}