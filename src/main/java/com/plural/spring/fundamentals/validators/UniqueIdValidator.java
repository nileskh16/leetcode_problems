package com.plural.spring.fundamentals.validators;

import com.plural.spring.fundamentals.annotations.UniqueId;
import com.plural.spring.fundamentals.repositories.StudentRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class UniqueIdValidator implements ConstraintValidator<UniqueId, Long> {

    @Autowired
    private StudentRepositoryImpl studentRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return studentRepository.doesIdExists(value);
    }
}
