package br.com.learningapi.learningapi.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.learningapi.learningapi.domain.model.UserLearner;
import br.com.learningapi.learningapi.domain.repository.UserLearnerRepository;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserLearnerRequest;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserLearnerResponse;

public class UserLearnerService implements CrudService<UserLearnerRequest, UserLearnerResponse> {

    @Autowired
    private UserLearnerRepository userLearnerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserLearnerResponse> getAll() {

        List<UserLearner> usersLearnersModel = userLearnerRepository.findAll();

        List<UserLearnerResponse> usersLearnersResponse = usersLearnersModel.stream().map(u -> mapper.map(u, UserLearnerResponse.class)).collect(Collectors.toList());
        
        return usersLearnersResponse;
    }

    @Override
    public UserLearnerResponse getById(Long id) {

        Optional<UserLearner> userLearnerModel = userLearnerRepository.findById(id);

        if(userLearnerModel.isEmpty()) {
            throw new Error("O usuário de id: " + id + " não ofi encontrado.");
        }

        UserLearnerResponse userLearnerResponse = mapper.map(userLearnerModel.get(), UserLearnerResponse.class);

        return userLearnerResponse;
    }

    @Override
    public UserLearnerResponse register(UserLearnerRequest dto) {

        return null;
    }

    @Override
    public UserLearnerResponse updateById(Long id, UserLearnerRequest dto) {

        return null;
    }

}
