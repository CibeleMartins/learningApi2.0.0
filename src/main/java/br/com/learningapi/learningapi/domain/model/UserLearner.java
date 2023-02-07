package br.com.learningapi.learningapi.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLearner  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;

    private String nameUser;

    @Column(nullable = false, unique = true)
    private String emailUser;

    @Column(nullable = false)
    private String passwordUser;

    @Column(columnDefinition = "TEXT")
    private String photoUser;

    @Column(nullable = false)
    private Date dateRegister;

    @Column(nullable = true)
    private Date inactivationDate;

    // private List<UserAnnotation> annotations;

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

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getInactivationDate() {
        return inactivationDate;
    }

    public void setInactivationDate(Date inactivationDate) {
        this.inactivationDate = inactivationDate;
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
