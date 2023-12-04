package com.application.racinghub.address.domain.model;

import java.time.LocalDateTime;

import com.application.racinghub.common.domain.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) 
public class Address extends BaseModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String street;
	
	@NotNull(message = "Cidade inválida")
    private String city;
    
    private String state;
    
    @NotNull(message = "CEP inváido")
    private String zip;
    
    @NotNull(message = "País inválido")
    private String country;
    
    private Long number;
    
    private String neighborhood;
    
    @Size(max = 500, message = "Valor máximo oberservação 500 caracteres")
    private String note;
	
	private LocalDateTime created;
}
