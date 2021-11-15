package com.bancobts.apphexagonal.core.usecase;

import com.bancobts.apphexagonal.core.exception.ClienteComContaBancariaException;
import com.bancobts.apphexagonal.core.model.response.ClienteResponse;
import com.bancobts.apphexagonal.core.model.response.ContaBancariaResponse;
import com.bancobts.apphexagonal.core.ports.in.ContaBancariaUseCasePort;
import com.bancobts.apphexagonal.core.ports.out.ContaBancariaPersistencePort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CadastroContaBancariaUseCaseImpl implements ContaBancariaUseCasePort {

    private final ContaBancariaPersistencePort contaBancariaPersistencePort;
    private final CadastroClienteUseCaseImpl cadastroClienteUseCase;

    @Override
    public ContaBancariaResponse associarContaComCliente(Long clienteId) {
        ClienteResponse clienteEncontrado = cadastroClienteUseCase.buscarClientePorId(clienteId);

        verificarSeOClienteJaTemContaBancariaAssociada(clienteEncontrado);

        ContaBancariaResponse contaBancariaCriada = new ContaBancariaResponse();
        contaBancariaCriada.gerarDadosBancarios();

        return contaBancariaPersistencePort.associarContaComCliente(clienteEncontrado, contaBancariaCriada);
    }

    private void verificarSeOClienteJaTemContaBancariaAssociada(ClienteResponse clienteEncontrado) {

        if (ObjectUtils.isNotEmpty(clienteEncontrado.getContaBancaria())) {
            throw new ClienteComContaBancariaException(
                    String.format("O cliente %d, já tem uma conta bancária associada.", clienteEncontrado.getId()));
        }
    }
}