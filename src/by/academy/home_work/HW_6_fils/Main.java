package by.academy.home_work.HW_6_fils;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //TASK 1-------------------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку которая может содержать \"stop\"");
        String s = scanner.nextLine();
        char s1[] = s.toCharArray();
        Integer sLen = s.length();

        if (s.contains("stop")){
            sLen = s.indexOf("stop");
        } else {}

        try (PrintWriter out = new PrintWriter
                ( new BufferedWriter(
                        new FileWriter(
                            "src/by/academy/home_work/HW_6_fils/text1_for_task1.txt",true)))){

                for (int i = 0; i < sLen; i++) {
                    out.write(s1[i]);
                }

        } catch (IOException ex){

            System.out.println(ex.getMessage());

        } finally {

            scanner.close();

        }

        //TASK 2-------------------------------------------------------------------------

        List charList  = new ArrayList();

        try (BufferedReader reader = new BufferedReader(
                        new FileReader(
                                "src/by/academy/home_work/HW_6_fils/text1_for_task2.txt"))){

            int charN = reader.read();

            while (charN != -1 ){
                charList.add((char) charN);
                charN = reader.read();
            }

        } catch (IOException ex){

            System.out.println(ex.getMessage());

        }

        try (PrintWriter out = new PrintWriter
                ( new BufferedWriter(
                        new FileWriter(
                                "src/by/academy/home_work/HW_6_fils/text2_for_task2_result.txt",true)))){

            Iterator it = charList.iterator();
            Character charM;

            while (it.hasNext()) {
                charM = (Character) it.next();

                if(charM.equals(' ')){
                    continue;
                } else {
                    out.write(charM);
                }

            }
        } catch (IOException ex){

            System.out.println(ex.getMessage());

        }

        //TASK 3-------------------------------------------------------------------------

        List user = new ArrayList();
        user.add(new User("Gena","Krokodil", 34 ));
        user.add(new User("Daenerys","Targaryen", 26 ));
        user.add(new User("Harry","Potter", 16 ));
        user.add(new User("Darth","Vader", 33 ));
        user.add(new User("Karl","Marks", 54 ));
        user.add(new User("Sara","Conor", 42 ));
        user.add(new User("Naruto","Uzumaki", 17 ));
        user.add(new User("Radion","Raskolnikov", 28 ));
        user.add(new User("Koschey","Bessmetrtnyy", 1500 ));
        user.add(new User("James","Bond", 38 ));

        File newUserDir = new File("src/by/academy/home_work/HW_6_fils/users/");

        if (!newUserDir.exists()) {

            try {

                newUserDir.mkdir();

            } catch (SecurityException e) {

                e.printStackTrace();
            }

        } else {

            System.out.println("Директория с таким именем уже существует");

        }

        Iterator it = user.iterator();

        while (it.hasNext()){

            User temp = (User) it.next();
            String name = temp.getName();
            String surname = temp.getSurname();
            String path = newUserDir+ "/" + name + "_"+ surname + ".txt";
            File newFile = new File(path);

            if (!newFile.exists()) {

                try {

                    newFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(path);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject((temp.getName() + " " + temp.surname + " " + temp.getAge()));
                    FileInputStream fis = new FileInputStream(path);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    System.out.println(ois.readObject());

                } catch (IOException | ClassNotFoundException e) {

                    e.printStackTrace();
                }

            } else {

                System.out.println("Файл с таким именем уже существует");

            }

        }

        //TASK 4-------------------------------------------------------------------------

        Integer textLen = charList.size();
        File newXFilsDir = new File("src/by/academy/home_work/HW_6_fils/xFils/");

        if (!newXFilsDir.exists()) {

            try {

                newXFilsDir.mkdir();

            } catch (SecurityException e) {

                e.printStackTrace();

            }

        } else {

            System.out.println("Директория с таким именем уже существует");

        }

        String pathR = newXFilsDir+ "/" + "result.txt";
        File fileRes = new File(pathR);

        if (!fileRes.exists()) {

            try {

                fileRes.createNewFile();

            } catch (IOException e){

                e.getMessage();

            }

        } else {

                System.out.println("Файл result.txt уже существует");

            }

        for (int i = 0; i < 100; i++){

            String path = newXFilsDir+ "/" + i + ".txt";
            File newFile = new File(path);
            Integer randomNumber = (int)(Math.random() * textLen);

            if (!newFile.exists()) {

                try {

                    newFile.createNewFile();
                    BufferedReader reader2 = new BufferedReader(
                            new FileReader(
                                "src/by/academy/home_work/HW_6_fils/text1_for_task2.txt"));
                    StringBuffer str = new StringBuffer();
                    int charN = reader2.read();

                            for (int j = 0; j < randomNumber; j++) {
                                str.append((char) charN);
                                charN = reader2.read();
                            }

                    try (PrintWriter outFile = new PrintWriter
                            ( new BufferedWriter(
                                    new FileWriter(path)))) {

                        for (int k = 0; k < randomNumber; k++) {

                            outFile.write(str.charAt(k));
                        }

                    } catch (IOException e){

                        e.getMessage();

                    }

                    try (PrintWriter outResult = new PrintWriter
                            ( new BufferedWriter(
                                    new FileWriter(pathR,true)))) {

                            outResult.write(i + ".txt - " + randomNumber + " chars \n");

                    } catch (IOException e){

                        e.getMessage();
                    }


                } catch (IOException e) {

                    e.getMessage();

                }
            }

        }


    }


}
