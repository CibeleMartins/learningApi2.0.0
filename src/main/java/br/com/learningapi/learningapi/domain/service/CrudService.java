package br.com.learningapi.learningapi.domain.service;

import java.util.List;

public interface CrudService<Req, Res> {
    
    List<Res> getAll();

    Res getById(Long id);

    Res register(Req dto);

    Res updateById(Long id,Req dto);

    void deleteById(Long id);
}
