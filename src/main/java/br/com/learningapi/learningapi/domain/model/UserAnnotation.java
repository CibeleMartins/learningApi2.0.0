package br.com.learningapi.learningapi.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "annotations")
public class UserAnnotation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annotation")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String createdAt;

    @Column(nullable = true)
    private String updatedAt;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String annotation;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserLearner user;

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

    public UserLearner getUser() {

        return user;
    }

    public void setUser(UserLearner user) {

        this.user = user;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

     public String setUpdatedAt(String lastUpdate) {
        return this.updatedAt = lastUpdate;
    }
  
}
