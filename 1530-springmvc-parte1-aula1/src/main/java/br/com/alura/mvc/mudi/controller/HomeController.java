package br.com.alura.mvc.mudi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class HomeController {
	
	@Autowired
	private PedidoRepository  pedidoRepository;
	
	@GetMapping("home")
	public String home(Model model) {		
	List<Pedido> pedidos = pedidoRepository.findAll();
	model.addAttribute("pedidos",pedidos); // enviando a lista para a view		
	return "home";
	}
	
	@GetMapping("aguardando")
	public String aguardando(Model model) {
		
		 List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
		 model.addAttribute("pedidos", pedidos);
		 return "home";
	}
	
	
	

}


