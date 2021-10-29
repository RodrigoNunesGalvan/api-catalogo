package br.com.catalogo.api.repository.specification;

import br.com.catalogo.api.model.Produto;
import org.springframework.data.jpa.domain.Specification;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
        @Spec(path = "productName", params = "productName", spec = LikeIgnoreCase.class),
        @Spec(path = "productPrice", params = "productPrice", spec = Like.class),
})
public interface ProdutoSpecification extends Specification<Produto>{}
