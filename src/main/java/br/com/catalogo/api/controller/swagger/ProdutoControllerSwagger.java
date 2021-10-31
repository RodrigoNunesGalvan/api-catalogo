package br.com.catalogo.api.controller.swagger;

import br.com.catalogo.api.dto.input.ProdutoInputDto;
import br.com.catalogo.api.dto.outPut.ProdutoOutputDto;
import br.com.catalogo.api.exception.handler.Problem;
import br.com.catalogo.api.filter.ProdutoFilter;
import br.com.catalogo.api.filter.ProdutoSpecsFilter;
import br.com.catalogo.api.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Produto")
public interface ProdutoControllerSwagger {

    @ApiOperation(value = "Busca todos os Produtos", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, response = Produto.class, message = "Requisição com sucesso"),
            @ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
    })
    ResponseEntity<Page<ProdutoOutputDto>>findAll(Pageable pageable, ProdutoFilter filter);


    @ApiOperation(value = "Busca um único Produto", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, response = Produto.class, message = "Requisição com sucesso"),
            @ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
    })
    ResponseEntity<?> findById(@PathVariable Long id);

    @ApiOperation(value = "Retorna uma lista pela pesquisa do nome e numero do Produto", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, response = Produto.class, message = "Requisição com sucesso"),
            @ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
    })
    Page<Produto> findByNameAndNumber(ProdutoSpecsFilter filter, Pageable pageable);



    @ApiOperation(value = "Adiciona um novo Produto", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 201, response = Produto.class, message = "Requisição com sucesso")
    })
    ResponseEntity<ProdutoOutputDto> save (@RequestBody @ApiParam(name="body", value = "Representação de um Produto") ProdutoInputDto produto
            , UriComponentsBuilder uri);

    @ApiOperation(value = "Atualiza um Produto", httpMethod = "PUT")
    @ApiResponses({
            @ApiResponse(code = 200, response = Produto.class, message = "Requisição com sucesso"),
            @ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
    })
    ResponseEntity<?> update (@RequestBody @ApiParam(name="body", value = "Representação de um Produto") ProdutoInputDto produto,
                              @PathVariable Long id);

    @ApiOperation(value = "Deleta um Produto", httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 200, response = Produto.class, message = "Requisição com sucesso"),
            @ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
    })
    ResponseEntity<?> delete(@PathVariable Long id);
}

