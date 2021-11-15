package com.bancobts.apphexagonal.application.mapper;

import com.bancobts.apphexagonal.application.dto.ContaBancariaDto;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContaBancariaApplicationMapper {

    public static ContaBancariaDto unmarshall(ContaBancariaResponse contaBancariaAssociada) {
        if (Objects.isNull(contaBancariaAssociada)) {
            return null;
        }

        return ContaBancariaDto.builder()
                .codigoBanco(contaBancariaAssociada.getCodigoBanco())
                .numeroConta(contaBancariaAssociada.getNumeroConta())
                .digitoConta(contaBancariaAssociada.getDigitoConta())
                .build();
    }
}