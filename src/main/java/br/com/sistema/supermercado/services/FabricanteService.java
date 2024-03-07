package br.com.sistema.supermercado.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.repositorys.FabricanteRepository;

@Service
public class FabricanteService {

	private final FabricanteRepository fabricanteRepository;

	public FabricanteService(FabricanteRepository fabricanteRepository) {
		this.fabricanteRepository = fabricanteRepository;
	}

	public Fabricante findById(Long id) {
		return this.fabricanteRepository.findById(id).orElseThrow();
	}

	public List<Fabricante> findByNomeContainingIgnoreCase(String nome) {
		return this.fabricanteRepository.findByNomeContainingIgnoreCase(nome);
	}
}