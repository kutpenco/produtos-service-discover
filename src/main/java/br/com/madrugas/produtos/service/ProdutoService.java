package br.com.madrugas.produtos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.madrugas.produtos.model.Produto;
import br.com.madrugas.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> consultarProduto(){
		return produtoRepository.findAll();
	}
	
	public List<Produto> consultarProdutoId(Integer id){
		return produtoRepository.findAllById(id);
	}

	public List<Produto> consultarProdutoNome(String name){
		return produtoRepository.findByNomeIgnoreCaseContaining(name);
	}
	
	public Produto salvar (Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto obter(Integer id) {
		return produtoRepository.getById(id);
	}
	
}
