package org.LivrariaInterativa.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.LivrariaInterativa.modelo.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositorio {

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario Autenticar(Usuario user) {
		
		Query query = manager.createQuery("SELECT usr FROM Usuario usr WHERE usr.login = ?1 AND usr.senha = ?2");
		query.setParameter(1, user.getLogin()).setParameter(2, user.getSenha());
		
		try {
			user = (Usuario) query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void Cadastrar(Usuario usuario) {
		manager.persist(usuario);
	}
}
