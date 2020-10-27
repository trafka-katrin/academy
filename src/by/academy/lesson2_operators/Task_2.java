package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_2 {
    String variaBle;
    boolean isVariaBleInt;
    boolean isVariaBleDouble;
    boolean isVariaBleFloat;
    boolean isVariaBleString;
    boolean isVariaBleStringFinal;
    boolean isVariaBleChar;


    public Task_2 (){};
    public void getVariaBle (){
        System.out.println("Введите что-нибудь");
        Scanner scan = new Scanner(System.in);
        isVariaBleInt = scan.hasNextInt();
        isVariaBleDouble = scan.hasNextDouble();
        isVariaBleFloat = scan.hasNextFloat();
        isVariaBleString = scan.hasNextLine();
        variaBle = scan.nextLine();

    }
    public void defineVariaBle(){
        if (isVariaBleInt == true) {
            variaBle = "Integer";
            System.out.println("Переменная типа " + variaBle);
        } else if (isVariaBleFloat == true){
            variaBle = "Float";
            System.out.println("Переменная типа " + variaBle);
        } else if (isVariaBleDouble == true){
            variaBle = "Double";
            System.out.println("Переменная типа " + variaBle);
        } else if (isVariaBleString == true) {
            int len = variaBle.length();
            if (len > 1) {
                variaBle = "String";
                System.out.println("Переменная типа " + variaBle);
            } else if (len ==1){
                variaBle = "Char";
                System.out.println("Переменная типа " + variaBle);
            };
        } else {
            System.out.println("Kva");
        }
    }


}
