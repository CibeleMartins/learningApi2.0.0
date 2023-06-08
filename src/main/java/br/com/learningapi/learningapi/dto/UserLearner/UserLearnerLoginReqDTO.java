package br.com.learningapi.learningapi.dto.UserLearner;

public class UserLearnerLoginReqDTO {
  
    private String emailUser;

    private String passwordUser;

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
 
}
