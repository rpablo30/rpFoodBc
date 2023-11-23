package com.api.rpfood.controllers;

import com.api.rpfood.models.Pedidos;
import com.api.rpfood.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    public ResponseEntity<Pedidos> criarPedido(@RequestBody Pedidos pedido) {
        try {
            System.out.println("Pedido recebido no backend: " + pedido.toString());

            Pedidos novoPedido = pedidoService.criarPedido(pedido);

            System.out.println("Pedido criado com sucesso: " + novoPedido.toString());

            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao processar o pedido: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
