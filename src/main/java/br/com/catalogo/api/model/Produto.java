package br.com.catalogo.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATALOGO_PRODUTO", schema = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUTO_ID")
    private Long produtoId;

    @NotNull(message = "O valor campo não pode ser nulo")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "O valor campo não pode ser nulo")
    @Column(name = "DESCRIPTION")
    private String description;

    @Positive(message = "O valor do campo deve ser um número positivo")
    @Column(name = "PRICE")
    private BigDecimal price;
}
