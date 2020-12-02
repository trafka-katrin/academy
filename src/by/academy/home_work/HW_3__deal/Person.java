package by.academy.home_work.HW_3__deal;

import by.academy.home_work.HW_3__deal.validators.BelarusPhoneValidator;
import by.academy.home_work.HW_3__deal.validators.Date_validator;

public class Person {

    static String arPersonsStub [][] = {
                        {"PERSON_ID","PERSON_NAME","PERSON_MONEY","DATE_OF_BIRTH","PHONE","EMAIL"},
                        {"1","Паца-Ваца"," 50","12-12-2000","+375291112233","paca@vaca.com"},
                        {"2","Десантник Степочкин","100","22-11-1990","+375294445566","d.stepochkin@gmail.com"}};
    static String arPersons [][] = new String[3][arPersonsStub[0].length];
    private Integer personId;
    private String personName;
    private Double personMoney;
    private String dateOfBirth;
    private String phone;
    private String email;

    public Person (String namePerson){
        this.personName = namePerson;
        this.personId = Main.getFirstFreeArItem(arPersons);
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
        Person personX = new Person(Main.scanNextLine());

        System.out.println("Введите количество денег клиента");
        personX.personMoney = Double.parseDouble(Main.scanNext());

        System.out.println("Введите дату рождения клиента в формате dd/MM/yyyy или dd-ММ-yyyy");
        personX.dateOfBirth = Date_validator.validateDate();

        System.out.println("Введите телефон в формате \"+375...\"");
        Boolean isValidPhone = false;

        do {
            BelarusPhoneValidator vBphone = new BelarusPhoneValidator();
            personX.phone = Main.scanNextLine();
            isValidPhone = vBphone.validate(personX.phone);
            if (!isValidPhone){
                System.out.println("Номер введен в неверном формате, повторите ввод");
            } else {}

        } while (!isValidPhone);

        System.out.println("Введите email");

        personX.email = Main.validateEmail();

        arPersons = Main.chekArLength(arPersons);
        System.out.println(arPersons.length);
        Integer n = arPersons.length;
        System.out.println(Main.getFirstFreeArItem(arPersons));
        Main.showAr(arPersons, Main.getFirstFreeArItem(arPersons).toString());


        setPersonsDataToAr(Main.getFirstFreeArItem(arPersons), personX.personName,
                            personX.personMoney.toString(), personX.dateOfBirth, personX.phone, personX.email);

        Integer personId = Main.getFirstFreeArItem(arPersons);

        System.out.println("Создан новый клиент ");
        Main.showArItem(arPersons, Main.getFirstFreeArItem(arPersons)-1);

        return personId-1;

    }

    static void updatePersonMoney (Integer id, Double summ){
        Double prevPersonMoney = Double.parseDouble(arPersons [id][2]);
        Double postPersonMoney = prevPersonMoney - summ;
        arPersons [id][2] = postPersonMoney.toString();

    }

}

