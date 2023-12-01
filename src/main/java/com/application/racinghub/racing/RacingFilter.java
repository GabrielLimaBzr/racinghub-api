package com.application.racinghub.racing;

import java.time.LocalDateTime;

import com.application.racinghub.common.domain.BaseFilter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RacingFilter extends BaseFilter {
	
	private String racing;
	private LocalDateTime dateStart;
	private LocalDateTime dateEnd;

}
