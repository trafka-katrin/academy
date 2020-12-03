package by.academy.home_work.HW_3__deal;

import by.academy.home_work.HW_3__deal.builders.Builder;
import by.academy.home_work.HW_3__deal.builders.Person_builder;


public class Person {

    private Integer personId;
    private String personName;
    private Double personMoney;
    private String dateOfBirth;
    private String phone;
    private String email;

    public Person (String namePerson){
        this.personName = namePerson;
        this.personId = Builder.getFirstFreeArItem(Person_builder.getArPersons());
    }


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Double getPersonMoney() {
        return personMoney;
    }

    public void setPersonMoney(Double personMoney) {
        this.personMoney = personMoney;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

