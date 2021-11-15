package com.bancobts.apphexagonal.adapter.in.controller;

import com.bancobts.apphexagonal.application.ClienteApplication;
import com.bancobts.apphexagonal.application.dto.ClienteCompletoDto;
import com.bancobts.apphexagonal.application.dto.ClienteResumoDto;
import com.bancobts.apphexagonal.application.dto.input.ClienteInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bancobts/v1/clientes")
public class ClienteController {

    private ClienteApplication clienteApplication;

    @GetMapping
    public ResponseEntity<List<ClienteResumoDto>> buscarTodos() {
        List<ClienteResumoDto> clientesCadastrados = clienteApplication.buscarClientes();
        return ResponseEntity.ok(clientesCadastrados);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteCompletoDto> buscarPorId(@PathVariable Long clienteId) {
        ClienteCompletoDto clienteCadastrado = clienteApplication.buscarClientePorId(clienteId);
        return ResponseEntity.ok(clienteCadastrado);
    }

    @PostMapping
    public ResponseEntity<ClienteResumoDto> adicionar(@RequestBody @Valid ClienteInput novoClienteInput) {
        ClienteResumoDto novoClienteCadastrado = clienteApplication.cadastrarCliente(novoClienteInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoClienteCadastrado);
    }
}