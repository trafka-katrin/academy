package by.academy.lesson2_operators;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int taskNumber;
        System.out.println("Введите номер задания от 1 до 5, для выхода другое целое число, для выхода с ошибкой что-нибудь еще");
        Scanner scan = new Scanner(System.in);

        do {

            taskNumber = scan.nextInt();
            switch (taskNumber) {
                case 1:
                    do {
                        System.out.println("Задание №1");
                        Task_1.getPurchaseAmount();
                        Task_1.setfFinalPrice();
                        System.out.println("Для повторного запуска этого задания введите 1, для выбора другого задания его номер, для выхода с ошибкой что-нибудь еще");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 1);
                    break;

                case 2:
                    do {
                        System.out.println("Задание №2");
                        Task_2.getVariaBle();
                        System.out.println("Для повторного запуска этого задания введите 2, для выбора другого задания его номер, для выхода с ошибкой что-нибудь еще");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 2);
                    break;
                case 3:
                    do {
                        System.out.println("Задание №3");
                        Task_3 task_3 = new Task_3();
                        task_3.getNumber();
                        System.out.println("Для повторного запуска этого задания введите 3, для выбора другого задания его номер, для выхода с ошибкой что-нибудь еще");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 3);
                    break;

                case 4:
                    do {
                        System.out.println("Задание №4");
                        Task_4 task_4 = new Task_4();
                        task_4.printPower();
                        System.out.println("Для повторного запуска этого задания введите 4, для выбора другого задания его номер, для выхода с ошибкой что-нибудь еще");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 4);
                    break;

                case 5:
                    do {
                        System.out.println("Задание №5");
                        Task_5.getArrNunber();
                        Task_5.getArray();
                        System.out.println("Для повторного запуска этого задания введите 5, для выбора другого задания его номер, для выхода с ошибкой что-нибудь еще");
                        taskNumber = scan.nextInt();
                    } while (taskNumber == 5);
                    break;
                default:
                    System.out.println("Пока");
                    break;
            }

        } while (taskNumber>0 && taskNumber<6);

    }
}

/*
Не работает hasNextFloat или ХЗ как работает
Одно и то же число в double и float не равно само себе

 */