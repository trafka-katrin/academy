package by.academy.home_work.HW_4__inner_class_generics.task_1;

import java.text.SimpleDateFormat;


public class App {
    public static void main(String[] args) {
        System.out.println("День недели по дате");
        DateX dateX = new DateX(DateX.getStringDate("date"));
        dateX.getDayOfTheWeek(dateX.getStrDate());

        System.out.println("Временной промежуток");
        dateX.getDaysRange();

        System.out.println("Високосный год");
        DateX dateX1 = new DateX(DateX.getStringDate("year"));
        dateX1.new YearX(dateX1.getStrDate()).isLeapYear();

        System.out.println("Конструктор с внутренними классами");
        DateX dateX2 = new DateX();

    }


    }

