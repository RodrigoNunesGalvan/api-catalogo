package br.com.catalogo.api.repository;

import br.com.catalogo.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoFilterRepository, JpaSpecificationExecutor<Produto> {
    Produto findByName(String name);
    Optional<Produto> findByProdutoId(Long id);
}
