package by.academy.test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)  {




        String oldDateS = "12/12/2020";
        SimpleDateFormat oldDate1;
        if (oldDateS.matches("[\\d]{2}-[\\d]{2}-[\\d]{4}")){
             oldDate1 = new SimpleDateFormat("dd-MM-yyyy");
        } else {
             oldDate1 = new SimpleDateFormat("dd/MM/yyyy");
        }

        SimpleDateFormat dayF = new SimpleDateFormat("dd");
        SimpleDateFormat monthF = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        Date newDate = oldDate1.parse(oldDateS, new ParsePosition(0));

        System.out.println("Дата сделки \nДень: " +dayF.format(newDate) + " \nМесяц: " + monthF.format(newDate) + " \nГод: " + year.format(newDate));

        }




}
