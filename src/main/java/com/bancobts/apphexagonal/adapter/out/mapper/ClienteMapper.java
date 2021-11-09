package com.bancobts.apphexagonal.adapter.out.mapper;

import com.bancobts.apphexagonal.adapter.out.entity.ClienteEntity;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteMapper {

    public static Mono<ClienteResponse> unmarshall(ClienteEntity clienteCadastrado) {
        if (Objects.isNull(clienteCadastrado)) {
            return null;
        }

        return Mono.just(ClienteResponse.builder()
                .id(clienteCadastrado.getId())
                .primeiroNome(clienteCadastrado.getPrimeiroNome())
                .ultimoNome(clienteCadastrado.getUltimoNome())
                .cpf(clienteCadastrado.getCpf())
                .ddd(clienteCadastrado.getDdd())
                .celular(clienteCadastrado.getCelular())
                .contaBancaria(ContaBancariaMapper.unmarshall(clienteCadastrado.getContaBancaria()))
                .build());
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

    public static Mono<ClienteResponse> unmarshall(Optional<ClienteEntity> clienteEncontradoPorId) {
        if (clienteEncontradoPorId.isEmpty()) {
            return Mono.empty();
        }

        return unmarshall(clienteEncontradoPorId.get());
    }
}
