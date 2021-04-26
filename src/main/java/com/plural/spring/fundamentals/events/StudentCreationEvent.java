package com.plural.spring.fundamentals.events;

import com.plural.spring.fundamentals.entities.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentCreationEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3077055708181589627L;
    private final Student student;

    public StudentCreationEvent(Student student) {
        super(student);
        this.student = student;
    }
}
