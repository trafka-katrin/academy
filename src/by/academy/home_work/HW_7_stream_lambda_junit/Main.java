package by.academy.home_work.HW_7_stream_lambda_junit;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //TASK1
        System.out.println("TASK 1");

        List<Long> listLong = new Random().longs(100, 1, 100).
                                map(x -> (long) (x * Math.PI - 20)).filter(x -> x < 100).sorted().skip(3).
                                distinct().boxed().
                                collect(Collectors.toList());

        Map<Long, String> mapLongString = listLong.stream().collect(Collectors.toMap(x -> x, value -> "Number: " + value));

        System.out.println(mapLongString);

        //TASK 2
        System.out.println("\nTASK 2");

        Class<User> userClass = User.class;
        User userX = new User("OLOLO", "qwe123", "ololo@gmail.com");

        System.out.println("----- getMethod:  user.printUserInfo(String,String){},  user.getEmail(){},  person.getAge(){}," +
                "object.toString(){}");
        try {
            Method met = userClass.getMethod("printUserInfo", String.class, String.class);
            Method met1 = userClass.getMethod("getEmail");
            Method met2 = userClass.getMethod("getAge");
            Method met3 = userClass.getMethod("toString");
            System.out.println(met.getName() + ", " + met1.getName()+ ", " + met2.getName()+ ", " + met3.getName());
        } catch (NoSuchMethodException | SecurityException e1) {
            System.out.println("В классе User нет такого public метода");
        }

        System.out.println("\n----- getMethods: all");
        Method[] userMethods = userClass.getMethods();
        for (Method m : userMethods) {
            System.out.println(m.getName());
        }

        System.out.println("\n----- getField: user.public login,  person.public firstName, user.protected password");
        try {
            Field field = userClass.getField("login");
            System.out.println(field.getName());
            Field field1 = userClass.getField("firstName");
            System.out.println(field1.getName());
            Field field2 = userClass.getField("password");
            System.out.println(field2.getName());
        } catch (SecurityException | NoSuchFieldException e1) {
            System.out.println("В классе User нет такого public поля");
        }

        System.out.println("\n----- getFields: all");
        Field[] userFields = userClass.getFields();
        for (Field f : userFields) {
            System.out.println(f.getName());
        }

        System.out.println("\n----- getDeclaredMethod:  user.printUserInfo(String,String){},  user.getEmail(){},  person.getAge(){}");
        try {
            Method met = userClass.getDeclaredMethod("printUserInfo", String.class, String.class);
            System.out.println(met.getName());
            Method met1 = userClass.getDeclaredMethod("getEmail");
            System.out.println(met1.getName());
            Method met2 = userClass.getDeclaredMethod("getAge");
            System.out.println(met2.getName());
        } catch (NoSuchMethodException | SecurityException e1) {
            System.out.println("В классе User нет такого public метода");
        }

        System.out.println("\n----- getDeclaredMethods: all");
        Method[] userDeclaredMethods = userClass.getDeclaredMethods();
        for (Method m : userDeclaredMethods) {
            System.out.println(m.getName());
        }

        System.out.println("\n----- getDeclaredField: user.public login,  user.privat email,  person.public firstName, ");
        try {
            Field field = userClass.getDeclaredField("login");
            System.out.println(field.getName());
            Field field2 = userClass.getDeclaredField("email");
            System.out.println(field2.getName());
            Field field1 = userClass.getDeclaredField("firstName");
            System.out.println(field1.getName());

        } catch (SecurityException | NoSuchFieldException e1) {
            System.out.println("В классе User нет такого public поля");
        }

        System.out.println("\n----- getDeclaredFields: all");
        Field[] userDeclaredFields = userClass.getDeclaredFields();
        for (Field f : userDeclaredFields) {
            System.out.println(f.getName());
        }


        System.out.println("\n----- setField: user.public login");
        try {
            Field loginValue = userClass.getDeclaredField("login");
            loginValue.setAccessible(true);
            loginValue.set(userX, "John");
            String newLoginValue = (String) loginValue.get(userX);
            System.out.println("Установлено значение поля login: " + newLoginValue);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\n----- setField: user.privat email");
        try {
            Field emailValue = userClass.getDeclaredField("email");
            emailValue.setAccessible(true);
            emailValue.set(userX, "email@gmail.com");
            String newEmailValue = (String) emailValue.get(userX);
            System.out.println("Установлено значение поля email: " + newEmailValue);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\n----- setField: user.protected password");
        try {
            Field passwordValue = userClass.getDeclaredField("password");
            passwordValue.setAccessible(true);
            passwordValue.set(userX, "123qwe.");
            String newPasswordValue = (String) passwordValue.get(userX);
            System.out.println("Установлено значение поля password: " + newPasswordValue);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("\n----- setField invoke: object.toString");

        try {
            Method metInv = userClass.getMethod("toString");
            System.out.println(metInv.invoke(userX));
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

/*        System.out.println("\n----- setField invoke: user.printUserInfo");
        try {
            Method metInv = userClass.getDeclaredMethod("printUserInfo", String.class,  String.class);
            metInv.invoke(userX, "ква1", "ква2");
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }*/





    }
}
