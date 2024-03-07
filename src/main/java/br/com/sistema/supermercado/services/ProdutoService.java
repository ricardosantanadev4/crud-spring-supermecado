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
	private final FabricanteRepository fabricanteRepository;

	public ProdutoService(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository) {
		this.produtoRepository = produtoRepository;
		this.fabricanteRepository = fabricanteRepository;
	}

	@GetMapping
	public List<ProdutoDTO> findAll(String param) {
		if (param == null) {
			return this.produtoRepository.findAll().stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
		}

		List<Produto> getProdutoByFabricante = new ArrayList<>();
		List<Fabricante> getFabricante = this.fabricanteRepository.findByNomeContainingIgnoreCase(param);
		getFabricante.stream().forEach(
				fabricante -> getProdutoByFabricante.addAll(this.produtoRepository.findByFabricante(fabricante)));
		List<Produto> getProduto = this.produtoRepository.findAllByParm(param);

		if (getFabricante.isEmpty() && getProdutoByFabricante.isEmpty()) {
			return getProduto.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
		}

		return getProdutoByFabricante.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
	}

}
