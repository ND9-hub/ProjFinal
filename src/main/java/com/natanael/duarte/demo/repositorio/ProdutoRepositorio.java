package com.natanael.duarte.demo.repositorio;

import com.natanael.duarte.demo.modelo.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoEntity, Long> { // retorno long

}
