package com.application.corridahub.comum.domain;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.application.corridahub.comum.domain.exception.ResourceNotFoundException;
import com.application.corridahub.comum.domain.model.BaseModel;
import com.application.corridahub.comum.infra.repository.BaseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseServiceImpl<T extends BaseModel<T>> implements BaseService<T> {

	private final BaseRepository<T> repository;

	private final Class<T> entityClass;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				String.format("Recurso não encontrado para a entidade: %s id: %s", entityClass.getSimpleName(), id)));
	}

	@Override
	@Transactional
	public T create(T entity) {
		T dbDomain = entity.createNewInstance();
		return repository.save(dbDomain);
	}

	@Override
	@Transactional
	public T update(T entity) {
		T dbDomain = findById(entity.getId());
		dbDomain.update(entity);
		return repository.save(dbDomain);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
