package com.aps2.analisedadosensino;

public class Utils {

    public static String BREAK_LINE = System.lineSeparator();

    public static boolean parseBoolean(String value) {
        try {
            var number = Double.parseDouble(value);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
