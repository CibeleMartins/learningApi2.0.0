package br.com.learningapi.learningapi.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.learningapi.learningapi.domain.model.UserLearner;
import br.com.learningapi.learningapi.domain.repository.UserLearnerRepository;

@Component
public class UserDetailsSecurityServer implements UserDetailsService {

    @Autowired
    private UserLearnerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UserLearner> userModelRepository = userRepository.findByEmailUser(username);

        if(userModelRepository.isEmpty()) {
            
            throw new UsernameNotFoundException("Usuário ou senha inválidos.");
        }

        return userModelRepository.get();
    }

    
    
}