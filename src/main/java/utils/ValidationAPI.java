package utils;

public class ValidationAPI {
    public static boolean validarNomMajuscula(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return false;
        }
        return Character.isUpperCase(nom.charAt(0));
    }
}