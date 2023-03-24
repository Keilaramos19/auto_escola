package projeto_auto_escola.repositories.instrutor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import projeto_auto_escola.dto.ResumoInstrutorDto;
import projeto_auto_escola.repositories.filters.InstrutorFilter;

public interface InstrutorRepositoryQuery {
	public Page<ResumoInstrutorDto> filtrar(
			InstrutorFilter instrutorFilter, Pageable pageable);
}
