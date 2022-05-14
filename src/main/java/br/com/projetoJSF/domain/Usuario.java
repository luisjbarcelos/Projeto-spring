package br.com.projetoJSF.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String telefone;
	@Transient
	private String confirmaSenha;
	
	private Boolean professor;
	private Boolean aluno;
	


	public Usuario() {

	}

	public Usuario(Integer id, String nome, String senha, String email, String telefone, String confirmaSenha) {

		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.confirmaSenha = confirmaSenha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean getProfessor() {
		return professor;
	}

	public void setProfessor(Boolean professor) {
		this.professor = professor;
	}

	public Boolean getAluno() {
		return aluno;
	}

	public void setAluno(Boolean aluno) {
		this.aluno = aluno;
	}
}
