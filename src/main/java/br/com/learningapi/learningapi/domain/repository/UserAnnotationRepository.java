package br.com.learningapi.learningapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learningapi.learningapi.domain.model.UserAnnotation;
import br.com.learningapi.learningapi.domain.model.UserLearner;

@Repository
public interface UserAnnotationRepository extends JpaRepository<UserAnnotation, Long> {
    
    List<UserAnnotation>findByUser(UserLearner user);
    
}
