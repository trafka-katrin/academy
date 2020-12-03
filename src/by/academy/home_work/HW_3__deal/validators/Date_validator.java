package by.academy.home_work.HW_3__deal.validators;

import by.academy.home_work.HW_3__deal.Main;
import by.academy.home_work.HW_3__deal.builders.Builder;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date_validator {
    boolean b = false;
    private String date;

    public static String validateDate() {
        boolean b = false;
        String date;
        Pattern datePattern = Pattern.compile(
                "^(0(?=[1-9])|1|2|3(?=[01]))\\d" +
                        "(\\/(?!\\d{2}-)|-(?!\\d{2}\\/))" +
                        "(0(?=[1-9])|1(?=[012]))\\d[/-]" +
                        "(1(?=9)|2(?=0))[90][\\d]{2}$");

        do {
            date = Builder.scanNextLine();
            Matcher matcher = datePattern.matcher(date);
            if (matcher.matches()) {
                b = true;
            } else {
                System.out.println("Дата введена в неверном формате, повторите ввод");
            }
        } while (!b);

        return date;
    }

    public static void parceDate(String date){
        SimpleDateFormat oldDate;

        if (date.matches("[\\d]{2}-[\\d]{2}-[\\d]{4}")){
            oldDate = new SimpleDateFormat("dd-MM-yyyy");
        } else {
            oldDate = new SimpleDateFormat("dd/MM/yyyy");
        }

        SimpleDateFormat dayF = new SimpleDateFormat("dd");
        SimpleDateFormat monthF = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");

        Date newDate = oldDate.parse(date, new ParsePosition(0));

        System.out.println("Дата сделки \nДень: " +dayF.format(newDate) + " \nМесяц: " +
                monthF.format(newDate) + " \nГод: " + year.format(newDate));
    }


}
