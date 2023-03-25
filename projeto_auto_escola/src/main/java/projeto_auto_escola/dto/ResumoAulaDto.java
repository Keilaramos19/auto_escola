package projeto_auto_escola.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import projeto_auto_escola.models.Aluno;
import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.models.enums.TurnoAula;

public class ResumoAulaDto {
	private Long codigo;
	private String descricao;
	private LocalDate dataInicio;
	private BigDecimal valor;
	private TurnoAula turno;
	private Instrutor instrutor;
	private Aluno aluno;

	public ResumoAulaDto() {
		super();
	}

	public ResumoAulaDto(Long codigo, String descricao, LocalDate dataInicio, BigDecimal valor,TurnoAula turno, Instrutor instrutor, Aluno aluno) {
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

	
}
