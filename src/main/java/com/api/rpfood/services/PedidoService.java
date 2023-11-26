package com.api.rpfood.services;

import com.api.rpfood.models.Pedidos;
import com.api.rpfood.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedidos criarPedido(Pedidos pedido) {
        try {
            if (pedido.getItensDoPedido() == null || pedido.getItensDoPedido().isEmpty()) {
                throw new RuntimeException("Pedido deve ter pelo menos um item.");
            }

            // Defina o status como "Pendente" antes de salvar
            pedido.setStatus("Pendente");

            // Associe o pedido a cada item do pedido
            pedido.getItensDoPedido().forEach(item -> item.setPedido(pedido));

            // Calcula o valor total com base nos itens do pedido
            BigDecimal valorTotal = pedido.getItensDoPedido().stream()
                    .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            pedido.setValorTotal(valorTotal);

            // Adicione log antes de salvar
            System.out.println("Salvando pedido no banco de dados...");

            // Salva o pedido no banco de dados
            Pedidos pedidoSalvo = pedidoRepository.save(pedido);

            // Adicione log após salvar
            System.out.println("Pedido salvo com sucesso.");

            return pedidoSalvo;
        } catch (Exception e) {
            // Adicione log em caso de exceção
            System.err.println("Erro ao criar pedido: " + e.getMessage());

            // Lança uma exceção mais específica com uma mensagem informativa
            throw new RuntimeException("Erro ao criar o pedido. Por favor, tente novamente mais tarde.");
        }
    }

    public List<Pedidos> listarPedidosPorStatus(String status) {
        try {
            return pedidoRepository.findByStatus(status);
        } catch (Exception e) {
            // Adicione log em caso de exceção
            System.err.println("Erro ao listar pedidos por status: " + e.getMessage());

            // Lança uma exceção mais específica com uma mensagem informativa
            throw new RuntimeException("Erro ao listar pedidos por status. Por favor, tente novamente mais tarde.");
        }
    }


}
