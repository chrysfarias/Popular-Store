package br.com.alura.mvc.mudi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class HomeController {
	
	@Autowired
	private PedidoRepository  pedidoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {		
	List<Pedido> pedidos = pedidoRepository.findAll();
	model.addAttribute("pedidos",pedidos); // enviando a lista para a view
	return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		 List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));  // converter string para enum 
		 model.addAttribute("pedidos", pedidos);
		 model.addAttribute("status",status);
		 return "home";
	}	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:pedidos/home";
		
	}

}


