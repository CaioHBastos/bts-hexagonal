package com.bancobts.apphexagonal.adapter.in.controller;

import com.bancobts.apphexagonal.application.ContaBancariaApplication;
import com.bancobts.apphexagonal.application.dto.ContaBancariaDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/bancobts/v1/clientes/{clienteId}")
public class ContaBancariaController {

    private ContaBancariaApplication contaBancariaApplication;

    @PutMapping("/conta")
    public ResponseEntity<ContaBancariaDto> assosciar(@PathVariable Long clienteId) {
        ContaBancariaDto contaBancariaAssociada = contaBancariaApplication.associarContaComCliente(clienteId);
        return ResponseEntity.ok(contaBancariaAssociada);
    }
}