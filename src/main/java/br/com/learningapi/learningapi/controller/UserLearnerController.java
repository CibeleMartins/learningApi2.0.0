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

import br.com.learningapi.learningapi.domain.service.UserLearnerService;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerRequest;
import br.com.learningapi.learningapi.dto.UserLearner.UserLearnerResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserLearnerController {
    
    @Autowired
    private UserLearnerService userLearnerService;
    
    @GetMapping
    public ResponseEntity<List<UserLearnerResponse>> getAll() {

        return ResponseEntity.ok(userLearnerService.getAll());
    }

       
    @GetMapping("/{id}")
    public ResponseEntity<UserLearnerResponse> getById(@PathVariable Long id) {

        return ResponseEntity.ok(userLearnerService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<UserLearnerResponse> register(@RequestBody UserLearnerRequest userDto){

        UserLearnerResponse userRegistered = userLearnerService.register(userDto);

        return new ResponseEntity<>(userRegistered, HttpStatus.CREATED);    
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserLearnerResponse> update(@PathVariable Long id, @RequestBody UserLearnerRequest userDto){

        UserLearnerResponse userRegistered = userLearnerService.updateById(id ,userDto);

        return new ResponseEntity<>(userRegistered, HttpStatus.OK);    
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        userLearnerService.deleteById(id);

    }
}
