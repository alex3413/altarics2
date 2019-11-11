package ru.alexov.altarics.validanno;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkingAgeConstraintValidator implements ConstraintValidator<WorkingAge, Calendar> {
	private int minAge;
	private int maxAge;
	@Override
	public void initialize(WorkingAge age) {
		this.minAge = age.MinAge();
		this.maxAge = age.MaxAge();
	}
	@Override
	public boolean isValid(Calendar value, ConstraintValidatorContext context) {
		if(value.YEAR>minAge||value.YEAR<maxAge)
			return false;
		return true;
	}

	
}
