package br.com.projetoJSF.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoJSF.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Integer> {

		List<Usuario> findByNome(String nome);
	
}
