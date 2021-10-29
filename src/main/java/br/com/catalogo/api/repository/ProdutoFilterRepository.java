package br.com.catalogo.api.repository;

import br.com.catalogo.api.filter.ProdutoFilter;
import br.com.catalogo.api.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoFilterRepository {
    Page<Produto> find(Pageable pageable, ProdutoFilter filter);
}
