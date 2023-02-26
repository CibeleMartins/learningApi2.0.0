package br.com.learningapi.learningapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.learningapi.learningapi.domain.model.UserLearner;

@Repository
public interface UserLearnerRepository extends JpaRepository<UserLearner, Long> {
    
    Optional<UserLearner> findByEmailUser(String emailUser);
}
