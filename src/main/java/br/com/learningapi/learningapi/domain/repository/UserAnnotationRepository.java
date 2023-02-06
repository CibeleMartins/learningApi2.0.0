package br.com.learningapi.learningapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.learningapi.learningapi.domain.model.UserAnnotation;

public interface UserAnnotationRepository extends JpaRepository<UserAnnotation, Long> {
    
}
