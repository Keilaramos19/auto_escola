package projeto_auto_escola.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import projeto_auto_escola.models.enums.TipoCategoria;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull(message = "Codigo é obrigatório")
	private Long codigo;
	
	@NotNull(message = "Tipo é obrigatório")
	private TipoCategoria tipo;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;

	public Categoria() {
		super();
	}

	

	public Categoria(@NotNull(message = "Tipo é obrigatório") Long codigo,
			@NotNull(message = "Tipo é obrigatório") TipoCategoria tipo, Aluno aluno) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.aluno = aluno;
	}

	


	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public TipoCategoria getTipo() {
		return tipo;
	}



	public void setTipo(TipoCategoria tipo) {
		this.tipo = tipo;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
}
