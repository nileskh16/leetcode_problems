package com.plural.spring.fundamentals.config;

import com.plural.spring.fundamentals.repositories.StudentRepositoryImpl;
import com.plural.spring.fundamentals.repositories.TeacherRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "studentRepository")
    public StudentRepositoryImpl getStudentRepository() {
        return new StudentRepositoryImpl();
    }

    @Bean(name = "teacherRepository")
    public TeacherRepositoryImpl getTeacherRepository() {
        return new TeacherRepositoryImpl();
    }
}
