package org.LivrariaInterativa.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuAdminController {

	@Autowired
	public MenuAdminController() {
		super();
	}
	
	@RequestMapping("menuAdmin")
	public String MenuAdminForm() {
		return "menuAdmin";
	}	
}
