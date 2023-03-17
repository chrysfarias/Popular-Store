package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
@RequestMapping("pedido")
public class PedidoformularioController {
	
	
	
	
	@GetMapping("formulario")
	public String formulario(Model model) {
		
		return "pedido/formulario";
		
	}
		
	

}

	
	
