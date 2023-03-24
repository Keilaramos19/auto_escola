package projeto_auto_escola.repositories.filters;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AulaFilter {
	
	private String descricao;
	
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