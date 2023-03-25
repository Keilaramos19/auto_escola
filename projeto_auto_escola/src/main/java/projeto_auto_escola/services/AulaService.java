package projeto_auto_escola.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projeto_auto_escola.dto.ResumoAulaDto;
import projeto_auto_escola.models.Aluno;
import projeto_auto_escola.models.Aula;
import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.repositories.AlunoRepository;
import projeto_auto_escola.repositories.AulaRepository;
import projeto_auto_escola.repositories.InstrutorRepository;
import projeto_auto_escola.repositories.filters.AulaFilter;

@Service
public class AulaService {
	
	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	public Page<ResumoAulaDto> resumir(AulaFilter aulaFilter,
			Pageable pageable){
		return aulaRepository.filtrar(aulaFilter, pageable);
	}
	
	public Aula criar(Aula aula) {
		Aluno aluno = alunoRepository.findById(
				aula.getAluno().getCodigo()).orElseThrow();
		
		Instrutor instrutor = instrutorRepository.findById(
				aula.getInstrutor().getCodigo()).orElseThrow();
		return aulaRepository.save(aula);
	}
	
	public List<Aula> listar(){
		return aulaRepository.findAll();
	}
	
	public Aula buscarPorCodigo(Long codigo) {
		Aula aula = aulaRepository.findById(codigo).orElseThrow();
		return aula;
	}
	
	public void excluir(Long codigo) {
		aulaRepository.deleteById(codigo);
	}
	
	public Aula atualizar(Long codigo, Aula aula) {
		Aula aulaSalva= aulaRepository.findById(codigo).orElseThrow();
		
		Aluno alunoSalvo = alunoRepository.findById(aula.getAluno().getCodigo()).orElseThrow();
		Instrutor instrutor = instrutorRepository.findById(
				aula.getInstrutor().getCodigo()).orElseThrow();
		BeanUtils.copyProperties(aula, "codigo");
		return aulaRepository.save(aulaSalva);
	}
	

}
