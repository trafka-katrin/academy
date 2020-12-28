package by.academy.home_work.HW_6_fils;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String surname;
    Integer age;

    public User(String name, String surname, Integer age){
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }


}
