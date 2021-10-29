package br.com.catalogo.api.repository.filter.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.catalogo.api.filter.ProdutoFilter;
import br.com.catalogo.api.model.Produto;
import br.com.catalogo.api.repository.ProdutoFilterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public class ProdutoFilterRepositoryImpl implements ProdutoFilterRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Produto> find(Pageable pageable, ProdutoFilter filter) {

        StringBuilder sql  = new StringBuilder("from PRODUTO c where 0 = 0 ");
        Map<String, Object> param = new HashMap<String, Object>();

        if(filter.getProdutoId() != null) {
            System.out.println(filter.getProdutoId());
            sql.append("and c.produtoId = :id produto");
            param.put("id produto", filter.getProdutoId());
        }

        if(filter.getName() != null) {
            sql.append("and c.name = :name ");
            param.put("name", filter.getName());
        }

        TypedQuery<Produto> query = manager.createQuery(sql.toString(), Produto.class);
        param.forEach(query::setParameter);

        long size = (long) query.getResultList().size();

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return new PageImpl<>(query.getResultList(), pageable, size);
    }

}
