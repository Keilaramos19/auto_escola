package projeto_auto_escola.resources;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.services.InstrutorService;

@RestController
@RequestMapping("/instrutores")
public class InstrutorResource {

	@Autowired
	private InstrutorService instrutorService;
	
	

	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Instrutor> criar(@Valid @RequestBody Instrutor instrutor) {
		Instrutor instrutorSalva = instrutorService.criar(instrutor);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(instrutorSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(instrutorSalva);
	}

	@GetMapping
	public ResponseEntity<List<Instrutor>> listar() {
		List<Instrutor> instrutores = instrutorService.listar();
		return ResponseEntity.ok().body(instrutores);
	}

	@GetMapping(value = "/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Instrutor> buscarPorCodigo(@PathVariable Long codigo) {
		Instrutor instrutor = instrutorService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(instrutor);
	}

	@DeleteMapping(value = "/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		instrutorService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	//@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Instrutor> atualizar(@PathVariable Long codigo, @Valid @RequestBody Instrutor instrutor) {
		Instrutor instrutorSalva = instrutorService.atualizar(codigo, instrutor);
		return ResponseEntity.ok().body(instrutorSalva);

	}

}
