package br.com.learningapi.learningapi.dto.UserAnnotation;

import java.util.Date;

public class UserAnnotationReqDTO {
 
    
    private String title;

    private String date;

    private String annotation;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getAnnotation() {
        return annotation;
    }


    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
