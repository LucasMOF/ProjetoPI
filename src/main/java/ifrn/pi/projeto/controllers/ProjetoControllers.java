package ifrn.pi.projeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.projeto.models.Loja;
import ifrn.pi.projeto.models.Produto;
import ifrn.pi.projeto.models.Projeto;
import ifrn.pi.projeto.repositories.LojaRepository;
import ifrn.pi.projeto.repositories.ProdutoRepository;
import ifrn.pi.projeto.repositories.ProjetoRepository;
import jakarta.servlet.http.HttpSession;

@Controller

public class ProjetoControllers {

	@Autowired
	private ProjetoRepository er;
	@Autowired
	private LojaRepository ar;
	@Autowired
	private ProdutoRepository cr;

	@RequestMapping("/projeto/form")
	public String cadastro() {
		return "projeto/formCadastro";
	}

	@RequestMapping("/projeto/login")
	public String login() {
		return "projeto/login";
	}

	@RequestMapping("/projeto/loja")
	public String loja() {
		return "projeto/cadastrarLoja";

	}

	@PostMapping("/projeto")
	public String adicionar(Projeto projeto) {

		System.out.println(projeto);
		er.save(projeto);

		return "home";
	}

	@GetMapping("/projeto/lojas")
	public ModelAndView listarLoja() {
		List<Loja> loja = ar.findAll();
		ModelAndView mv = new ModelAndView("projeto/ListarLojas");
		mv.addObject("projeto", loja);
		return mv;
	}

	@PostMapping("/projeto/loja")
	public String adicionarLoja(Loja loja) {

		ar.save(loja);

		return "redirect:/projeto/lojas";
	}

	@GetMapping("/eventos/{id}")
	public ModelAndView detalharLoja(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Loja> opt = ar.findById(id);

		if (opt.isEmpty()) {
			md.setViewName("redirect:/projeto");
			return md;
		}
		md.setViewName("projeto/detalharLojas");
		Loja loja = opt.get();
		md.addObject("loja", loja);
		
		List<Produto> produtos = cr.findByLoja(loja);
		md.addObject("produtos", produtos);

		return md;
	}

	@PostMapping("/eventos/{idProduto}")
	public String salvarProduto(@PathVariable Long idProduto, Produto produto) {

		System.out.println("Id do produto: " + idProduto);
		System.out.println(produto);

		Optional<Loja> opt = ar.findById(idProduto);
		if (opt.isEmpty()) {
			return "redirect:/projeto";
		}

		Loja loja= opt.get();
		produto.setLoja(loja);

		cr.save(produto);
		
		return "redirect:/eventos/{idProduto}";

	}
}
