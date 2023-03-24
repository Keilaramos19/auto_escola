package projeto_auto_escola.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto_auto_escola.models.Categoria;
import projeto_auto_escola.repositories.CategoriaRepository;


@RestController
@RequestMapping("/categoriaes")
@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria criar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	/*public Page<Categoria> pesquisar(CategoriaFilter categoriaFilter, Pageable pageable) {
		return categoriaRepository.filtrar(categoriaFilter, pageable);
	}*/
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarPorCodigo(Long codigo) {
		Categoria categoria = categoriaRepository.findById(codigo).orElseThrow();
		return categoria;
	}
	
	public void excluir(Long codigo) {
		categoriaRepository.deleteById(codigo);
	}

	/*public Categoria atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Categoria categoriaSalva = categoriaRepository.findById(codigo).orElseThrow();
		categoriaSalva.setAtivo(ativo);
		return categoriaRepository.save(categoriaSalva);
	}*/

	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return categoriaRepository.save(categoriaSalva);
	}
	
}