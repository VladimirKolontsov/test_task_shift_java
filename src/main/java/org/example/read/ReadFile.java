package org.example.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.check.CheckDouble.isFloat;
import static org.example.check.CheckInteger.isLong;
import static org.example.write.WriteToDoubFile.writeToFloatFile;
import static org.example.write.WriteToIntFile.writeToIntegerFile;
import static org.example.write.WriteToStrFile.writeToStringFile;

public class ReadFile {

    public static int totalCountInt = 0;
    public static int totalCountDoub = 0;
    public static int totalCountStr = 0;
    public static long minInt = Integer.MAX_VALUE;
    public static long minIntGlobal = Integer.MAX_VALUE;
    public static long maxInt = Integer.MIN_VALUE;
    public static long maxIntGlobal = Integer.MIN_VALUE;
    public static long sumInt = 0;
    public static long sumIntGlobal = 0;
    public static long avgIntGlobal = 0;
    public static double minDoub = Double.MAX_VALUE;
    public static double minDoubGlobal= Double.MAX_VALUE;
    public static double maxDoub = Double.MIN_VALUE;
    public static double maxDoubGlobal = Double.MIN_VALUE;
    public static double sumDoub = 0.0;
    public static double sumDoubGlobal = 0.0;
    public static double avgDoubGlobal = 0.0;
    public static int minStrLength = Integer.MAX_VALUE;
    public static int minStrLengthGlobal = Integer.MAX_VALUE;
    public static int maxStrLength = Integer.MIN_VALUE;
    public static int maxStrLengthGlobal = Integer.MIN_VALUE;

    public static void readFile(String filePath) {
        int localCountInt = 0;
        int localCountDoub = 0;
        int localCountStr = 0;

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                if (isLong(line)) {
                    long num = Long.parseLong(line);

                    writeToIntegerFile(line);
                    localCountInt++;

                    // Обновление статистики для чисел
                    minInt = Math.min(minInt, num);
                    maxInt = Math.max(maxInt, num);
                    sumInt += num;
                } else if (isFloat(line)){
                    double num = Double.parseDouble(line);

                    writeToFloatFile(line);
                    localCountDoub++;

                    // Обновление статистики для чисел с плавающей точкой
                    minDoub = Math.min(minDoub, num);
                    maxDoub = Math.max(maxDoub, num);
                    sumDoub += num;
                } else {
                    writeToStringFile(line);
                    localCountStr++;

                    // Обновление статистики для строк
                    minStrLength = Math.min(minStrLength, line.length());
                    maxStrLength = Math.max(maxStrLength, line.length());
                }
            }

            totalCountInt += localCountInt;
            totalCountDoub += localCountDoub;
            totalCountStr += localCountStr;

            minIntGlobal = Math.min(minIntGlobal, minInt);
            maxIntGlobal = Math.max(maxIntGlobal, maxInt);
            sumIntGlobal += sumInt;
            double midResult = (double) sumIntGlobal / totalCountInt;
            avgIntGlobal = Math.round(midResult);

            minDoubGlobal = Math.min(minDoubGlobal, minDoub);
            maxDoubGlobal = Math.max(maxDoubGlobal, maxDoub);
            sumDoubGlobal += sumDoub;
            avgDoubGlobal = sumDoubGlobal / totalCountDoub;

            minStrLengthGlobal = Math.min(minStrLengthGlobal, minStrLength);
            maxStrLengthGlobal = Math.max(maxStrLengthGlobal, maxStrLength);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());;
        }
    }

}