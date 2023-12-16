package com.api.rpfood.services;

import com.api.rpfood.models.ItemPedido;
import com.api.rpfood.models.Pedidos;
import com.api.rpfood.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public Optional<Pedidos> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    public List<Pedidos> listarTodosPedidos() {
        return pedidoRepository.findAll();
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


    public Pedidos atualizarPedido(Pedidos pedido) {
        try {
            // Verifique se o pedido tem um ID válido
            if (pedido.getId() == null) {
                throw new RuntimeException("ID do pedido é nulo. O pedido deve ser persistido antes de atualizar.");
            }

            // Busque o pedido no banco de dados pelo ID
            Optional<Pedidos> optionalPedido = pedidoRepository.findById(pedido.getId());

            if (optionalPedido.isPresent()) {
                Pedidos pedidoExistente = optionalPedido.get();

                // Atualize os campos do pedido existente com os novos valores
                pedidoExistente.setClienteNome(pedido.getClienteNome());
                pedidoExistente.setClienteTelefone(pedido.getClienteTelefone());
                pedidoExistente.setClienteEndereco(pedido.getClienteEndereco());
                pedidoExistente.setFormaPagamento(pedido.getFormaPagamento());
                pedidoExistente.setTipoEntrega(pedido.getTipoEntrega());
                pedidoExistente.setTaxaEntrega(pedido.getTaxaEntrega());
                pedidoExistente.setStatus(pedido.getStatus());
                pedidoExistente.setValorTotal(pedido.getValorTotal());
                pedidoExistente.setDataHoraPedido(pedido.getDataHoraPedido());

                // Atualize os itens do pedido
                List<ItemPedido> novosItens = pedido.getItensDoPedido();
                List<ItemPedido> itensExistentes = pedidoExistente.getItensDoPedido();

                // Remova os itens do pedido que não estão mais presentes na lista
                itensExistentes.removeIf(item -> item.getId() != null && !novosItens.contains(item));

                // Associe os itens do pedido ao pedido existente
                novosItens.forEach(item -> item.setPedido(pedidoExistente));

                // Atualize a lista de itens do pedido existente
                itensExistentes.clear();
                itensExistentes.addAll(novosItens);

                // Salve o pedido atualizado no banco de dados
                return pedidoRepository.save(pedidoExistente);
            } else {
                // Retorne null ou lance uma exceção, dependendo do seu requisito
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o pedido: " + e.getMessage());
        }
    }

    public void excluirPedido(Long id) {
        try {
            // Verifique se o ID do pedido é válido
            if (id == null) {
                throw new IllegalArgumentException("ID do pedido não pode ser nulo.");
            }

            // Verifique se o pedido existe no banco de dados
            Optional<Pedidos> optionalPedido = pedidoRepository.findById(id);

            if (optionalPedido.isPresent()) {
                // Remova o pedido do banco de dados
                pedidoRepository.deleteById(id);

                // Adicione log ou outras ações necessárias após excluir o pedido
                System.out.println("Pedido removido com sucesso.");
            } else {
                // Lança uma exceção se o pedido não for encontrado
                throw new RuntimeException("Pedido não encontrado com o ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Adicione log ou ações necessárias em caso de erro
            throw new RuntimeException("Erro ao excluir o pedido: " + e.getMessage());
        }
    }


}
