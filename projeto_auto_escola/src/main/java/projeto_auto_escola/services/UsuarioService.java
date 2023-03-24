package projeto_auto_escola.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import projeto_auto_escola.models.Usuario;
import projeto_auto_escola.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	public Usuario criar(Usuario usuario) {
		usuario.setSenha("{bcrypt}"+encoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorCodigo(Long codigo) {
		Usuario usuario = usuarioRepository.findById(codigo).orElseThrow();
		return usuario;
	}
	
	public void excluir(Long codigo) {
		usuarioRepository.deleteById(codigo);
	}
	
	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalva = usuarioRepository.
				findById(codigo).orElseThrow();
		if(usuario.getSenha()!=null) {
		usuario.setSenha("{bcrypt}"+encoder.encode(usuario.getSenha()));
		BeanUtils.copyProperties(usuario, usuarioSalva, "codigo");
		return usuarioRepository.save(usuarioSalva);
		
	}
		BeanUtils.copyProperties(usuario, usuarioSalva, new String[] {"senha","codigo"});
		
		return usuarioRepository.save(usuarioSalva);

	}
}


