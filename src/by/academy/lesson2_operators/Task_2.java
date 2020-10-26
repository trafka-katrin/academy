package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_2 {
    String variaBle;
    boolean variaBleInt;
    boolean variaBleString;

    public Task_2 (){};
    public void getVariaBle (){
        System.out.println("Введите что-нибудь");
        Scanner scan = new Scanner(System.in);
        variaBleInt = scan.hasNextInt();
        variaBleString = scan.hasNextLine();
    }
    public String defineVariaBle(){
        if (variaBleInt == true) {
            variaBle = "Int";
            System.out.println("Переменная типа " + variaBle);
        } else if (variaBleString == true) {
            variaBle = "String";
            System.out.println("Переменная типа " + variaBle);
        } else
            {
            System.out.println("Kva");

        }
        return variaBle;

    }


}
