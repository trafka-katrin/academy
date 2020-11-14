package by.academy.home_work.HW_1__operators;

import java.util.Scanner;

public class Task_5 {
    static int arrLen;
    static int numberIn;
    static int countPairs;
    static int[] array;
    public Task_5(){};
    public static void getArrNunber() {
            boolean repitEnter = false;
            do {
                Scanner scan0 = new Scanner(System.in);
                repitEnter = false;
                System.out.println("Введите 2 целых числа через пробел:\n" +
                        "1) размер массива (>1) \n" +
                        "2) просто целое число");
                boolean isArLenInt = scan0.hasNextInt();
                String arLenS = scan0.next();
                boolean isNumInt = scan0.hasNextInt();
                String numS = scan0.next();
                if (isArLenInt && isNumInt){
                    arrLen = Integer.parseInt(arLenS);
                    numberIn = Integer.parseInt(numS);
                    if (arrLen < 2){
                        System.out.println("Длина массива не должна быть мееньше 2");
                        repitEnter = true;
                    } else {}
                } else {
                    System.out.println("Веденные данные не соответствуют двум целым числам");
                    repitEnter = true;
                }
            } while (repitEnter);

            System.out.println("Длина массива " + arrLen);
            System.out.println("Веденное число " + numberIn);

    }

    public static void getArray(){
        array = new int [arrLen];
        countPairs = 0;
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
