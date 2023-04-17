package br.com.alura.mvc.mudi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String formulario(RequisicaoNovoPedido requisicao)  {  
		
		return "pedido/formulario";
		
	}
	
	@PostMapping ("novo")
	
		public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {		
	List<Pedido> pedidos = pedidoRepository.findAll();
	model.addAttribute("pedidos",pedidos); 
	return "home";
	}
		
	

}

	
	

