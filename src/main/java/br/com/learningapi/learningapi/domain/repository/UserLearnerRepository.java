package br.com.learningapi.learningapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.learningapi.learningapi.domain.model.UserLearner;

public interface UserLearnerRepository extends JpaRepository<UserLearner, Long> {
    
    List<UserLearner> findByEmail(String email);
}
