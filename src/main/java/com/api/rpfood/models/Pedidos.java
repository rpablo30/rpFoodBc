package com.api.rpfood.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "pedidos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clienteNome", columnDefinition = "VARCHAR(255) DEFAULT 'Nome Padrão'")
    private String clienteNome;


    @Column(nullable = true)
    private String clienteTelefone;

    @Column(nullable = true)
    private String clienteEndereco;

    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = true)
    private String tipoEntrega;

    @Column(nullable = true)
    private BigDecimal taxaEntrega;

    @Column(nullable = true)
    private String status;

    @Column(nullable = true)
    private BigDecimal valorTotal;

    private String hoverStatus;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dataHoraPedido;

    public String getHoverStatus() {
        return hoverStatus;
    }

    public void setHoverStatus(String hoverStatus) {
        this.hoverStatus = hoverStatus;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensDoPedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(String clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }
}
