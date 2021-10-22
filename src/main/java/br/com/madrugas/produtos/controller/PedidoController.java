package br.com.madrugas.produtos.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.madrugas.produtos.model.ItemPedido;
import br.com.madrugas.produtos.model.Pedido;
import br.com.madrugas.produtos.service.PedidoService;
import br.com.madrugas.produtos.service.ProdutoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	private PedidoService pedidoService;
	private ProdutoService produtoService;
	private ItemPedido itemPedido;
	
	public PedidoController (PedidoService pedidoService, ProdutoService produtoService) {
		this.pedidoService = pedidoService;
		this.produtoService = produtoService;
	}
	
	@PostMapping
	public ResponseEntity<Pedido> salvar (@RequestBody Pedido pedido, UriComponentsBuilder uriBuilder ){
		//Usuario cliente = clienteRepository.getOne(pedidoDto.getClienteId());
		
		String cliente = "GENERICO";
		Pedido pedido1 = new Pedido();
		List<ItemPedido> itens = itemPedido.itemPedidoInput().stream()
				.map(i -> new ItemPedido(produtoService.buscarPorId(i.getProdutoId()), i.getQuantidade()))
				.collect(Collectors.toList());

		itens.forEach(item -> pedido.adicionaItem(item));

		Pedido pedidoSalvo = pedidoService.salvar(pedido1);
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(pedidoSalvo);
	}
}
