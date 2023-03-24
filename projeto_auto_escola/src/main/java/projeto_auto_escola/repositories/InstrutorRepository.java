package projeto_auto_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.repositories.instrutor.InstrutorRepositoryQuery;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long>, InstrutorRepositoryQuery{

}
