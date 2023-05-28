package br.com.learningapi.learningapi.dto.UserAnnotation;

import java.util.Date;

public class UserAnnotationReqDTO {
 
    
    private String title;

    private Date date;

    private String annotation;

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getAnnotation() {
        return annotation;
    }


    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
