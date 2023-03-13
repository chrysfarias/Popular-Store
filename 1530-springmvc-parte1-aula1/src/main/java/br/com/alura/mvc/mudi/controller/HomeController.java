package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();	
		pedido.setNomeProduto("Fender 14452258");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61M72e1mKZL._AC_SX569_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Fender-144522581-Player-Stratocaster-HSS/dp/B07T675ZH1/ref=pd_ci_mcx_mh_mcx_views_0?pd_rd_w=LGRWH&content-id=amzn1.sym.5750b988-c722-40d9-8c9a-41af4853947c&pf_rd_p=5750b988-c722-40d9-8c9a-41af4853947c&pf_rd_r=S54F733VFQ7V5G3G60EV&pd_rd_wg=fXWKK&pd_rd_r=b442fb99-fd01-465a-af55-b83cf8faa460&pd_rd_i=B07T675ZH1");
		pedido.setDescricao("Guitarra Legal");
		
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos",pedidos); // enviando a lista para a view		
		return "home";
	}

}
