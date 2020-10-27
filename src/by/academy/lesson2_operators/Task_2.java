package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_2 {
    static String variaBle;
    public Task_2 (){};
    public static void getVariaBle (){
        System.out.println("Введите что-нибудь");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            variaBle = "Integer";
            System.out.println("Переменная типа " + variaBle);
        } else if (scan.hasNextFloat()){
            variaBle = "Float";
            System.out.println("Переменная типа " + variaBle);
            double n = scan.nextFloat();
            System.out.println(n);
        } else if (scan.hasNextDouble()){
            variaBle = "Double";
            System.out.println("Переменная типа " + variaBle);
        } else if (scan.hasNextLine()) {
            variaBle = scan.nextLine();
            int len = variaBle.length();
            if (len > 1) {
                variaBle = "String";
                System.out.println("Переменная типа " + variaBle);
            } else if (len == 1){
                variaBle = "Char";
                System.out.println("Переменная типа " + variaBle);
            };
        } else {
            System.out.println("Kva");
        }

    }


}
