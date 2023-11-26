package com.api.rpfood.repositories;

import com.api.rpfood.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos,Long> {

    List<Pedidos> findByStatus(String status);
}
