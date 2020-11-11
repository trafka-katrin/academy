package by.academy._2_arrays_circls_strings_HW;

import java.util.Scanner;

public class Task_4 {
    static private String word1;
    static private String word2;
    static private String wordResult;
    public static void getWords(){
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите 2 слова с четным числом букв");
            word1 = scan.next();
            word2 = scan.next();
            if (word1.length()<2 || word2.length()<2) {
                System.out.println("Слова не должны быть меньше 2 букв");
            }
        } while (word1.length()<2 || word2.length()<2);

        if (word1.length()%2>0){
            word1 = word1.substring(0,word1.length()-1);
            System.out.println("В первом слове было нечетное число букв, одну пришлось ампутировать");
        } else {}
        if (word2.length()%2>0){
            word2 = word2.substring(0,word2.length()-1);
            System.out.println("Во втором слове было нечетное число букв, одну пришлось ампутировать");
        } else {}
        System.out.println("Получено 2 слова: " + word1 + " и " + word2);
    }
    public static void setWordResult(){
        wordResult = word1.substring(0,word1.length()/2) + word2.substring(word2.length()/2);
        System.out.println("Из двух слов получилось это - " + wordResult);
    }
}
