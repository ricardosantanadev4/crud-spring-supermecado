package br.com.sistema.supermercado.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.supermercado.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
