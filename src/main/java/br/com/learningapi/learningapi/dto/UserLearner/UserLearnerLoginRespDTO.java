package br.com.learningapi.learningapi.dto.UserLearner;

public class UserLearnerLoginRespDTO {
    private String tokenAuthorization;

    private UserLearnerResponse user;

    public String getTokenAuthorization() {
        return tokenAuthorization;
    }

    public void setTokenAuthorization(String tokenAuthorization) {
        this.tokenAuthorization = tokenAuthorization;
    }

    public UserLearnerResponse getUser() {
        return user;
    }

    public void setUser(UserLearnerResponse user) {
        this.user = user;
    }
}
