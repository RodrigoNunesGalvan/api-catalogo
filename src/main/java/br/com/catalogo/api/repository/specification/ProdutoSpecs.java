package br.com.catalogo.api.repository.specification;

import br.com.catalogo.api.model.Produto;
import org.springframework.data.jpa.domain.Specification;

//@And({
//	@Spec(path = "productName", params = "productName", spec = LikeIgnoreCase.class),
//	@Spec(path = "productPrice", params = "productPrice", spec = LikeIgnoreCase.class),
//})
public class ProdutoSpecs{

    public static Specification<Produto> comNomeSemelhante(String productName){
        return (root, query, builder) -> builder
                .like(root.get("productName"), "%" + productName +"%");
    }
    public static Specification<Produto> listaDePrecos(int productPrice){
        return (root, query, builder) -> builder.like(root.get("productPrice"), "%" + productPrice +"%");
    }
}
