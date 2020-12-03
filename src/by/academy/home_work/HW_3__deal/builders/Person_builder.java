package by.academy.home_work.HW_3__deal.builders;

import by.academy.home_work.HW_3__deal.Main;
import by.academy.home_work.HW_3__deal.Person;
import by.academy.home_work.HW_3__deal.validators.BelarusPhoneValidator;
import by.academy.home_work.HW_3__deal.validators.Date_validator;

public class Person_builder extends Builder{

    private static String arPersonsStub [][] = {
            {"PERSON_ID","PERSON_NAME","PERSON_MONEY","DATE_OF_BIRTH","PHONE","EMAIL"},
            {"1","Паца-Ваца"," 50","12-12-2000","+375291112233","paca@vaca.com"},
            {"2","Десантник Степочкин","100","22-11-1990","+375294445566","d.stepochkin@gmail.com"}};
    private static String[][] arPersons = new String[100][arPersonsStub[0].length];

    public static String[][] getArPersonsStub() {
        return arPersonsStub;
    }

    public static String[][] getArPersons() {
        return arPersons;
    }

    static void setPersonsDataToAr(Integer personId, String personName, String personMoney, String personDayOfBirth,
                                   String phone, String email){
        arPersons[personId][0] = personId.toString();
        arPersons[personId][1] = personName;
        arPersons[personId][2] = personMoney;
        arPersons[personId][3] = personDayOfBirth;
        arPersons[personId][4] = phone;
        arPersons[personId][5] = email;

    }

    public static Integer createPerson(){
        System.out.println("Введите имя клиента");
        Person personX = new Person(Builder.scanNextLine());

        System.out.println("Введите количество денег клиента");
        personX.setPersonMoney(Double.parseDouble(Builder.scanNext()));

        System.out.println("Введите дату рождения клиента в формате dd/MM/yyyy или dd-ММ-yyyy");
        personX.setDateOfBirth(Date_validator.validateDate());

        System.out.println("Введите телефон в формате \"+375...\"");
        Boolean isValidPhone = false;

        do {
            BelarusPhoneValidator vBphone = new BelarusPhoneValidator();
            personX.setPhone(Builder.scanNextLine());
            isValidPhone = vBphone.validate(personX.getPhone());
            if (!isValidPhone){
                System.out.println("Номер введен в неверном формате, повторите ввод");
            } else {}

        } while (!isValidPhone);

        System.out.println("Введите email");

        personX.setEmail(Main.validateEmail());

        arPersons = Builder.chekArLength(arPersons);

        setPersonsDataToAr(Builder.getFirstFreeArItem(arPersons), personX.getPersonName(),
                personX.getPersonMoney().toString(), personX.getDateOfBirth(), personX.getPhone(), personX.getEmail());

        Integer personId = Builder.getFirstFreeArItem(arPersons);

        System.out.println("Создан новый клиент ");
        Builder.showArItem(arPersons, Builder.getFirstFreeArItem(arPersons)-1);

        return personId-1;

    }

    public static void updatePersonMoney(Integer id, Double summ){
        Double prevPersonMoney = Double.parseDouble(arPersons [id][2]);
        Double postPersonMoney = prevPersonMoney - summ;
        arPersons [id][2] = postPersonMoney.toString();

    }
}
