package com.application.racinghub.person.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.address.domain.model.Address;
import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.person.domain.enums.Gender;
import com.application.racinghub.person.domain.enums.PersonType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class Person extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome inválido")
	private String name;

	@NotNull(message = "Data de nascimento inválida")
    private LocalDateTime birthDate;
    
	@NotNull(message = "Tipo de pessoa inválido")
	@Enumerated(EnumType.ORDINAL)
    private PersonType type;
    
	@NotNull(message = "Telefone inválido")
    private String phone;
    
    private String document;
    
    @NotNull(message = "E-mail inválido")
    @Email
    private String email;
    
    @NotNull(message = "Gênero inválido")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    
    @NotNull(message = "Endereço inválido")
    @OneToOne
    private Address address;
	
	private LocalDateTime created;
}
