package br.com.catalogo.api.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "ProdutoFilter")
public class ProdutoFilter {

    @ApiModelProperty(value = "ID do produto", dataType = "Long", example = "62793")
    private Long produtoId;

    @ApiModelProperty(value = "ID do name", dataType = "String", example = "Sansung")
    private String name;

}

