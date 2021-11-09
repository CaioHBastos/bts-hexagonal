package com.bancobts.apphexagonal.application.mapper;

import com.bancobts.apphexagonal.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.application.dto.input.ClienteInput;
import com.bancobts.apphexagonal.core.model.request.ClienteRequest;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteApplicationMapper {


    public static List<ClienteResumoDto> unmarshall(List<ClienteResponse> clientesCadastrados) {
        return clientesCadastrados.stream()
                .map(ClienteApplicationMapper::unmarshall)
                .collect(Collectors.toList());
    }

    public static ClienteResumoDto unmarshall(ClienteResponse clienteCadastrado) {
        if (ObjectUtils.isEmpty(clienteCadastrado)) {
            return null;
        }

        return ClienteResumoDto.builder()
                .id(clienteCadastrado.getId())
                .primeiroNome(clienteCadastrado.getPrimeiroNome())
                .ultimoNome(clienteCadastrado.getUltimoNome())
                .cpf(clienteCadastrado.getCpf())
                .ddd(clienteCadastrado.getDdd())
                .celular(clienteCadastrado.getCelular())
                .build();
    }

    public static ClienteCompletoDto unmarshallCompleto(ClienteResponse clienteCadastrado) {
        if (ObjectUtils.isEmpty(clienteCadastrado)) {
            return null;
        }

        return ClienteCompletoDto.builder()
                .id(clienteCadastrado.getId())
                .primeiroNome(clienteCadastrado.getPrimeiroNome())
                .ultimoNome(clienteCadastrado.getUltimoNome())
                .cpf(clienteCadastrado.getCpf())
                .ddd(clienteCadastrado.getDdd())
                .celular(clienteCadastrado.getCelular())
                .contaBancaria(ContaBancariaApplicationMapper.unmarshall(clienteCadastrado.getContaBancaria()))
                .build();
    }

    public static ClienteRequest marshall(ClienteInput novoClienteInput) {
        return ClienteRequest.builder()
                .primeiroNome(novoClienteInput.getPrimeiroNome())
                .ultimoNome(novoClienteInput.getUltimoNome())
                .cpf(novoClienteInput.getCpf())
                .ddd(novoClienteInput.getDdd())
                .celular(novoClienteInput.getCelular())
                .build();
    }
}
