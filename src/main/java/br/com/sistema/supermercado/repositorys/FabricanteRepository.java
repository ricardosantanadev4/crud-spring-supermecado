package br.com.sistema.supermercado.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.supermercado.models.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	public List<Fabricante> findByNomeContainingIgnoreCase(String nome);
}
