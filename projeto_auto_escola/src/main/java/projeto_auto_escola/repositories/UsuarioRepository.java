package projeto_auto_escola.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_auto_escola.models.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
	public Optional<Usuario>findByEmail(String email);

}