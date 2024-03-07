package br.com.sistema.supermercado.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.supermercado.dtos.ProdutoDTO;
import br.com.sistema.supermercado.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public List<ProdutoDTO> findAll(@RequestParam(required = false) String param) {
		return produtoService.findAll(param);
	}
}