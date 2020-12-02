package by.academy.home_work.HW_4__inner_class_generics.task_1;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateX {
    private String strDate;
    private String strDate1;
    private String strDate2;
    private static Pattern datePattern = Pattern.compile(
                                                "^(0(?=[1-9])|1|2|3(?=[01]))\\d-" +
                                                "(0(?=[1-9])|1(?=[012]))\\d-" +
                                                "(1(?=9)|2(?=0))[90][\\d]{2}$");
    private static Pattern yearPattern = Pattern.compile("^(1(?=9)|2(?=0))[90][\\d]{2}$");
    private static Pattern monthPattern = Pattern.compile("^(0(?=[1-9])|1(?=[012]))\\d$");
    private static Pattern dayPattern = Pattern.compile("^(0(?=[1-9])|1|2|3(?=[01]))\\d$");

    public DateX(){
        YearX yearX = new YearX();
        MonthX monthX = new MonthX();
        DayX dayX = new DayX();
        strDate = dayX.day + "-" + monthX.month + "-" + yearX.year;
        System.out.println(strDate);

    }

    public DateX(String strDate) {
        this.strDate = strDate;
    }

    public String getStrDate() {
        return strDate;
    }

    class YearX {
        String year;
        YearX(){
            this.year = getStringDate("year");
        }
        YearX(String year){
            this.year = year;
        }
        public void isLeapYear(){
            System.out.println(Year.isLeap(Long.parseLong(year)));

        }

    }

    class MonthX {
        String month;
        MonthX(){
            this.month = getStringDate("month");
        }

    }

    class DayX {
        String day;
        DayX(){
            this.day = getStringDate("day");
        }

    }

    public static String getStringDate(String type){
        String text = "";
        String strDate;
        Pattern pattern = datePattern;
        Boolean isStringMatchesPattern = false;
        switch (type){
            case "date":
                text = "Введите дату в формате dd-ММ-yyyy ";
                pattern = datePattern;
                break;
            case "year":
                text = "Введите год в формате yyyy ";
                pattern = yearPattern;
                break;
            case "month":
                text = "Введите месяц в формате MM ";
                pattern = monthPattern;
                break;
            case "day":
                text = "Введите день в формате dd ";
                pattern = dayPattern;
                break;
        }

        do {
            System.out.println(text);
            Scanner scan = new Scanner(System.in);
            strDate = scan.next();
            Matcher matcher = pattern.matcher(strDate);

            if (matcher.matches()) {
                isStringMatchesPattern = true;
            } else {
                System.out.println("Данные введены в неверном формате, повторите ввод");
            }

        } while (!isStringMatchesPattern);

        return strDate;
    }

    public void getDayOfTheWeek(String date){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(date,new ParsePosition(0)));
        Integer dayOfWeekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeekS = DaysOfWeek.values()[dayOfWeekNumber -1].text;
        System.out.println( date +  " День недели - " + dayOfWeekS);

    }

    public void getDaysRange (){
        strDate1 = getStringDate("date");
        strDate2 = getStringDate("date");
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(strDate1,new ParsePosition(0)));
        cal2.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(strDate2,new ParsePosition(0)));
        System.out.println("Количество дней между датами " +
                            Math.abs((cal1.getTime().getTime() - cal2.getTime().getTime()) / (1000 * 60 * 60 * 24)));

    }


    enum DaysOfWeek{
        SUNDAY("воскресенье"),
        MONDAY("понедельник"),
        TUESDAY("вторник"),
        WEDNESDAY("среда"),
        THURSDAY("четверг"),
        FRIDAY("пятница"),
        SATURDAY("суббота");

        private String text;

        DaysOfWeek(String text) {
            this.text = text;

        }
    }


}
