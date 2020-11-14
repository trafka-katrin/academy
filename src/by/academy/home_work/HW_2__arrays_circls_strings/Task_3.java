package by.academy.home_work.HW_2__arrays_circls_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3 {
    static private String s;

    public static void getWords() {
        boolean chekMinNumWords = true;
        do {
            System.out.println("Введите строку из нескольких слов разделенных пробелами");
            s = Main.scanL();
            Pattern p = Pattern.compile("\\S+\\s+\\S+");
            Matcher inS = p.matcher(s);
            chekMinNumWords = inS.find();
            if(!chekMinNumWords){
                System.out.println("Должно быть не меньше двух слов");
            }
        } while (!chekMinNumWords);
    }

    public static void setMinWord() {
        String minWord = s.substring(0, s.indexOf(" "));
        int minUniqWordLen = minWord.length();

        String arW[] = s.split("[\\s]+");

        for (int i = 0; i < arW.length; i++) {

            char arS[] = arW[i].toCharArray();
            int arCountLet[] = new int[5000];
            int countUniqLet = 0;

            for (int n : arS) {
                arCountLet[n]++;
            }

            for (int m : arCountLet) {
                if (m > 0) {
                    countUniqLet++;
                }
            }

            if (countUniqLet < minUniqWordLen) {
                minWord = arW[i];
                minUniqWordLen = countUniqLet;
            }
        }

        System.out.println("Первое слово с минимальным числом уникальных символов - \"" + minWord + "\"");

    }
}
