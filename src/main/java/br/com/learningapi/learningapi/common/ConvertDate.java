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

    public static String convertDateAnnotation(String date) {
        
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formatoEntrada.parse(date);
            return formatoSaida.format(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
