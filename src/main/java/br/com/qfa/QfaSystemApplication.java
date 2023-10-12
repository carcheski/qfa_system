package br.com.qfa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.qfa.repositories.CategoriaRespository;
import br.com.qfa.resources.domain.Categoria;

@SpringBootApplication
public class QfaSystemApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRespository categoriaRespository;

	public static void main(String[] args) {
		SpringApplication.run(QfaSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		
	}
	
	

}
