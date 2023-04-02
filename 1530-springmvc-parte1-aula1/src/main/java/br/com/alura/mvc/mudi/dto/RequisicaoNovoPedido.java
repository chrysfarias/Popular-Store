package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotEmpty;


import br.com.alura.mvc.mudi.model.Pedido;

public class RequisicaoNovoPedido {
	
	@NotEmpty
	private String nomeProduto;
	@NotEmpty
	private String UrlProduto;
	@NotEmpty
	private String urlImagem;
	
	private String descricao;
	
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return UrlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		UrlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(UrlProduto);		
		return pedido;
	}

	
}
