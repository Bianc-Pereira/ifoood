package br.com.fiap.ifoood.Pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String pratoPedido;

    @Positive
    @Min(value = 1, message = "A quantidade de itens deve ser maior que zero.")
    private Integer quantidadeItens;

    private String statusEntrega;

}
