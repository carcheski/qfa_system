package br.com.qfa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.qfa.repositories.CategoriaRespository;
import br.com.qfa.repositories.CidadeRespository;
import br.com.qfa.repositories.ClienteRespository;
import br.com.qfa.repositories.EnderecoRespository;
import br.com.qfa.repositories.EstadoRespository;
import br.com.qfa.repositories.ProdutoRespository;
import br.com.qfa.resources.domain.Categoria;
import br.com.qfa.resources.domain.Cidade;
import br.com.qfa.resources.domain.Cliente;
import br.com.qfa.resources.domain.Endereco;
import br.com.qfa.resources.domain.Estado;
import br.com.qfa.resources.domain.Produto;
import br.com.qfa.resources.domain.enums.TipoCliente;

@SpringBootApplication
public class QfaSystemApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRespository categoriaRespository;
	
	@Autowired
	ProdutoRespository produtoRespository;
	
	@Autowired
	EstadoRespository estadoRespository;
	
	@Autowired
	CidadeRespository cidadeRespository;
	
	@Autowired
	ClienteRespository clienteRespository;
	
	@Autowired
	EnderecoRespository enderecoRespository;

	public static void main(String[] args) {
		SpringApplication.run(QfaSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRespository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRespository.saveAll(Arrays.asList(est1, est2));
		
		cidadeRespository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "382220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRespository.saveAll(Arrays.asList(cli1));
		
		enderecoRespository.saveAll(Arrays.asList(e1, e2));
		
	}
	
	

}
