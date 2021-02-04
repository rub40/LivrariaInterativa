package org.LivrariaInterativa.controle;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.LivrariaInterativa.modelo.Carrinho;
import org.LivrariaInterativa.modelo.Compra;
import org.LivrariaInterativa.modelo.Item;
import org.LivrariaInterativa.modelo.Livro;
import org.LivrariaInterativa.modelo.Usuario;
import org.LivrariaInterativa.repositorio.CompraRepositorio;
import org.LivrariaInterativa.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompraController {
	private CompraRepositorio repositorio;
	@Autowired
	public CompraController(CompraRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Transactional
	@RequestMapping("finalizarCompra")
	public String finalizar(HttpSession sessao, Model model) {
		List<Item> itens = new ArrayList<Item>();
		Carrinho carrinho = (Carrinho) sessao.getAttribute("carrinho");
		for(Livro livro:carrinho.getProdutos()) {
			Item item = new Item();
			item.setLivro(livro);
			itens.add(item);
		}
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		System.out.println(usuario.getCodigo());
		Compra compra = repositorio.finalizar(usuario, itens);
		model.addAttribute("compra", compra);
		return "redirect:menuCliente";
	}
	
	@RequestMapping("historicoCompras")
	public String listarCompras(Model model, HttpSession sessao){
		Usuario user = (Usuario) sessao.getAttribute("usuario");
		model.addAttribute("compras", repositorio.Listar(user));
		
		return "listarCompras";
	}
	
	@RequestMapping("listarItensCompra")
	public String listarItensCompra(int codigo, Model model) {
		Compra compra =  repositorio.listar(codigo);
		model.addAttribute("compra", compra);
		model.addAttribute("itens", compra.getItens());
		
		return "listarItensCompra";
	}
}
