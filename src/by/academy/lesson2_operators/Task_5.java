package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_5 {
    static int arrLen;
    static int numberIn;
    static int countPairs = 0;
    static int[] array;
    public Task_5(){};
    public static void getArrNunber(){
        System.out.println("Введите 2 значения через пробел: 1) размер массива 2) целое число");
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            arrLen = scan.nextInt();
            System.out.println("Длина инт " + arrLen);
            array = new int [arrLen];
        } else {
            System.out.println("Длина не инт");
        }

        if (scan.hasNextInt()) {
            numberIn = scan.nextInt();
            System.out.println("Число инт " + numberIn);
        } else {
            System.out.println("Число не инт");
        }

    }
    public static void getArray(){
        System.out.println("Введите " + arrLen + " целых чисел через пробел");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arrLen; i++){
            array[i] = scan.nextInt();
        }

        for (int i = 0; i <arrLen; i++){
            for (int j = 0; j <arrLen; j++){
                if (array[i] - array[j] == numberIn){
                    countPairs++;
                }
            }
        }
        System.out.println("Пар: " + countPairs);

    }
}
