package org.LivrariaInterativa.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuClienteController {

	@Autowired
	public MenuClienteController() {
		super();
	}
	
	@RequestMapping("menuCliente")
	public String MenuClienteForm() {
		return "menuCliente";
	}	
}
