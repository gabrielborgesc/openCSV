package com.aps2.analisedadosensino;

public class Utils {

    public static String BREAK_LINE = System.lineSeparator();

    public static boolean parseBoolean(String value) {
        try {
            double number = Double.parseDouble(value);
            if(number == 1)
            	return true;
            if(number == 0)
            	return false;
            
            throw new IllegalArgumentException("Entrada inválida: " + value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada inválida: " + value);
        }
    }
}
