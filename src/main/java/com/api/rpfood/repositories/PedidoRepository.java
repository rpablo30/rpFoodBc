package com.api.rpfood.repositories;

import com.api.rpfood.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos,Long> {


}
