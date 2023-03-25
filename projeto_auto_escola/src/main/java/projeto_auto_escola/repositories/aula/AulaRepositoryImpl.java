package projeto_auto_escola.repositories.aula;

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
import projeto_auto_escola.dto.ResumoAulaDto;
import projeto_auto_escola.models.Aula;
import projeto_auto_escola.repositories.filters.AulaFilter;

public class AulaRepositoryImpl implements AulaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoAulaDto> filtrar(AulaFilter aulaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoAulaDto> criteria = builder.createQuery(ResumoAulaDto.class);
		Root<Aula> root = criteria.from(Aula.class);

		criteria.select(builder.construct(ResumoAulaDto.class, root.get("codigo"), root.get("descricao"),
				root.get("dataInicio"), root.get("valor"),root.get("turno"),root.get("instrutor"),root.get("aluno")));
		
		Predicate[] predicates = criarRestricoes(aulaFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<ResumoAulaDto> query = manager.createQuery(criteria);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable,
				total(aulaFilter));
	}

	private Predicate[] criarRestricoes(AulaFilter aulaFilter, CriteriaBuilder builder,
			Root<Aula> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(aulaFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + aulaFilter.getDescricao().toLowerCase() + "%"));
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
	
	private Long total(AulaFilter aulaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Aula> root = criteria.from(Aula.class);
		
		Predicate[] predicates = criarRestricoes(aulaFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}