package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_5 {
    static int arrLen;
    static int numberIn;
    static int countPairs = 0;
    static int[] array;
    public Task_5(){};
    public static void getArrNunber() {
        boolean n = false;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите 2 целых числа через пробел: 1) размер массива 2) просто целое число");
            if (scan.hasNextInt()) {
                arrLen = scan.nextInt();
                if (arrLen <= 0){
                    System.out.println("Длина массива должна быть не меньше 1");
                } else {
                    System.out.println("Длина массива " + arrLen);
                }
            } else {
                System.out.println("Длина массива не int");
                scan.next();
            }

            if (!scan.hasNextInt()) {
                System.out.println("Значение числа не int");
                n = false;
            } else {
                numberIn = scan.nextInt();
                n = true;
                System.out.println("Веденное число " + numberIn);
            }
        } while ((arrLen <= 0) || (n == false));
    }

    public static void getArray(){
        array = new int [arrLen];
        int uniq;
        int ex;

        do {
            uniq = 0;
            ex = 0;
            System.out.println("Введите " + arrLen + " целых чисел через пробел");
            Scanner scan2 = new Scanner(System.in);
            for (int i = 0; i < arrLen; i++) {
                if (scan2.hasNextInt()){
                    array[i] = scan2.nextInt();
                } else {
                    System.out.println("В массиве было что-то не то");
                    ex++;
                    scan2.next();
                }
            }

            for (int i = 0; i < (arrLen - 1); i++) {
                for (int j = (i + 1); j < arrLen; j++) {
                    if (array[i] == array[j]) {
                        uniq++;
                    } else {
                    }
                }
            }
            if (uniq > 0){
                System.out.println("Введенные в массив числа не уникальны");
            }
        } while (uniq > 0 || ex > 0);

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
