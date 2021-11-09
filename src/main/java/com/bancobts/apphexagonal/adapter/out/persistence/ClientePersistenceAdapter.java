package com.bancobts.apphexagonal.adapter.out.persistence;

import com.bancobts.apphexagonal.adapter.out.entity.ClienteEntity;
import com.bancobts.apphexagonal.adapter.out.mapper.ClienteMapper;
import com.bancobts.apphexagonal.adapter.out.repository.ClienteRepository;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.ports.out.ClientePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ClientePersistenceAdapter implements ClientePersistencePort {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponse> buscarClientesCadastrados() {
        List<ClienteEntity> clientesCadastrados = clienteRepository.findAll();
        return ClienteMapper.unmarshall(clientesCadastrados);
    }

    @Override
    public Optional<ClienteResponse> buscarClienteCadastradoPorId(Long clienteId) {
        Optional<ClienteEntity> clienteEncontradoPorId = clienteRepository.findById(clienteId);
        return ClienteMapper.unmarshall(clienteEncontradoPorId);
    }

    @Transactional
    @Override
    public ClienteResponse salvarNovoCliente(ClienteRequest novoCliente) {
        ClienteEntity novoClienteEntity = ClienteMapper.marshall(novoCliente);
        ClienteEntity clienteEntityCadastrado = clienteRepository.save(novoClienteEntity);
        return ClienteMapper.unmarshall(clienteEntityCadastrado);
    }
}
