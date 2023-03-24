package projeto_auto_escola.repositories.aluno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import projeto_auto_escola.dto.ResumoAlunoDto;
import projeto_auto_escola.models.Aluno;
import projeto_auto_escola.repositories.filters.AlunoFilter;

public class AlunoRepositoryImpl implements AlunoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoAlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoAlunoDto> criteria = builder.createQuery(ResumoAlunoDto.class);
		Root<Aluno> root = criteria.from(Aluno.class);

		criteria.select(builder.construct(ResumoAlunoDto.class, root.get("codigo"), root.get("nome"),
				root.get("cpf"), root.get("telefone"), root.get("endereco")));
		
		Predicate[] predicates = criarRestricoes(alunoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<ResumoAlunoDto> query = manager.createQuery(criteria);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable,
				total(alunoFilter));
	}

	private Predicate[] criarRestricoes(AlunoFilter alunoFilter, CriteriaBuilder builder,
			Root<Aluno> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(alunoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + alunoFilter.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(AlunoFilter alunoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Aluno> root = criteria.from(Aluno.class);
		
		Predicate[] predicates = criarRestricoes(alunoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}