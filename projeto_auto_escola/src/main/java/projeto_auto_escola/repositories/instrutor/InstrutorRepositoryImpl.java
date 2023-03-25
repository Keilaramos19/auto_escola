package projeto_auto_escola.repositories.instrutor;


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
import projeto_auto_escola.dto.ResumoInstrutorDto;
import projeto_auto_escola.models.Instrutor;
import projeto_auto_escola.repositories.filters.InstrutorFilter;

public class InstrutorRepositoryImpl implements InstrutorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoInstrutorDto> filtrar(InstrutorFilter instrutorFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoInstrutorDto> criteria = builder.createQuery(ResumoInstrutorDto.class);
		Root<Instrutor> root = criteria.from(Instrutor.class);

		criteria.select(builder.construct(ResumoInstrutorDto.class, root.get("codigo"), root.get("nome")));
		
		Predicate[] predicates = criarRestricoes(instrutorFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<ResumoInstrutorDto> query = manager.createQuery(criteria);

		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable,
				total(instrutorFilter));
	}

	private Predicate[] criarRestricoes(InstrutorFilter instrutorFilter, CriteriaBuilder builder,
			Root<Instrutor> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(instrutorFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + instrutorFilter.getNome().toLowerCase() + "%"));
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
	
	private Long total(InstrutorFilter instrutorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Instrutor> root = criteria.from(Instrutor.class);
		
		Predicate[] predicates = criarRestricoes(instrutorFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}