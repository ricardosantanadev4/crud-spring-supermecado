package br.com.sistema.supermercado.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.services.FabricanteService;

@RestController
@RequestMapping(value = "/api/fabricante")
public class FabricanteController {

	private final FabricanteService fabricanteService;

	public FabricanteController(FabricanteService fabricanteService) {
		this.fabricanteService = fabricanteService;
	}

	@GetMapping
	public List<Fabricante> findByNomeContaining(@RequestParam String nome) {
		return this.fabricanteService.findByNomeContainingIgnoreCase(nome);
	}
}