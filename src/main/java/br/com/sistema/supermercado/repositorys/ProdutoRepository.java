package br.com.sistema.supermercado.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sistema.supermercado.models.Fabricante;
import br.com.sistema.supermercado.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT obj FROM Produto obj WHERE LOWER(obj.nome) LIKE %?1% OR LOWER(obj.categoria) LIKE %?1%")
	public List<Produto> findAllByParm(String param);

	@Query("SELECT obj FROM Produto obj WHERE obj.fabricante = ?1%")
	public List<Produto> findAllByFabricante(Fabricante fabricante);

}