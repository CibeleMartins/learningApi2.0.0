package br.com.learningapi.learningapi.domain.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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

        return null;
    }

    @Override
    public UserLearnerResponse getById(Long id) {

        return null;
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
