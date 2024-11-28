package ifrn.pi.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.projeto.models.Loja;
import ifrn.pi.projeto.models.Projeto;
import ifrn.pi.projeto.repositories.LojaRepository;
import ifrn.pi.projeto.repositories.ProjetoRepository;
import jakarta.servlet.http.HttpSession;

@Controller

public class ProjetoControllers {

	@Autowired
	private ProjetoRepository er;
	@Autowired
	private LojaRepository ar;

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
	    // Salva a loja no banco de dados
	    ar.save(loja);

	    // Redireciona para a página de listagem de lojas
	    return "redirect:/projeto/lojas";
	}
	
	
	

}