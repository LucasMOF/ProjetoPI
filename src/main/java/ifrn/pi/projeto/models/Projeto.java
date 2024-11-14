package ifrn.pi.projeto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Projeto {

	private String nome;
	private String email;
	private String cpf;
	private String telofe;
	private String senha;
	private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelofe() {
		return telofe;
	}

	public void setTelofe(String telofe) {
		this.telofe = telofe;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", telofe=" + telofe + ", senha=" + senha
				+ ", id=" + id + "]";
	}

	
}
