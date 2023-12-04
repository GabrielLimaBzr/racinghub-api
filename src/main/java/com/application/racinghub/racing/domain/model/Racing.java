package com.application.racinghub.racing.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.address.domain.model.Address;
import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.person.domain.model.Person;
import com.application.racinghub.racing.domain.enums.Category;
import com.application.racinghub.racing.domain.enums.Status;
import com.application.racinghub.racing.domain.enums.TypeRacing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class Racing extends BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Corriada Inválida")
	private String racing;
	
	@NotNull(message = "Data Inicial Inválida")
	private LocalDateTime dateStart;
	
	private LocalDateTime dateEnd;
	
	@NotNull(message = "Tipo de Corrida Inválida")
	@Enumerated(EnumType.ORDINAL)
	private TypeRacing typeRacing;
	
	@NotNull(message = "Categoria de Corrida Inválida")
	@Enumerated(EnumType.ORDINAL)
	private Category category;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "INT DEFAULT '0'")
	private Status status = Status.PLANNED;
	
	private Double distance;
	
	@ManyToOne
	@NotNull(message = "Organizador Inválido")
	private Person organizer;
	
	@OneToOne
	@NotNull(message = "Endereço Inválido")
	private Address address;

	@Size(max = 500, message = "Valor máximo oberservação 500 caracteres")
	private String notes;
	
	private LocalDateTime created;
	
}
