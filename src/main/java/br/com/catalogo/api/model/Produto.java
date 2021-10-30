package br.com.catalogo.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCT", schema = "CATALOG_PRODUCT")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUTO_ID")
    private Long produtoId;

    @NotNull(message = "O valor campo não pode ser nulo")
    @Column(name = "PRODUCT_NAME")
    private String name;

    @NotNull(message = "O valor campo não pode ser nulo")
    @Column(name = "DESCRIPTION")
    private String description;

    @Positive(message = "O valor do campo deve ser um número positivo")
    @Column(name = "PRICE")
    private BigDecimal price;
}
