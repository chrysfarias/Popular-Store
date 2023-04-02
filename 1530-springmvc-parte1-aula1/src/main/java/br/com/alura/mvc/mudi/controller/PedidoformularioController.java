package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoformularioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	
	@GetMapping("formulario")
	public String formulario() {
		
		return "pedido/formulario";
		
	}
	
	@PostMapping ("novo")
	
		public String novo(RequisicaoNovoPedido requisicao) {
		
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return  "hello";
	}
		
	

}

	
	

