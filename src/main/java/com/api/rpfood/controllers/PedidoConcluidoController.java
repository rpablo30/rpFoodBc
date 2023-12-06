package com.api.rpfood.controllers;

import com.api.rpfood.models.PedidoConcluido;
import com.api.rpfood.services.PedidoConcluidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos-concluidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoConcluidoController {

    private final PedidoConcluidoService pedidoConcluidoService;


    @Autowired
    public PedidoConcluidoController(PedidoConcluidoService pedidoConcluidoService) {
        this.pedidoConcluidoService = pedidoConcluidoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PedidoConcluido> buscarPedidoConcluidoPorId(@PathVariable Long id) {
        try {
            Optional<PedidoConcluido> pedidoConcluido = pedidoConcluidoService.buscarPedidoConcluidoPorId(id);
            return pedidoConcluido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enviar-relatorio")
    public ResponseEntity<String> enviarRelatorio(@RequestBody PedidoConcluido pedidoConcluido) {
        try {
            // Você está chamando salvarPedidoConcluido fora da classe PedidoConcluidoService
            pedidoConcluidoService.salvarPedidoConcluido(pedidoConcluido);

            // Qualquer outra lógica relacionada ao relatório

            return new ResponseEntity<>("Relatório enviado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao enviar o relatório", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
