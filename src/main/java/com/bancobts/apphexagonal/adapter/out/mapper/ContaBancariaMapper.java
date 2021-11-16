package com.bancobts.apphexagonal.adapter.out.mapper;

import com.bancobts.apphexagonal.adapter.out.entity.ContaBancariaEntity;
import com.bancobts.apphexagonal.core.domain.model.response.ContaBancariaResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaBancariaMapper {

    public static ContaBancariaEntity marshall(ContaBancariaResponse contaBancariaCriada) {
        return ContaBancariaEntity.builder()
                .codigoBanco(contaBancariaCriada.getCodigoBanco())
                .numeroConta(contaBancariaCriada.getNumeroConta())
                .digitoConta(contaBancariaCriada.getDigitoConta())
                .build();
    }

    public static ContaBancariaResponse unmarshall(ContaBancariaEntity contaBancaria) {
        if (Objects.isNull(contaBancaria)) {
            return null;
        }

        return ContaBancariaResponse.builder()
                .codigoBanco(contaBancaria.getCodigoBanco())
                .numeroConta(contaBancaria.getNumeroConta())
                .digitoConta(contaBancaria.getDigitoConta())
                .build();
    }
}