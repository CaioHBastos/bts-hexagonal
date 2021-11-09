package com.bancobts.apphexagonal.adapter.out.mapper;

import com.bancobts.apphexagonal.adapter.out.entity.ClienteEntity;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {


    public static List<ClienteResponse> unmarshall(List<ClienteEntity> clientesCadastrados) {
        return clientesCadastrados.stream()
                .map(ClienteMapper::unmarshall)
                .collect(Collectors.toList());
    }

    public static Optional<ClienteResponse> unmarshall(Optional<ClienteEntity> clienteCadastrado) {
        if (clienteCadastrado.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(unmarshall(clienteCadastrado.get()));
    }

    public static ClienteResponse unmarshall(ClienteEntity clienteCadastrado) {
        if (ObjectUtils.isEmpty(clienteCadastrado)) {
            return null;
        }

        return ClienteResponse.builder()
                .id(clienteCadastrado.getId())
                .primeiroNome(clienteCadastrado.getPrimeiroNome())
                .ultimoNome(clienteCadastrado.getUltimoNome())
                .cpf(clienteCadastrado.getCpf())
                .ddd(clienteCadastrado.getDdd())
                .celular(clienteCadastrado.getCelular())
                .contaBancaria(ContaBancariaMapper.unmarshall(clienteCadastrado.getContaBancaria()))
                .build();
    }

    public static ClienteEntity marshall(ClienteRequest novoCliente) {
        return ClienteEntity.builder()
                .primeiroNome(novoCliente.getPrimeiroNome())
                .ultimoNome(novoCliente.getUltimoNome())
                .cpf(novoCliente.getCpf())
                .ddd(novoCliente.getDdd())
                .celular(novoCliente.getCelular())
                .build();
    }

    public static ClienteEntity marshall(ClienteResponse clienteEncontrado, ContaBancariaResponse contaBancariaCriada) {
        return ClienteEntity.builder()
                .id(clienteEncontrado.getId())
                .primeiroNome(clienteEncontrado.getPrimeiroNome())
                .ultimoNome(clienteEncontrado.getUltimoNome())
                .cpf(clienteEncontrado.getCpf())
                .ddd(clienteEncontrado.getDdd())
                .celular(clienteEncontrado.getCelular())
                .contaBancaria(ContaBancariaMapper.marshall(contaBancariaCriada))
                .build();
    }
}
