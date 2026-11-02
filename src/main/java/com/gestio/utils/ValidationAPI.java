package com.gestio.utils;

public class ValidationAPI {

    public static boolean esTextValid(String text) {
        return text != null && !text.trim().isEmpty();
    }

    public static boolean esDniValid(String dni) {
        if (dni == null) return false;
        String dniRegex = "^[0-9]{8}[A-Za-z]$";
        return dni.matches(dniRegex);
    }

    public static boolean esTelefonValid(String telefon) {
        if (telefon == null) return false;
        String telRegex = "^[0-9]{9}$";
        return telefon.matches(telRegex);
    }
}