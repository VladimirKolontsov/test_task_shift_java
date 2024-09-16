package org.example;

import java.io.File;

import static org.example.read.ReadFile.avgDoubGlobal;
import static org.example.read.ReadFile.avgIntGlobal;
import static org.example.read.ReadFile.maxDoubGlobal;
import static org.example.read.ReadFile.maxIntGlobal;
import static org.example.read.ReadFile.maxStrLengthGlobal;
import static org.example.read.ReadFile.minDoubGlobal;
import static org.example.read.ReadFile.minIntGlobal;
import static org.example.read.ReadFile.minStrLengthGlobal;
import static org.example.read.ReadFile.readFile;
import static org.example.read.ReadFile.sumDoubGlobal;
import static org.example.read.ReadFile.sumIntGlobal;
import static org.example.read.ReadFile.totalCountDoub;
import static org.example.read.ReadFile.totalCountInt;
import static org.example.read.ReadFile.totalCountStr;

public class Main
{
    public static String directory;
    public static String fileName;
    public static boolean aFlag;
    public static String statisticType;
    public static String filePathToWriteDouble;
    public static String filePathToWriteInt;
    public static String filePathToWriteString;

    public static void main( String[] args ) {

        // разбираем флаги
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o") && args[i + 1].charAt(0) != '-') {
                directory = args[i+1];
            } else if (args[i].equals("-p") && args[i + 1].charAt(0) != '-') {
                fileName = args[i+1];
            } else if (args[i].equals("-a") && args[i + 1].charAt(0) != '-') {
                if (args[i + 1].equals("false")) {
                    aFlag = false;
                } else {
                    aFlag = true;
                }
            } else if (args[i].equals("-s")) {
                statisticType = "short";
            } else if (args[i].equals("-f")) {
                statisticType = "full";
            }
        }

        // выясняем какая директория и имя файла для записи
        if (directory != null && !directory.isEmpty() && fileName != null &&!fileName.isEmpty()) {
            filePathToWriteDouble = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/" + fileName + "floats.txt";
            filePathToWriteInt = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/" + fileName + "integers.txt";
            filePathToWriteString = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/" + fileName + "strings.txt";
        } else if (directory != null && !directory.isEmpty()) {
            filePathToWriteDouble = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/floats.txt";
            filePathToWriteInt = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/integers.txt";
            filePathToWriteString = "/Users/vladimirkoloncov/IdeaProjects/util-shift"
                    + directory + "/strings.txt";
        } else if (fileName != null && !fileName.isEmpty()) {
            filePathToWriteDouble = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/"
                    + fileName + "floats.txt";
            filePathToWriteInt = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/"
                    + fileName + "integers.txt";
            filePathToWriteString = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/"
                    + fileName + "strings.txt";
        } else {
            filePathToWriteDouble = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/floats.txt";
            filePathToWriteInt = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/integers.txt";
            filePathToWriteString = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/output/strings.txt";
        }

        File fileDouble;
        File fileInt;
        File fileString;

        //если стоит флаг на запись данных в файл с нуля, то удаляем все из файлов
        if (!aFlag) {
            fileDouble = new File(filePathToWriteDouble);
            fileDouble.delete();
            fileInt = new File(filePathToWriteInt);
            fileInt.delete();
            fileString = new File(filePathToWriteString);
            fileString.delete();

        }

        String filePath;

        for (String arg : args) {
            if (arg.endsWith(".txt")) {
                filePath = "/Users/vladimirkoloncov/IdeaProjects/util-shift/src/input/" + arg;
                readFile(filePath);
            }
        }

        showStatistic(statisticType);
    }

    private static void showStatistic(String flag) {
        if (flag != null && flag.equals("short")) {
            System.out.println("Количество целых чисел " + ": " + totalCountInt);
            System.out.println("Количество чисел с плавающей точкой " + ": " + totalCountDoub);
            System.out.println("Количество строк " + ": " + totalCountStr);
        } else if (flag != null && flag.equals("full")) {

            // Вывод статистики для целых чисел
            System.out.println("Минимальное значение целых чисел: " + minIntGlobal);
            System.out.println("Максимальное значение целых чисел: " + maxIntGlobal);
            System.out.println("Сумма целых чисел: " + sumIntGlobal);
            System.out.println("Среднее значение целых чисел: " + avgIntGlobal);
            System.out.println();
            // Вывод статистики для чисел с плавающей строчкой
            System.out.println("Минимальное значение чисел с плавающей точкой: " + minDoubGlobal);
            System.out.println("Максимальное значение чисел с плавающей точкой: " + maxDoubGlobal);
            System.out.println("Сумма чисел с плавающей точкой: " + sumDoubGlobal);
            System.out.println("Среднее значение чисел с плавающей точкой: " + avgDoubGlobal);
            System.out.println();
            // Вывод статистики для строк
            System.out.println("Самая короткая строка: " + minStrLengthGlobal);
            System.out.println("Самая длинная строка: " + maxStrLengthGlobal);
            System.out.println("-----------------------------------------------------");
            System.out.println("Количество целых чисел " + ": " + totalCountInt);
            System.out.println("Количество чисел с плавающей точкой " + ": " + totalCountDoub);
            System.out.println("Количество строк " + ": " + totalCountStr);
        }
    }

}
