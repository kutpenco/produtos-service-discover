package br.com.madrugas.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.madrugas.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findAll ();
	
	List<Produto> findAllById(Integer id);
	
	List<Produto> findByNomeIgnoreCaseContaining(String name);
}
