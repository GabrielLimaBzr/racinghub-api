package com.application.racinghub.person.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.address.domain.model.Address;
import com.application.racinghub.common.domain.model.BaseModel;
import com.application.racinghub.person.domain.enums.Gender;
import com.application.racinghub.person.domain.enums.PersonType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
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

    @NotNull(message = "Documento não pode ser nulo")
    private String document;
    
    @NotNull(message = "Gênero inválido")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    
    @NotNull(message = "Endereço inválido")
    @OneToOne
    private Address address;

    @CreatedDate
    @JsonIgnore
	private LocalDateTime created;
}
