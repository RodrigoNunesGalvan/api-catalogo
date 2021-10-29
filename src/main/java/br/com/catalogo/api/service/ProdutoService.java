package br.com.catalogo.api.service;

import br.com.catalogo.api.dto.input.ProdutoInputDto;
import br.com.catalogo.api.dto.outPut.ProdutoOutputDto;
import br.com.catalogo.api.excepition.EntidadeNaoEncontradaException;
import br.com.catalogo.api.filter.ProdutoFilter;
import br.com.catalogo.api.filter.ProdutoSpecsFilter;
import br.com.catalogo.api.model.Produto;
import br.com.catalogo.api.repository.ProdutoRepository;
import br.com.catalogo.api.repository.specification.ProdutoSpecification;
import br.com.catalogo.api.repository.specification.ProdutoSpecs;
import org.springframework.stereotype.Service;
import static br.com.catalogo.api.model.ProdutoSpecifications.hasName;
import static br.com.catalogo.api.model.ProdutoSpecifications.hasProdutoId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProdutoService {

    @Autowired(required = true)
    private ProdutoRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public ProdutoOutputDto save(ProdutoInputDto produto) {
        Produto savedModel = repository.save(mapper.inputDtoToModel(produto));
        return mapper.modelToOutputDto(savedModel);
    }

    public Page<ProdutoOutputDto> findAll(ProdutoFilter filter, Pageable pageable){
        Page<Produto> page =  repository.find(pageable, filter);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }

    public Page<ProdutoOutputDto> findAllSpec(ProdutoSpecification spec, Pageable pageable){
        Page<Produto> page =  repository.findAll(spec, pageable);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }

    public Page<Produto> findByNameAndNumber(ProdutoSpecsFilter filter, Pageable pageable){
        Page<Produto> listaComProdutosEPrecos =  repository.findAll(ProdutoSpecs.comNomeSemelhante(filter.getProductName()).and(ProdutoSpecs.listaDePrecos(filter.getProductPrice())),pageable);
        return listaComProdutosEPrecos;
    }

    @SuppressWarnings("serial")
    public ProdutoOutputDto findById(Long id){
        Produto model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        return mapper.modelToOutputDto(model);
    }

    @Transactional
    public ProdutoOutputDto update(Long id, ProdutoInputDto request) {

        Produto model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        BeanUtils.copyProperties(request, model, "id");

        return mapper.modelToOutputDto(repository.save(model));
    }

    @SuppressWarnings("serial")
    @Transactional
    public void delete(Long id) {

        repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O Produto de ID: "+id+" Não foi encontrado"){});
        repository.deleteById(id);
    }

    public Page<ProdutoOutputDto> findAllV2(ProdutoFilter filter, Pageable pageable){

        Page<Produto> page = repository.findAll(hasProdutoId(filter.getProdutoId()).and(hasName(filter.getName())), pageable);
        return page.map(produto -> mapper.modelToOutputDto(produto));
    }


}
}
