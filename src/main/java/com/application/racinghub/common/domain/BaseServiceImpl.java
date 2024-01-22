package com.application.racinghub.common.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.racinghub.common.BaseSpecification;
import com.application.racinghub.common.domain.exception.ResourceNotFoundException;
import com.application.racinghub.common.domain.model.BaseModel;

@Service
public abstract class BaseServiceImpl<T extends BaseModel, FP extends BaseFilter, S extends BaseSpecification<T>>
		implements BaseService<T, FP, S> {

	private final Class<T> entityClass;

	private final JpaRepository<T, Long> repository;

	protected BaseServiceImpl(Class<T> entityClass, JpaRepository<T, Long> repository) {
		this.entityClass = entityClass;
		this.repository = repository;
	}

	private JpaRepository<T, Long> getRepository() {
		return repository;
	}

	@SuppressWarnings("unchecked")
	private JpaSpecificationExecutor<T> getSpecificationExecutor() {
		if (repository instanceof JpaSpecificationExecutor) {
			return (JpaSpecificationExecutor<T>) repository;
		} else {
			throw new IllegalStateException("O repositório não implementa JpaSpecificationExecutor.");
		}
	}

	@Override
	public T findById(Long id) {
		return getRepository().findById(id).orElseThrow(() -> new ResourceNotFoundException(
				String.format("Recurso não encontrado para a entidade %s id: %s", entityClass.getSimpleName(), id)));
	}

	@Override
	@Transactional
	public T create(T entity) {
		return getRepository().save(entity);
	}

	@Override
	@Transactional
	public T update(T entity) {
		findById(entity.getId());
		return getRepository().save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		findById(id);
		getRepository().deleteById(id);
	}

	@Override
    public Page<T> filter(FP filter) {
        S specification = createSpecification(filter);
        return getSpecificationExecutor().findAll(specification, PageRequest.of(filter.getPage(), filter.getSize()));
    }
}
