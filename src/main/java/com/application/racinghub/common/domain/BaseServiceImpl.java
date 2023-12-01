package com.application.racinghub.common.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.racinghub.common.domain.exception.ResourceNotFoundException;
import com.application.racinghub.common.domain.model.BaseModel;

@Service
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

	protected abstract JpaRepository<T, Long> getRepository();

	private final Class<T> entityClass;

	protected BaseServiceImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
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
}
