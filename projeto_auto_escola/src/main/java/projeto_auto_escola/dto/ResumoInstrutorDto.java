package projeto_auto_escola.dto;

import projeto_auto_escola.models.Endereco;

public class ResumoInstrutorDto {
	private Long codigo;
	private String nome;
	
	public ResumoInstrutorDto() {
		super();

	}

	public ResumoInstrutorDto(Long codigo, String nome, String cpf, String telefone, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}