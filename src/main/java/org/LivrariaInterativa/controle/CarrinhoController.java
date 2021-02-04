package org.LivrariaInterativa.controle;


import org.LivrariaInterativa.modelo.Carrinho;
import org.LivrariaInterativa.repositorio.LivroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {
	private LivroRepositorio repositorio;
	private Carrinho carrinho;

	@Autowired
	public CarrinhoController(LivroRepositorio repositorio, Carrinho carrinho) {
		this.repositorio = repositorio;
		this.carrinho = carrinho;
	}
	
	@RequestMapping("listarLivrosCliente")
	public String getProdutosLoja(Model model) {
		model.addAttribute("livros", repositorio.Listar());
		
		return "listarLivrosCliente";
	}
	
	@RequestMapping("listarLivrosCarrinho")
	public String getProdutosCarrinho(Model model) {
		model.addAttribute("carrinho", carrinho.getProdutos());
		
		return "carrinhoCompra";
	}
	
	@RequestMapping("adicionarLivroCarrinho")
	public String adicionarProduto(int codigo) {
		if(repositorio.verificaEstoque(codigo))
			carrinho.Adicionar(repositorio.busca(codigo));
		
		return "redirect:listarLivrosCarrinho";
	}
	
	@RequestMapping("removerLivroCarrinho")
	public String removerProduto(int codigo) {
		carrinho.RemoverProduto(codigo);
		
		return "redirect:listarLivrosCarrinho";
	}
}
