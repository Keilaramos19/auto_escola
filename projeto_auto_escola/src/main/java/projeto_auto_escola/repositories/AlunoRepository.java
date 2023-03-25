package projeto_auto_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_auto_escola.models.Aluno;
import projeto_auto_escola.repositories.aluno.AlunoRepositoryQuery;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Long>, AlunoRepositoryQuery{

}
