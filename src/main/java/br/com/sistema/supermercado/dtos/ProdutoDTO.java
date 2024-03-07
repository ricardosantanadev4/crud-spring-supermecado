package br.com.sistema.supermercado.dtos;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.models.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private String categoria;
	private Double valor;
	private Fabricante fabricante;
	private String validade;

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.categoria = produto.getCategoria();
		this.valor = produto.getValor();
		this.fabricante = produto.getFabricante();
		this.validade = produto.getValidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

}
