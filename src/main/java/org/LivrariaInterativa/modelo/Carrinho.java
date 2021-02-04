package org.LivrariaInterativa.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class Carrinho {
	
	List<Livro> livros;
	
	public Carrinho() {
		livros = new ArrayList<Livro>();
	}
	
	public void Adicionar(Livro livro) {
		livros.add(livro);
	}
	
	public void RemoverProduto(int codigo) {
		livros.remove(getLivro(codigo));
	}
	
	public Livro getLivro(int codigo) {
		for(Livro livro:livros) {
			if(livro.getCodigo() == codigo) {
				return livro;
			}
		}
		return null;
	}
	
	public List<Livro> getProdutos() {
		return livros;
	}
}
