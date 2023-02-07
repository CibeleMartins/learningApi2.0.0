package br.com.learningapi.learningapi.dto.UserLearner;

import java.util.Date;

public class UserLearnerResponse {

    private Long id;

    private String nameUser;

    private String emailUser;

    // private String passwordUser;

    private String photoUser;

    private Date dateRegister;

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

    // public String getPasswordUser() {
    //     return passwordUser;
    // }

    // public void setPasswordUser(String passwordUser) {
    //     this.passwordUser = passwordUser;
    // }

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

}
