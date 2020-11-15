package by.academy.home_work.HW_deal;

public class Person {
    private Integer personId;
    private String personName;
    private Double personMoney;
    private static String arPersons [][] = new String[100][7];
    private static String arPersonsStub [][] = {
            {"PERSON_ID","PERSON_NAME","PERSON_MONEY"},
            {"0","Ivanov"," 50"},
            {"1","Petrov","100"}
    };

    public Person (){
        this.personName = "John Doe";
        this.personMoney = 0.0;
    }

    public Person (String namePerson){
        this.personName = namePerson;
        this.personId = getFirstFreeArPersonsId();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getPersonMoney() {
        return personMoney;
    }

    public void setPersonMoney(double personMoney) {
        this.personMoney = personMoney;
    }

    public void chooseGoodForSale (){

    }

    static void fillInArPersons(){
        for (int i = 0; i< arPersonsStub.length; i++){
            for (int j = 0; j< 3; j++){
                arPersons[i][j] = arPersonsStub[i][j];
            }
        }

    }

    private static Integer getFirstFreeArPersonsId(){
        Integer n = null;
        for (int i = 0; i< arPersons.length; i++){
            if (arPersons[i][0]==null){
                n = i;
                break;
            }
        }
        return n;
    }

    private static void setPersonsDataToAr(Integer personId, String personName, String personMoney){
        Integer arPersonNum = (personId - 1);
        arPersons[personId][0] = arPersonNum.toString();
        arPersons[personId][1] = personName;
        arPersons[personId][2] = personMoney;
    }

    public static void showArPersons(){
        // Проверка содержимого массива
        for (int i = 0; i< 5; i++){
            for (int j = 0; j< 3; j++){
                System.out.print(arPersons [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }

    public static void createPerson(){
        System.out.println("Введите имя");

        Person personX = new Person(Main.scanNextLine());

        System.out.println("Введите количество денег клиента");

        personX.setPersonMoney(Double.parseDouble(Main.scanNext()));

        System.out.println(personX.personName  + personX.personId + personX.getPersonMoney());

        Person.setPersonsDataToAr(Person.getFirstFreeArPersonsId(), personX.personName, personX.personMoney.toString());

        Person.showArPersons();


    }



}

