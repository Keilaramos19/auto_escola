package projeto_auto_escola.repositories.filters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AulaFilter {
	
	private String descricao;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInicio;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	
	
}