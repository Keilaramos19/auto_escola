package projeto_auto_escola.dto;

import projeto_auto_escola.models.Endereco;

public class ResumoAlunoDto {
	private Long codigo;
	private String nome;
	private String cpf;
	private String telefone;
	private Endereco endereco;

	
	public ResumoAlunoDto() {
		super();

	}

	

	public ResumoAlunoDto(Long codigo, String nome, String cpf, String telefone, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
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



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


}