package org.LivrariaInterativa.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.LivrariaInterativa.modelo.Livro;
import org.springframework.stereotype.Repository;


@Repository
public class LivroRepositorio {
	@PersistenceContext
	private EntityManager manager;
	
	public void Cadastrar(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> Listar(){
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l", Livro.class);
		return query.getResultList();
	}
	
	public Livro busca(int id) {
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l where l.codigo = ?1", Livro.class)
				.setParameter(1, id);
		return query.getSingleResult();
	}
	
	public boolean verificaEstoque(int codigo) {
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l where l.codigo = ?1", Livro.class)
				.setParameter(1, codigo);
		Livro livro = query.getSingleResult();
		
		if(livro.getQuantidade() > 0) {
			return true;
		}
		
		return false;
	}
	
	
	public void attEstoque(int codigo, int qtd, String funcao) {
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l where l.codigo = ?1", Livro.class)
				.setParameter(1, codigo);
		Livro livro = query.getSingleResult();
		if(funcao.equals("soma")) {
			livro.setQuantidade(livro.getQuantidade()+qtd);
		}else {
			livro.setQuantidade(livro.getQuantidade()-qtd);
		}
	}

	public void RemoverLivro(Livro livro) {
		manager.remove(livro);
	}

	public void AlterarLivro(Livro livro) {
		manager.merge(livro);
	}
	
}
