package org.LivrariaInterativa.controle;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.LivrariaInterativa.modelo.Sessao;
import org.LivrariaInterativa.repositorio.SessaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroSessaoController {
	SessaoRepositorio rep;
	
	@Autowired
	public CadastroSessaoController(SessaoRepositorio rep) {
		this.rep = rep;
	}
	
	@RequestMapping("cadastrarSessao")
	public String formLivro() {
		return "cadastroSessao";
	}
	
	@Transactional
	@RequestMapping(value="novaSessao", method = RequestMethod.POST)
	public String novaSessao(Sessao sessao) {
		rep.Cadastrar(sessao);
		return "redirect:listarSessao";
	}
	
	@RequestMapping("listarSessao")
	public String listarSessao(Model model) {
		List<Sessao> sessoes = rep.getSessoes();
		model.addAttribute("sessoes",sessoes);
		return "listarSessoes";
	}
	
	@Transactional
	@RequestMapping("removerSessao")
	public String removerSessao(int codigo) {
		System.out.println(codigo);
		Sessao se = rep.buscar(codigo);
		rep.remover(se);
		return "redirect:listarSessao";
	}
}
