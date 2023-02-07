package br.com.learningapi.learningapi.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {
 
    public static String convertDateForDateHour(Date date) {
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

        String dateFormated = format.format(date);

        return dateFormated;
    }
}
