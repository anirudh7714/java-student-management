package utils;

public class InputValidator {

    public static boolean isValidName(String s) {
        return s != null && s.trim().length() > 0;
    }

    public static boolean isValidRoll(String s) {
        return s != null && s.trim().length() > 0;
    }

    public static boolean isValidMark(int m) {
        return m >= 0 && m <= 100;
    }
}
