package org.example.check;

public class CheckDouble {

    public static boolean isFloat(String str) {
        try {
            Double.parseDouble(str);
            // Если преобразование прошло успешно, значит строка является числом
            return true;
        } catch (NumberFormatException e) {
            // Если произошло исключение, значит строка не является числом
            return false;
        }
    }
}
