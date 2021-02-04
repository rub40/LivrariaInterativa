package org.LivrariaInterativa.repositorio;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.LivrariaInterativa.modelo.Compra;
import org.LivrariaInterativa.modelo.Item;
import org.LivrariaInterativa.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRepositorio {
	@PersistenceContext
	private EntityManager manager;
	@Autowired
	LivroRepositorio livrorep;
	public Compra finalizar(Usuario usuario, List<Item> itens) {
		Compra compra = new Compra();
		double valorTotal = 0;
		for(Item item:itens) {
			valorTotal += item.getLivro().getPreco();
			manager.persist(item);
			livrorep.attEstoque(item.getLivro().getCodigo(), 1, "subtrair");
		}
		compra.setValorTotal(valorTotal);
		compra.setQtdLivros(itens.size());
		compra.setData(new Date());
		compra.setItens(itens);
		compra.setUsuario(usuario);
		manager.persist(compra);
		return compra;
	}
	
	
	public List<Compra> Listar(Usuario usuario){
		TypedQuery<Compra> query = manager.createQuery("select c from Compra c where c.usuario.codigo = ?1", Compra.class);
		query.setParameter(1, usuario.getCodigo());
		return query.getResultList();
	}
	
	public Compra listar(int codigo) {
		System.out.println(codigo);
		TypedQuery<Compra> query = manager.createQuery("select c from Compra c join fetch c.itens ci where c.codigo = ?1", Compra.class);
		query.setParameter(1, codigo);
		return query.getSingleResult();
	}
}
