package projeto_auto_escola.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
//@Table(name = "aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 5, max = 30, message = "Nome deve ter" + " tamnho entre 5 e 30")
	private String nome;
	@NotNull(message = "CPF é obrigatório")
	private String cpf;

	@NotNull(message = "Telefone é obrigatório")
	private String telefone;

	@Valid
	@Embedded
	private Endereco endereco;

	public Aluno() {
		super();
	}

	public Aluno(Long codigo,
			@NotBlank(message = "Nome é obrigatório") @Size(min = 5, max = 30, message = "Nome deve ter tamnho entre 5 e 30") String nome,
			@NotNull(message = "CPF é obrigatório") String cpf,
			@NotNull(message = "Telefone é obrigatório") String telefone, @Valid Endereco endereco) {
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
