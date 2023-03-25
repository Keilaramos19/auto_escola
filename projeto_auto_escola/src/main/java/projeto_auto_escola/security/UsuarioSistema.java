package projeto_auto_escola.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import projeto_auto_escola.models.Usuario;

@JsonInclude(value = Include.NON_EMPTY)
public class UsuarioSistema extends User {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("usuario")
	private Usuario usuario;

	public UsuarioSistema(Usuario usuario,
			Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
