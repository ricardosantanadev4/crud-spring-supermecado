package br.com.sistema.supermercado.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.sistema.supermercado.services.DBService;

@Configuration
@Profile(value = "test")
public class ProdutoProfile {

	private final DBService dbService;

	public ProdutoProfile(DBService dbService) {
		this.dbService = dbService;
	}

	@Bean
	public Boolean initDB() {
		return this.dbService.dbService();
	}

}
