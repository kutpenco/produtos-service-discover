package br.com.madrugas.produtos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.madrugas.produtos.model.Produto;
import br.com.madrugas.produtos.service.ProdutoService;

@RestController
@RequestMapping("produto/")
public class ProdutoController {

	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping("cadastro")
	public ResponseEntity<?> cadastroProduto(@RequestBody Produto produto) {
		Produto produto2 = produto;
		//produtoService.salvar(produto2);
		return ResponseEntity.ok(produtoService.salvar(produto2).getId());
	}
	
	@GetMapping("produto")
	public List<Produto> consultarProduto(){
		return produtoService.consultarProduto();
	}
	
	@GetMapping("produto/{id}")
	public List<Produto> consultarProduto(@PathVariable Integer id){
		return produtoService.consultarProdutoId(id);
	}
	
	@GetMapping("produto/nome/{nome}")
	public List<Produto> consultarProduto(@PathVariable String name){
		return produtoService.consultarProdutoNome(name);
	}
}
