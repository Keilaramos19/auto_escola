package projeto_auto_escola.repositories.aula;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import projeto_auto_escola.dto.ResumoAulaDto;
import projeto_auto_escola.repositories.filters.AulaFilter;

public interface AulaRepositoryQuery {
	public Page<ResumoAulaDto> filtrar(
			AulaFilter aulaFilter, Pageable pageable);
}
