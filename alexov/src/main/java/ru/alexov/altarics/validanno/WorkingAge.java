package ru.alexov.altarics.validanno;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy=WorkingAgeConstraintValidator.class)
public @interface WorkingAge {
	int MinAge();
	int MaxAge();
	static  final String ERROR_MSG="Нетрудоспособный возраст"; 
	String message() default ERROR_MSG;
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
