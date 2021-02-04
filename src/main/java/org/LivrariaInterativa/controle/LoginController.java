package org.LivrariaInterativa.controle;

import javax.servlet.http.HttpSession;

import org.LivrariaInterativa.modelo.Usuario;
import org.LivrariaInterativa.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private UsuarioRepositorio repositorio;
	
	@Autowired //Injeção de dependencia
	public LoginController(UsuarioRepositorio rep) {
		super();
		this.repositorio = rep;
	}
	
	@RequestMapping("login")
	public String LoginForm() {
		return "login";
	}
	
	@RequestMapping(value = "autenticar", method = RequestMethod.POST)
	public String autenticar(Usuario usuario, HttpSession sessao) {
		usuario = repositorio.Autenticar(usuario);
		if(usuario != null) {
			System.out.println(usuario.getCodigo());
			sessao.setAttribute("usuario", usuario);
			if(usuario.getLogin().equals("admin")) {
				return "redirect:menuAdmin";
			} else {
				return "redirect:menuCliente";
			}
		}
		return "redirect:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "redirect:login";
	}
}
