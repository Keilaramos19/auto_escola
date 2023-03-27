package projeto_auto_escola.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import projeto_auto_escola.dto.ResumoAulaDto;
import projeto_auto_escola.models.Aula;
import projeto_auto_escola.repositories.filters.AulaFilter;
import projeto_auto_escola.services.AulaService;


@RestController
@RequestMapping("/aulas")
public class AulaResource {

	@Autowired
	private AulaService aulaService;
	
	

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_AULA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Aula> criar(@Valid @RequestBody Aula aula) {
		Aula aulaSalva = aulaService.criar(aula);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(aulaSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(aulaSalva);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_AULA') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Page<ResumoAulaDto>> resumir(AulaFilter aulaFilter,
			Pageable pageable) {
		Page<ResumoAulaDto> resumos = aulaService.resumir(aulaFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}

	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_AULA') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Aula> buscarPorCodigo(@PathVariable Long codigo) {
		Aula aula = aulaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(aula);
	}

	@DeleteMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_AULA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		aulaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_AULA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Aula> atualizar(@PathVariable Long codigo, @Valid @RequestBody Aula aula) {
		Aula aulaSalva = aulaService.atualizar(codigo, aula);
		return ResponseEntity.ok().body(aulaSalva);

	}

}
