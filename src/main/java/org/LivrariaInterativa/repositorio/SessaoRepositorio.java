package org.LivrariaInterativa.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.LivrariaInterativa.modelo.Livro;
import org.LivrariaInterativa.modelo.Sessao;
import org.springframework.stereotype.Repository;

@Repository
public class SessaoRepositorio {
	@PersistenceContext
	private EntityManager manager;
	
	public void Cadastrar(Sessao sessao) {
		manager.persist(sessao);
	}
	
	public List<Sessao> getSessoes(){
		TypedQuery<Sessao> query = manager.createQuery("select s from Sessao s", Sessao.class);
		try {
			return query.getResultList();
		}catch(NoResultException e) {
			return new ArrayList<Sessao>();
		}
	}
	
	public void remover(Sessao sessao) {
		manager.remove(sessao);
	}
	
	public Sessao buscar(int codigo) {
		System.out.println(codigo);
		TypedQuery<Sessao> query = manager.createQuery("select s from Sessao s where s.codigo = ?1", Sessao.class)
				.setParameter(1, codigo);
		
		return query.getSingleResult();
	}
}
