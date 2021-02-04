package org.LivrariaInterativa.controle;

import org.LivrariaInterativa.modelo.Usuario;
import org.LivrariaInterativa.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroUsuarioController {

	private UsuarioRepositorio repositorio;

	@Autowired
	public CadastroUsuarioController(UsuarioRepositorio rep) {
		super();
		this.repositorio = rep;
	}
	
	@RequestMapping("cadastroUsuario")
	public String cadastroForm() {
		return "cadastroUsuario";
	}
	
	@Transactional
	@RequestMapping(name = "cadastrarLivro", method = RequestMethod.POST)
	public String cadastrar(Usuario usuario) {
		repositorio.Cadastrar(usuario);
		return "redirect:login";
	}
}
