package com.api.rpfood.controllers;

import com.api.rpfood.models.ItemPedidoConcluido;
import com.api.rpfood.models.PedidoConcluido;
import com.api.rpfood.services.PedidoConcluidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            // Verifique se a lista não é nula antes de manipulá-la
            if (pedidoConcluido.getItensDoPedidoConcluido() != null) {
                // Crie uma nova lista para armazenar os itens válidos
                List<ItemPedidoConcluido> itensValidos = new ArrayList<>();

                // Adicione os itens válidos à nova lista
                for (ItemPedidoConcluido item : pedidoConcluido.getItensDoPedidoConcluido()) {
                    if (item.getId() != null) {
                        itensValidos.add(item);
                    }
                }

                // Atribua a nova lista à propriedade itensDoPedidoConcluido
                pedidoConcluido.setItensDoPedidoConcluido(itensValidos);
            }

            System.out.println("PedidoConcluido antes de salvar: " + pedidoConcluido);

            pedidoConcluidoService.salvarPedidoConcluido(pedidoConcluido);

            System.out.println("PedidoConcluido salvo com sucesso.");

            // Qualquer outra lógica relacionada ao relatório

            return new ResponseEntity<>("Relatório enviado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erro ao enviar o relatório: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
