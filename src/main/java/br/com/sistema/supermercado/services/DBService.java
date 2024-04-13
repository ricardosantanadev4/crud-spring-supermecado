package br.com.sistema.supermercado.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.models.Produto;
import br.com.sistema.supermercado.repositorys.FabricanteRepository;
import br.com.sistema.supermercado.repositorys.ProdutoRepository;

@Service
public class DBService {

	private final FabricanteRepository fabricanteRepository;
	private final ProdutoRepository produtoRepository;

	public DBService(FabricanteRepository fabricanteRepository, ProdutoRepository produtoRepository) {
		this.fabricanteRepository = fabricanteRepository;
		this.produtoRepository = produtoRepository;
	}

	public Boolean dbService() {
		Fabricante nestle = new Fabricante("Nestlé");
		Fabricante saoBraz = new Fabricante("São braz");
		Fabricante nestin = new Fabricante("Nestin");
		Fabricante produto = new Fabricante("Produto");

		Produto produto1 = new Produto("Barra de chocolate", "Perecível", 8.49, nestle, "28/02/2024");
		Produto produto2 = new Produto("Picolé", "Perecível", 3.50, nestle, "28/02/2024");
		Produto produto3 = new Produto("Café em pó", "Perecível", 4.50, saoBraz, "28/02/2024");
		Produto produto4 = new Produto("Produto Nestin", "Perecível", 4.50, nestin, "28/02/2024");
		Produto produto5 = new Produto("Produto", "Perecível", 4.50, produto, "28/02/2024");

		nestle.getProduto().addAll(Arrays.asList(produto1, produto2));
		saoBraz.getProduto().add(produto3);
		nestin.getProduto().add(produto4);
		produto.getProduto().add(produto5);

		this.fabricanteRepository.saveAll(Arrays.asList(nestle, saoBraz, nestin, produto));
		this.produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

		return true;
	}

}
