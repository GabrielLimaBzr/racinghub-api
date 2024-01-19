package com.application.racinghub.common.resource;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.application.racinghub.common.domain.BaseService;

import jakarta.validation.Valid;

/**
 * Abstract class for controllers CRUD.
 *
 * @author Gabriel Lima (2023)
 *
 * @param <T> entity type
 * @param <FP> filter params
 * @param <S> specification
 */
public abstract class BaseController<T, FP, S> {

	private final BaseService<T, FP, S> baseService;
	
	/**
     * Receives the BaseService instance reponsable by resource CRUD operations
     *
     * @param baseService
     */
	protected BaseController(final BaseService<T, FP, S> baseService) {
		this.baseService = baseService;
	}

	/**
     * return the entity through id
     *
     * @return the entity found or 404 error if not found
     */
	@GetMapping("/{id}")
	public ResponseEntity<T> findById(Long id) {
		checkService();
		return ResponseEntity.ok(baseService.findById(id));
	}

	/**
     * Create the entity.
     *
     * @param entity
     * @return the created entity
     */
	@PostMapping
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		checkService();
		T createEntity = baseService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(createEntity);
	}

	/**
     * Update the entity.
     *
     * @param entity
     * @return the updated entity
     */
	@PutMapping
	public ResponseEntity<T> update(@Valid @RequestBody T entity) {
		checkService();
		return ResponseEntity.ok(baseService.update(entity));
	}

	/**
     * Delete the entity.
     *
     * @param id
     */
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(Long id) {
		checkService();
		baseService.deleteById(id);
    }
	
	/**
     * search with filter.
     *
     * @param filter
     * @return the result filtered
     */
	@GetMapping
	public Page<T> filter(@ParameterObject @ModelAttribute FP filter){
		return baseService.filter(filter);
	}
	
	private void checkService() {
        if (baseService == null) {
            throw new IllegalStateException("baseService não foi definido no construtor.");
        }
    }

}
