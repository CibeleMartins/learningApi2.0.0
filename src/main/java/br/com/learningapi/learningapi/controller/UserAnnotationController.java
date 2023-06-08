package br.com.learningapi.learningapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learningapi.learningapi.domain.service.UserAnnotationService;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserAnnotationReqDTO;
import br.com.learningapi.learningapi.dto.UserAnnotation.UserAnnotationRespDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/annotations")
public class UserAnnotationController {
    
    @Autowired
    private UserAnnotationService userAnnotationService;

    @GetMapping
    public ResponseEntity<List<UserAnnotationRespDTO>> getAll() {

        return ResponseEntity.ok(userAnnotationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAnnotationRespDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(userAnnotationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserAnnotationRespDTO> register(@RequestBody UserAnnotationReqDTO annotation) {

        return new ResponseEntity<>(userAnnotationService.register(annotation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAnnotationRespDTO> update(@PathVariable Long id ,@RequestBody UserAnnotationReqDTO annotation) {

        return new ResponseEntity<>(userAnnotationService.updateById(id,annotation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userAnnotationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

