package ifrn.pi.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.projeto.models.Projeto;
import ifrn.pi.projeto.repositories.ProjetoRepository;

@Controller

public class ProjetoControllers {

	@Autowired
	private ProjetoRepository er;

	@RequestMapping("/projeto/form")
	public String cadastro() {
		return "projeto/formCadastro";
	}

	@RequestMapping("/projeto/login")
	public String login() {
		return "projeto/login";
	}

	@PostMapping("/projeto")
	public String adicionar(Projeto projeto) {

		System.out.println(projeto);
		er.save(projeto);

		return "home";
	}

}
