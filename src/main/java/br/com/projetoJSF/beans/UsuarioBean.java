package br.com.projetoJSF.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoJSF.domain.Usuario;
import br.com.projetoJSF.service.UsuarioService;
import br.com.projetoJSF.util.JSFUtil;

@Named(value = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private String nome;
	private String senha;

	private Usuario usuario;

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioBean() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
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

	public void cadastrar() {

		if (usuario.getProfessor() == true && usuario.getAluno() == true) {
			JSFUtil.adicionarMensagemDeErro("Marque somente uma caixa de Escolha", null);

		} else {

			this.usuarioService.cadastrar(this.usuario);
			JSFUtil.adicionarMensagemDeSucesso("Usuario cadastrado com sucesso", null);

		}

	}

	public void deletar() {
		usuarioService.deletar(this.usuario.getId());
	}

	public void logar() throws IOException {
		List<Usuario> listaNome = new ArrayList<Usuario>(this.usuarioService.retornaPorNome(nome));

		Usuario user = new Usuario();

		for (int cont = 0; cont < listaNome.size(); cont++) {

			user = listaNome.get(cont);
		}

		if (listaNome.size() > 0 && user.getSenha().equals(this.senha)) {

			if (user.getProfessor() == true) {

				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect(ec.getRequestContextPath() + "/pages/Professor.xhtml");
			}else if(user.getAluno() == true) {
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect(ec.getRequestContextPath() + "/pages/Aluno.xhtml");
			}

		}else {
			JSFUtil.adicionarMensagemDeErro("Usuario e/ou Senha Incorreta", null);
			
		}

	}
}
