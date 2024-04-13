package br.com.sistema.supermercado.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.sistema.supermercado.dtos.ProdutoDTO;
import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.models.Produto;
import br.com.sistema.supermercado.repositorys.FabricanteRepository;
import br.com.sistema.supermercado.repositorys.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final FabricanteService fabricanteService;

	public ProdutoService(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository,
			FabricanteService fabricanteService) {
		this.produtoRepository = produtoRepository;
		this.fabricanteService = fabricanteService;
	}

	@GetMapping
	public List<ProdutoDTO> findAll(String param) {
		if (param == null) {
			return this.produtoRepository.findAll().stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
		}

		List<Produto> getProduto = this.produtoRepository.findAllByParm(param.toLowerCase());
		if (getProduto.isEmpty()) {
			List<Fabricante> getFabricante = this.fabricanteService.finAllByNomeContainingIgnoreCase(param);

			if (getFabricante.isEmpty()) {
				return new ArrayList<>();
			}

			List<Produto> getProdutoByFabricante = new ArrayList<>();
			getFabricante.stream().forEach(fabricante -> getProdutoByFabricante
					.addAll(this.produtoRepository.findAllByFabricante(fabricante)));

			return getProdutoByFabricante.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
		}

		return getProduto.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
	}

}
