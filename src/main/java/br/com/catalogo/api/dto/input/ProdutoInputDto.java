package br.com.catalogo.api.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProdutoInputDto {

    @NotNull
    private Long produtoId;
    private String name;
    private String description;
    private BigDecimal price;
}
