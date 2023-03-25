package projeto_auto_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_auto_escola.models.Permissao;

@Repository
public interface PermissaoRepository  extends JpaRepository<Permissao, Long> {
	
}
