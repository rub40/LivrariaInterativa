package org.LivrariaInterativa.controle;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.LivrariaInterativa.modelo.Livro;
import org.LivrariaInterativa.repositorio.LivroRepositorio;
import org.LivrariaInterativa.repositorio.SessaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroLivroController {
	@Autowired
	SessaoRepositorio rep;
	
	LivroRepositorio lrep;
	
	@Autowired
	public CadastroLivroController(LivroRepositorio lrep) {
		this.lrep = lrep;
	}
	
	@RequestMapping("cadastrarLivro")
	public String formLivro(Model model) {
		model.addAttribute("sessoes", rep.getSessoes());
		return "cadastroLivro";
	}
	
	@RequestMapping("listarLivros")
	public String listarLivros(Model model) {
		model.addAttribute("livros", lrep.Listar());
		
		return "listarLivros";
	}
	
	@RequestMapping("editarLivro")
	public String editarLivro(int codigo, Model model) {
		Livro livro = lrep.busca(codigo);
		model.addAttribute("sessoes", rep.getSessoes());
		model.addAttribute("livro", livro);
		return "editarLivros";
		
	}
	
	@Transactional
	@RequestMapping("removerLivro")
	public String removerLivro(int codigo) {
		Livro livro = lrep.busca(codigo);
		lrep.RemoverLivro(livro);
		return "listarLivros";
	}
	
	@Transactional
	@RequestMapping("alterarLivro")
	public String alterarLivro(Livro livro) {
		lrep.AlterarLivro(livro);
		return "redirect:listarLivros";
	}
	
	@Transactional
	@RequestMapping(value="inserirLivro", method = RequestMethod.POST)
	public String inserirLivro(Livro livro) {
		lrep.Cadastrar(livro);
		return "redirect:listarLivros";
	}

}
