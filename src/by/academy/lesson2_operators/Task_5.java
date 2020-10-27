package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_5 {
    int arrLen;
    int numberIn;
    public Task_5(){};
    public void getArrNunber(){
        System.out.println("Введите 2 значения через пробел: 1) размер массива 2) целое число");
        Scanner scan = new Scanner(System.in);
        boolean isArrLenInt = scan.hasNextInt();
        boolean isNumberIn = scan.hasNext();
        if (isArrLenInt == true) {
            arrLen = scan.nextInt();
            System.out.println("Длина инт " + arrLen);
        } else {
            System.out.println("Длина не инт");
        }

        if (isNumberIn == true) {
            numberIn = scan.nextInt();
            System.out.println("Число инт " + numberIn);
        } else {
            System.out.println("Число не инт");
        }
    }
    public void getArr(){

    }
}
