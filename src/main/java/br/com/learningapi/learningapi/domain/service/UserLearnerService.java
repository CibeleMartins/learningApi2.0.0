package br.com.learningapi.learningapi.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.learningapi.learningapi.domain.exception.ResourceNotFoundException;
import br.com.learningapi.learningapi.domain.model.UserLearner;
import br.com.learningapi.learningapi.domain.repository.UserLearnerRepository;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerRequest;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerResponse;

@Service
public class UserLearnerService implements CrudService<UserLearnerRequest, UserLearnerResponse> {

    @Autowired
    private UserLearnerRepository userLearnerRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired // criptografar senha do usuário
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserLearnerResponse> getAll() {

        // pega os usuários do BD
        List<UserLearner> usersModel = userLearnerRepository.findAll();

        List<UserLearnerResponse> usersDto = usersModel.stream().map(u -> mapper.map(u, UserLearnerResponse.class))
                .collect(Collectors.toList());

        return usersDto;
    }

    @Override
    public UserLearnerResponse getById(Long id) {

        Optional<UserLearner> optionalUserModel = userLearnerRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        UserLearnerResponse UserLearnerResponse = mapper.map(optionalUserModel.get(), UserLearnerResponse.class);

        return UserLearnerResponse;
    }

    @Override
    public UserLearnerResponse register(UserLearnerRequest dto) {

        UserLearner userModel = mapper.map(dto, UserLearner.class);

        // criptografa a senha do usuário
        String passwordUser = passwordEncoder.encode(userModel.getPasswordUser());
        userModel.setPasswordUser(passwordUser);
        userModel.setId(null);
        userModel.setDateRegister(new Date());
        userModel = userLearnerRepository.save(userModel);

        UserLearnerResponse userResponse = mapper.map(userModel, UserLearnerResponse.class);

        return userResponse;
    }

    @Override
    public UserLearnerResponse updateById(Long id, UserLearnerRequest dto) {

        // obtem o usuário pelo id
        UserLearnerResponse userDto = getById(id);

        
        // criptografa a senha do usuário
        String passwordUser = passwordEncoder.encode(dto.getPasswordUser());

        // transforma o usuario request em model
        UserLearner userModel = mapper.map(dto, UserLearner.class);

        userModel.setPasswordUser(passwordUser);
        // seta o id e a data de inatiacao p/ o que ja estava no banco
        userModel.setId(id);
        userModel.setInactivationDate(userDto.getInactivationDate());
        userModel.setDateRegister(userDto.getDateRegister());
        // salva no banco
        userModel = userLearnerRepository.save(userModel);

        UserLearnerResponse userResponse = mapper.map(userModel, UserLearnerResponse.class);

        return userResponse;
    }

    @Override
    public void deleteById(Long id) {

        // refatorou este método p/
        // não deletar o usuário do banco
        // apenas seta a data de inativacao
        // e atualiza esse usuário no banco

        Optional<UserLearner> userOptModel = userLearnerRepository.findById(id);

        if (userOptModel.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com o id: " + id);
        }

        UserLearner userModel = userOptModel.get();

        userModel.setInactivationDate(new Date());

        userLearnerRepository.save(userModel);
    }

}
