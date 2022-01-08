package com.altercode.idao;

import com.altercode.model.Categoria;
import com.altercode.model.Produto;
import com.altercode.model.UnidadeMedida;

import java.util.List;
import java.util.Optional;

public interface ProdutoIDAO {

    Produto save(Produto produto);
    Produto update(Produto produto);
    void delete(Long id);
    List<Produto> findAllProd();
    Optional <Produto> findById(Long id);
    List <Produto> findByCat(Categoria categoria);
    List <Produto> findByMed(UnidadeMedida medida);
}
