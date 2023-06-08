package br.com.learningapi.learningapi.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
 
    public static String convertDateForDateHour(Date date) {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

        String dateFormated = format.format(date);

        return dateFormated;
    }

    public static Date convertDateAnnotation(String date) {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

        Date dateFormated = new Date();
        try {
            dateFormated = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateFormated;
    }
}
