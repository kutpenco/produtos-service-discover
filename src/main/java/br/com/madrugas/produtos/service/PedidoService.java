package br.com.madrugas.produtos.service;

import java.util.List;

import br.com.madrugas.produtos.model.Pedido;
import br.com.madrugas.produtos.repository.PedidoRepository;

public class PedidoService {

	private PedidoRepository pedidoRepository;
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public List<Pedido> consultarPedido(){
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> consultarPedidoId(Integer id){
		return pedidoRepository.findAllById(id);
	}

	public List<Pedido> consultarPedidoNome(String name){
		return pedidoRepository.findByNomeIgnoreCaseContaining(name);
	}
	
	public Pedido obter(Integer id) {
		return pedidoRepository.getById(id);
	}

	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

}
