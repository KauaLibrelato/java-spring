package com.satc.satcloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.satc.satcloja.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
