package projeto_auto_escola.repositories.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import projeto_auto_escola.dto.ResumoAlunoDto;
import projeto_auto_escola.repositories.filters.AlunoFilter;

public interface AlunoRepositoryQuery {
	public Page<ResumoAlunoDto> filtrar(
			AlunoFilter alunoFilter, Pageable pageable);
}
