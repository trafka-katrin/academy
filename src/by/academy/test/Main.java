package by.academy.test;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public  static LocalTime deadline = LocalTime.now();
    public static LocalDateTime date = LocalDateTime.now();
    public static LocalDateTime date2;

    public static void main(String[] args) {


        System.out.println(deadline);
        System.out.println(date);
        date2 = LocalDateTime.now().plus(Period.ofDays(10));

        System.out.println(date2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));


/*            String phoneNum = "31-09-2020";
            Boolean chekPhone = false;
            if(phoneNum.matches(
                                "^(0(?=[1-9])|1|2|3(?=[01]))\\d" +
                                        "(\\/(?!\\d{2}-)|-(?!\\d{2}\\/))" +
                                        "(0(?=[1-9])|1(?=[012]))\\d[/-]" +
                                        "20[\\d]{2}$"
            )){
                chekPhone = true;
            }
        System.out.println(chekPhone);*/



    }
}
