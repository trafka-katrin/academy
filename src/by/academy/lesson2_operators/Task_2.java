package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_2 {
    static String variaBle;
    public Task_2 (){};
    public static void getVariaBle (){
        System.out.println("Введите тип данных (int, double, float, char, string) и соответствующую переменную через пробел. Например: \"int 1\"");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        switch (s){
                case "int":
                    if (scan.hasNextInt()) {
                        variaBle = "Integer";
                        int intN = scan.nextInt();
                        int intM = intN % 2;
                        System.out.println("Переменная типа " + variaBle + " = " + intN + ". Остаток от деления на 2 = " + intM);
                    } else {
                        System.out.println("Введенное значение не соответствует выбранному типу переменной");
                    }
                    break;
                case "double":
                    if (scan.hasNextDouble()){
                        double doubleN = scan.nextDouble();
                        double doubleM = doubleN * 0.7;
                        variaBle = "Double";
                        System.out.println("Переменная типа " + variaBle + " = " + doubleN + ". 70% от пеменной = " + doubleM);
                    } else {
                        System.out.println("Введенное значение не соответствует выбранному типу переменной");
                    }
                    break;
                case "float":
                    if (scan.hasNextDouble()){
                        double d = scan.nextDouble();
                        if (d <= Float.MAX_VALUE){
                            double floatM = Math.pow(d,2);
                            variaBle = "Float";
                            System.out.println("Переменная типа " + variaBle + " = " + d + ". Квадрат переменной = " + floatM);
                        } else {
                            System.out.println("Значение переменной не помещается в выбранный тип");
                        }
                    } else {
                        System.out.println("Введенное значение не соответствует выбранному типу переменной");
                    }
                    break;
                case "char":
                    if (scan.hasNext()) {
                        String stringN = scan.next();
                        int len = stringN.length();
                        if (len > 1) {
                            System.out.println("Введенное значение не соответствует выбранному типу переменной");
                        } else if (len == 1){
                            variaBle = "Char";
                            int intChar = (int)stringN.charAt(0);
                            System.out.println("Переменная типа " + variaBle + " = " + stringN + ". Код символа = " + intChar);
                        };
                    }
                    break;
                case "string":
                    if (scan.hasNextLine()) {
                        String stringN = scan.nextLine();
                        System.out.println("Hello " + stringN);
                    } else {
                        System.out.println("Введенное значение не соответствует выбранному типу переменной");
                    }
                    break;
                default:
                    System.out.println("Unsupported type");

        }

    }


}
