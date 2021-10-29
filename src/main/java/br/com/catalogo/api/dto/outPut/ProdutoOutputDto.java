package br.com.catalogo.api.dto.outPut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoOutputDto {

    private Long produtoId;
    private String name;
    private String description;
    private BigDecimal price;
}
