package ifrn.pi.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjetoControllers {

	@RequestMapping("/projeto/cadastro")
	public String cadastro() {
		return "formCadastro";
	}
	
}
