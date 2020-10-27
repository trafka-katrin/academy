package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_3 {
    int number;
    boolean isNumberInt;
    public  Task_3(){};
    public void getNumber(){
        System.out.println("Введите целое число от 1 до 10");
        Scanner scan = new Scanner(System.in);
        isNumberInt = scan.hasNextInt();
        if (isNumberInt == true) {
            number = scan.nextInt();
            if (number >= 1 && number <= 10){
                for (int i=1; i<11;i++) {
                    int prodNum = number * i;
                    System.out.println(number + " * " +  i  + " = " + prodNum);
                }
            } else {
                System.out.println("Введенное число не входит в диапазон от 1 до 10");
            }
        } else {
            System.out.println("Вы ввели совсем не то что вас просили");
        }
    }

}
