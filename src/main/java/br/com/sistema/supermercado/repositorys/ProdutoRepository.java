package br.com.sistema.supermercado.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByFabricante(Fabricante fabricante);

	@Query("SELECT obj FROM Produto obj WHERE LOWER(obj.nome) LIKE %?1% or LOWER(obj.categoria) LIKE %?1%")
	List<Produto> findAllByParm(String param);

}