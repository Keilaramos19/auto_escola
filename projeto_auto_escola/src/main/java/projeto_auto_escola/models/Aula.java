package projeto_auto_escola.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projeto_auto_escola.models.enums.TurnoAula;


@Entity
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	@NotNull(message = "Data inicio é obrigatório")
	private LocalDate dataInicio;

	@NotNull(message = "Valor é obrigatório")
	private BigDecimal valor;

	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Turno é obrigatório")
	private TurnoAula turno;
	
	@NotNull(message = "Instrutor é obrigatório")
	@ManyToOne
	@JoinColumn(name="codigo_instrutor")
	private Instrutor instrutor;

	@JsonIgnoreProperties({"endereco","ativo"})
	@NotNull(message = "Aluno é obrigatório")
	@ManyToOne
	@JoinColumn(name="codigo_aluno")
	private Aluno aluno;

	public Aula() {
		super();
	}

	public Aula(Long codigo, @NotBlank(message = "Descrição é obrigatório") String descricao,
			@NotNull(message = "Data inicio é obrigatório") LocalDate dataInicio,
			@NotNull(message = "Valor é obrigatório") BigDecimal valor, TurnoAula turno,
			@NotNull(message = "Instrutor é obrigatório") Instrutor instrutor,
			@NotNull(message = "Aluno é obrigatório") Aluno aluno) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.valor = valor;
		this.turno = turno;
		this.instrutor = instrutor;
		this.aluno = aluno;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TurnoAula getTurno() {
		return turno;
	}

	public void setTurno(TurnoAula turno) {
		this.turno = turno;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Aula other = (Aula) obj;
		return Objects.equals(codigo, other.codigo);
	}
	

}
