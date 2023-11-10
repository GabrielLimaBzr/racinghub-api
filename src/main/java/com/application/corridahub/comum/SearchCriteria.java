package com.application.corridahub.comum;

import java.io.Serializable;

import com.application.corridahub.comum.BaseSpecification.SearchOperantion;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchCriteria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String key;
	private SearchOperantion operation;
	private Object value;

}
