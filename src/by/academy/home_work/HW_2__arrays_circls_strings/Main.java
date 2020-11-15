package by.academy.home_work.HW_2__arrays_circls_strings;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String taskNumber;
        System.out.println("Введите номер задания от 1 до 5, для выхода что-нибудь еще");
        taskNumber = Main.scanS();
        do {

            switch (taskNumber) {
                case "1":
                    do {
                        System.out.println("Задание №1. Определить количество пар в массиве, " +
                                "разность которых равна заданному значению");
                        by.academy.home_work.HW_1__operators.Task_5.getArrNunber();
                        by.academy.home_work.HW_1__operators.Task_5.getArray();
                        System.out.println("Для повторного запуска этого задания введите 1, " +
                                "для выбора другого задания его номер, для выхода что-нибудь еще");
                        taskNumber = Main.scanS();
                        System.out.println();
                    } while (taskNumber.equals("1"));
                    break;

                case "2":
                    do {
                        System.out.println("Задание №2. Определить, является ли одна строка перестановкой символов другой");
                        Task_2.getStrings();
                        Task_2.compareStrings();
                        System.out.println("Для повторного запуска этого задания введите 2, " +
                                "для выбора другого задания его номер, для выхода что-нибудь еще");
                        taskNumber = Main.scanS();
                    } while (taskNumber.equals("2"));
                    break;
                case "3":
                    do {
                        System.out.println("Задание №3. Найти первое слово, в котором число различных символов минимально");
                        Task_3.getWords();
                        Task_3.setMinWord();
                        System.out.println("Для повторного запуска этого задания введите 3, " +
                                "для выбора другого задания его номер, для выхода что-нибудь еще");
                        taskNumber = Main.scanS();
                    } while (taskNumber.equals("3"));
                    break;

                case "4":
                    do {
                        System.out.println("Задание №4. Получить слово состоящее из первой половины первого слова " +
                                "и второй половины второго слова");
                        by.academy.home_work.HW_1__operators.Task_4 task_4 = new by.academy.home_work.HW_1__operators.Task_4();
                        Task_4.getWords();
                        Task_4.setWordResult();
                        System.out.println("Для повторного запуска этого задания введите 4, " +
                                "для выбора другого задания его номер, для выхода что-нибудь еще");
                        taskNumber = Main.scanS();
                    } while (taskNumber.equals("4"));
                    break;

                case "5":
                    do {
                        System.out.println("Задание №5. Раздача карт для игры в покер");
                        Task_5.getPlayers();
                        Task_5.setCards();
                        System.out.println("Для повторного запуска этого задания введите 5, " +
                                "для выбора другого задания его номер, для что-нибудь еще");
                        taskNumber = Main.scanS();
                    } while (taskNumber.equals("5"));
                    break;
                default:
                    System.out.println("Пока");
                    break;
            }

        } while (taskNumber.matches("[1-5]{1}"));
        closeScan();
    }

    public static String scanL(){
        Scanner scan = new Scanner(System.in);
        String l = scan.nextLine();
        return l;
    }
    public static String scanS(){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        return s;
    }

    public static void closeScan(){
        Scanner scan = new Scanner("");
        scan.close();
    }


}

