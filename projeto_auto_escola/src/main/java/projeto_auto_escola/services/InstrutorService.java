package projeto_auto_escola.services;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	public Instrutor criar(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public List<Instrutor> listar(){
		return instrutorRepository.findAll();
	}
	
	public Instrutor buscarPorCodigo(Long codigo) {
		Instrutor instrutor = instrutorRepository.findById(codigo).orElseThrow();
		return instrutor;
	}
	
	public void excluir(Long codigo) {
		instrutorRepository.deleteById(codigo);
	}
	
	public Instrutor atualizar(Long codigo, Instrutor instrutor) {
		Instrutor instrutorSalva = instrutorRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(instrutor, instrutorSalva, "codigo");
		return instrutorRepository.save(instrutorSalva);
	}
	

}