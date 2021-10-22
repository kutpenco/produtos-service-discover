package br.com.madrugas.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.madrugas.produtos.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	List<Pedido> findAll ();
	
	List<Pedido> findAllById(Integer id);
	
	List<Pedido> findByNomeIgnoreCaseContaining(String name);

}
