package br.com.learningapi.learningapi.domain.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class UserLearner  {

    private Long id;

    private String nameUser;

    private String emailUser;

    private String passwordUser;

    private String photoUser;

    private List<UserAnnotation> annotations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPhotoUser() {
        return photoUser;
    }

    public void setPhotoUser(String photoUser) {
        this.photoUser = photoUser;
    }

    public List<UserAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<UserAnnotation> annotations) {
        this.annotations = annotations;
    }


    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {

    //     return null;
    // }

    // @Override
    // public String getPassword() {

    //     return password;
    // }

    // @Override
    // public String getUsername() {

    //     return email;
    // }

    // @Override
    // public boolean isAccountNonExpired() {

    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {

    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return false;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }

}
