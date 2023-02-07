// package br.com.learningapi.learningapi.domain.model;

// import java.util.Date;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "annotations")
// public class UserAnnotation {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id_annotation")
//     private Long id;

//     @Column(nullable = false)
//     private String title;

//     @Column(nullable = false)
//     private Date date;

//     @Column(nullable = true)
//     private String description;

//     @Column(columnDefinition = "TEXT", nullable = false)
//     private String annotation;

//     @Column(nullable = true)
//     private String color;

//     @ManyToOne
//     @JoinColumn(name = "id_user")
//     private UserLearner user;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public Date getDate() {
//         return date;
//     }

//     public void setDate(Date date) {
//         this.date = date;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getAnnotation() {
//         return annotation;
//     }

//     public void setAnnotation(String annotation) {
//         this.annotation = annotation;
//     }

//     public String getColor() {
//         return color;
//     }

//     public void setColor(String color) {
//         this.color = color;
//     }

  
// }
