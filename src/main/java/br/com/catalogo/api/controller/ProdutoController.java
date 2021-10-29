package br.com.catalogo.api.controller;

import br.com.catalogo.api.controller.swagger.ProdutoControllerSwagger;
import br.com.catalogo.api.dto.input.ProdutoInputDto;
import br.com.catalogo.api.dto.outPut.ProdutoOutputDto;
import br.com.catalogo.api.filter.ProdutoFilter;
import br.com.catalogo.api.filter.ProdutoSpecsFilter;
import br.com.catalogo.api.model.Produto;
import br.com.catalogo.api.service.ProdutoService;
import br.com.catalogo.api.repository.specification.ProdutoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/produto")
public class ProdutoController implements ProdutoControllerSwagger {

    @Autowired
    private ProdutoService service;

    @Override
    @GetMapping
    public ResponseEntity<Page<ProdutoOutputDto>> findAll(Pageable pageable, ProdutoFilter filter){
        return ResponseEntity.ok(service.findAllV2(filter, pageable));
    }

    @GetMapping("/spec")
    public ResponseEntity<Page<ProdutoOutputDto>> findAllSpec(ProdutoSpecification spec, Pageable pageable){
        return ResponseEntity.ok(service.findAllSpec(spec, pageable));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutputDto> findById(@PathVariable Long id) {

        ProdutoOutputDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/produtos")
    public Page<Produto> findByNameAndNumber(ProdutoSpecsFilter filter, Pageable pageable) {
        Page<Produto> dto = service.findByNameAndNumber(filter, pageable);
        return dto;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoOutputDto> save (@RequestBody ProdutoInputDto produto, UriComponentsBuilder uri) {
        ProdutoOutputDto dto = service.save(produto);
        return ResponseEntity.created(uri.path("/produto/{id}").buildAndExpand(dto.getProdutoId()).toUri()).body(dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProdutoInputDto produto, @PathVariable Long id) {
        return ResponseEntity.ok(service.update(id, produto));
    }
}
