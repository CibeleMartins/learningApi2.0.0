package br.com.learningapi.learningapi.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.learningapi.learningapi.common.ConvertDate;
import br.com.learningapi.learningapi.domain.exception.ResourceNotFoundException;
import br.com.learningapi.learningapi.domain.model.UserAnnotation;
import br.com.learningapi.learningapi.domain.model.UserLearner;
import br.com.learningapi.learningapi.domain.repository.UserAnnotationRepository;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserAnnotationReqDTO;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserAnnotationRespDTO;

@Service
public class UserAnnotationService implements CrudService<UserAnnotationReqDTO, UserAnnotationRespDTO> {
    
    @Autowired
    private UserAnnotationRepository userAnnotationRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserAnnotationRespDTO> getAll() {
        UserLearner user = (UserLearner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserAnnotation> listUserAnnotations = userAnnotationRepository.findByUser(user);
    
        return listUserAnnotations.stream().map(uA -> mapper.map(uA, UserAnnotationRespDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserAnnotationRespDTO getById(Long id) {
       
        Optional<UserAnnotation> UserAnnotationModelRepository = userAnnotationRepository.findById(id);

        if(UserAnnotationModelRepository.isEmpty()) {
            throw new ResourceNotFoundException("Centro de custo não encontrado.");
        }

        return mapper.map(UserAnnotationModelRepository.get(), UserAnnotationRespDTO.class);
    }

    @Override
    public UserAnnotationRespDTO register(UserAnnotationReqDTO dto) {

        UserAnnotation userAnnotationModel = mapper.map(dto, UserAnnotation.class);

        // quem é o usuário que faz essa requisição
        UserLearner user = (UserLearner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // define que o usuário que criou o centro de custo foi o usuário que fez a requisição
        userAnnotationModel.setUser(user);
        String dateString = userAnnotationModel.getDate();

        String dateStringFormated = ConvertDate.convertDateAnnotation(dateString);

        userAnnotationModel.setDate(dateStringFormated);

        userAnnotationModel.setId(null);

        userAnnotationModel = userAnnotationRepository.save(userAnnotationModel);
     
        return mapper.map(userAnnotationModel, UserAnnotationRespDTO.class);
    }

    @Override
    public UserAnnotationRespDTO updateById(Long id, UserAnnotationReqDTO dto) {

        getById(id);
        UserAnnotation UserAnnotationModel = mapper.map(dto, UserAnnotation.class);

        UserLearner user = (UserLearner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAnnotationModel.setUser(user);
        UserAnnotationModel.setId(id);
        String dateAnnotationModel = UserAnnotationModel.getDate();
        String dateConvertedFormated = ConvertDate.convertDateAnnotation(dateAnnotationModel);
        UserAnnotationModel.setDate(dateConvertedFormated);

        UserAnnotationModel = userAnnotationRepository.save(UserAnnotationModel);
      
        return mapper.map(UserAnnotationModel, UserAnnotationRespDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        
        getById(id);
        userAnnotationRepository.deleteById(id);
    }

    
} 
    

