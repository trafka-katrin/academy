package by.academy.home_work.HW_deal;

public class Person {
    static String arPersons [][] = new String[100][3];
    static String arPersonsStub [][] = {
                        {"PERSON_ID","PERSON_NAME","PERSON_MONEY"},
                        {"1","Паца-Ваца"," 50"},
                        {"2","Десантник Степочкин","100"}};
    private Integer personId;
    private String personName;
    private Double personMoney;

    public Person (String namePerson){
        this.personName = namePerson;
        this.personId = Main.getFirstFreeArItem(arPersons);
    }

    public void setPersonMoney(double personMoney) {
        this.personMoney = personMoney;
    }

    static void setPersonsDataToAr(Integer personId, String personName, String personMoney){
        arPersons[personId][0] = personId.toString();
        arPersons[personId][1] = personName;
        arPersons[personId][2] = personMoney;

    }

    public static Integer createPerson(){
        System.out.println("Введите имя клиента");
        Person personX = new Person(Main.scanNextLine());

        System.out.println("Введите количество денег клиента");
        personX.setPersonMoney(Double.parseDouble(Main.scanNext()));

        setPersonsDataToAr(Main.getFirstFreeArItem(arPersons), personX.personName, personX.personMoney.toString());

        Integer personId = Main.getFirstFreeArItem(arPersons);

        return personId-1;

    }

    static void updatePersonMoney (Integer id, Double summ){
        Double prevPersonMoney = Double.parseDouble(arPersons [id][2]);
        Double postPersonMoney = prevPersonMoney - summ;
        arPersons [id][2] = postPersonMoney.toString();

    }

}

