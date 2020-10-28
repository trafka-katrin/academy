package by.academy.lesson2_operators;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int taskNumber;

        do {
            System.out.println("Введите номер задания от 1 до 5, для выхода другое целое число");
            Scanner scan = new Scanner(System.in);
            taskNumber = scan.nextInt();
            switch (taskNumber) {
                case 1:
                    do {
                        System.out.println("Задание №1");
                        Task_1 task_1 = new Task_1();
                        task_1.getPurchaseAmount();
                        task_1.getBuyersAge();
                        task_1.setfFinalPrice();
                        System.out.println("Для повторного запуска задания введите 1, для выбора другого задания не 1");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 1);
                    break;

                case 2:
                    do {
                        System.out.println("Задание №2");
                        Task_2.getVariaBle();
                        System.out.println("Для повторного запуска задания введите 2, для выбора другого задания не 2");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 2);
                    break;
                case 3:
                    do {
                        System.out.println("Задание №3");
                        Task_3 task_3 = new Task_3();
                        task_3.getNumber();
                        System.out.println("Для повторного запуска задания введите 3, для выбора другого задания не 3");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 3);
                    break;

                case 4:
                    do {
                        System.out.println("Задание №4");
                        Task_4 task_4 = new Task_4();
                        task_4.printPower();
                        System.out.println("Для повторного запуска задания введите 3, для выбора другого задания не 3");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 4);
                    break;

                case 5:
                    do {
                        System.out.println("Задание №5");
                        Task_5.getArrNunber();
                        Task_5.getArray();
                        System.out.println("Для повторного запуска задания введите 3, для выбора другого задания не 3");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 5);
                    break;
                default:
                    System.out.println("Пока");
                    break;
            }
        } while (taskNumber>0&& taskNumber<5);
    }
}

/*
Не работает hasNextFloat
Одно и то же число в double и float не равно само себе

 */