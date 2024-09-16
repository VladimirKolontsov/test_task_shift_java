package org.example.check;

public class CheckInteger {

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            // Если преобразование прошло успешно, значит строка является числом
            return true;
        } catch (NumberFormatException e) {
            // Если произошло исключение, значит строка не является числом
            return false;
        }
    }

}
