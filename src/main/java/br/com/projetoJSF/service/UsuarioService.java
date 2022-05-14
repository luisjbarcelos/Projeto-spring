package br.com.projetoJSF.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoJSF.Repository.UsuarioRepository;
import br.com.projetoJSF.domain.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public void cadastrar(Usuario  user) {
		
		this.usuarioRepository.save(user);
		
	}
	public List<Usuario> listar(){
		return this.usuarioRepository.findAll();
	}
	
	public void deletar(Integer id) {
		
		this.usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> retornaPorNome(String nome){
		
		return	this.usuarioRepository.findByNome(nome); 
	}
}
