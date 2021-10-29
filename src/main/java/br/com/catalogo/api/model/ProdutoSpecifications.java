package br.com.catalogo.api.model;

import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecifications {

    public static Specification<Produto> hasProdutoId(Long produtoId) {
        if (produtoId == null) {
            return (produto, cq, cb) -> cb.conjunction();
        }
        return (produto, cq, cb) -> cb.equal(produto.get("produtoId"), produtoId);
    }

    public static Specification<Produto> hasName(String name) {
        if (name == null) {
            return (produto, cq, cb) -> cb.conjunction();
        }
        return (produto, cq, cb) -> cb.equal(produto.get("name"), name);
    }

}
