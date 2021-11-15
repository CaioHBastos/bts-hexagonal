package com.bancobts.apphexagonal.adapter.out.persistence;

import com.bancobts.apphexagonal.adapter.out.entity.ClienteEntity;
import com.bancobts.apphexagonal.adapter.out.mapper.ClienteMapper;
import com.bancobts.apphexagonal.adapter.out.mapper.ContaBancariaMapper;
import com.bancobts.apphexagonal.adapter.out.repository.ClienteRepository;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import com.bancobts.apphexagonal.core.ports.out.ContaBancariaPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ContaBancariaPersistenceAdapter implements ContaBancariaPersistencePort {

    private final ClienteRepository clienteRepository;

    @Transactional
    @Override
    public ContaBancariaResponse associarContaComCliente(ClienteResponse clienteEncontrado, ContaBancariaResponse contaBancariaCriada) {
        ClienteEntity clienteComContaBancaria = ClienteMapper.marshall(clienteEncontrado, contaBancariaCriada);
        clienteRepository.save(clienteComContaBancaria);
        return ContaBancariaMapper.unmarshall(clienteComContaBancaria.getContaBancaria());
    }
}