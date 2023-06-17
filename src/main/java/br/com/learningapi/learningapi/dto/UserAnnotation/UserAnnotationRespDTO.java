package br.com.learningapi.learningapi.dto.UserAnnotation;

import br.com.learningapi.learningapi.domain.model.UserLearner;

public class UserAnnotationRespDTO {

    private Long id;
    
    private String title;

    private String createdAt;

    private String updatedAt;

    private String annotation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

     public String setUpdatedAt(String lastUpdate) {
        return this.updatedAt = lastUpdate;
    }
  
}
