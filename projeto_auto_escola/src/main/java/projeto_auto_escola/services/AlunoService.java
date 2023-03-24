package projeto_auto_escola.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projeto_auto_escola.dto.ResumoAlunoDto;
import projeto_auto_escola.models.Aluno;
import projeto_auto_escola.repositories.AlunoRepository;
import projeto_auto_escola.repositories.filters.AlunoFilter;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Page<ResumoAlunoDto> resumir(AlunoFilter alunoFilter,
			Pageable pageable){
		return alunoRepository.filtrar(alunoFilter, pageable);
	}
	
	public Aluno criar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	public Aluno buscarPorCodigo(Long codigo) {
		Aluno aluno = alunoRepository.findById(codigo).orElseThrow();
		return aluno;
	}
	
	public void excluir(Long codigo) {
		alunoRepository.deleteById(codigo);
	}
	
	public Aluno atualizarPropriedadeAtivo(Long codigo,
			Boolean ativo) {
		Aluno alunoSalva = alunoRepository.findById(codigo).
				orElseThrow();
		return alunoRepository.save(alunoSalva);
	}
	
	public Aluno atualizar(Long codigo, Aluno aluno) {
		Aluno alunoSalva = alunoRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(aluno, alunoSalva, "codigo");
		return alunoRepository.save(alunoSalva);
	}
	
}
