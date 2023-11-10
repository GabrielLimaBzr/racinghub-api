package com.application.corridahub.comum.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.corridahub.comum.domain.BaseService;
import com.application.corridahub.comum.domain.model.BaseModel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseController<T extends BaseModel<T>> {

	private final BaseService<T> service;

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<T> create(@Valid @RequestBody T entity) {
		T createEntity = service.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(createEntity);
	}

	@PutMapping
	public ResponseEntity<T> update(@Valid @RequestBody T entity) {
		return ResponseEntity.ok(service.update(entity));
	}

}
