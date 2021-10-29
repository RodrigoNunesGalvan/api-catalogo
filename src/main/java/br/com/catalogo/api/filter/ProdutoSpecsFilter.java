package br.com.catalogo.api.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ProdutoSpecsFilter")
public class ProdutoSpecsFilter {

    @ApiModelProperty(value = "Nome do Produto", dataType = "String", example = "samsung")
    private String productName;

    @ApiModelProperty(value = "Preço do Produto", dataType = "int", example = "5568999")
    private int productPrice;

}
