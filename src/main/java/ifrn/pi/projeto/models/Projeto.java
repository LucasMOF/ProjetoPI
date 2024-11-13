package ifrn.pi.projeto.models;

public class Projeto {

	private Long nome;
	private String email;
	private String cpf;
	private String telofe;
	private String senha;

	public Long getNome() {
		return nome;
	}

	public void setNome(Long nome) {
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

}
