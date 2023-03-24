package projeto_auto_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_auto_escola.models.Aula;
import projeto_auto_escola.repositories.aula.AulaRepositoryQuery;

@Repository
public interface AulaRepository extends 
	JpaRepository<Aula, Long>, AulaRepositoryQuery {

}
