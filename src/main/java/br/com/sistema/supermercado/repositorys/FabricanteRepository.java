package br.com.sistema.supermercado.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sistema.supermercado.models.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	@Query("SELECT obj FROM Fabricante obj WHERE LOWER(obj.nome) LIKE %?1%")
	List<Fabricante> finAllByNomeContainingIgnoreCase(String param);
}
