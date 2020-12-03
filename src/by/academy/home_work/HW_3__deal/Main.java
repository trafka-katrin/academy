package by.academy.home_work.HW_3__deal;

import by.academy.home_work.HW_3__deal.builders.Builder;
import by.academy.home_work.HW_3__deal.builders.Deal_builder;
import by.academy.home_work.HW_3__deal.builders.Good_builder;
import by.academy.home_work.HW_3__deal.builders.Person_builder;
import by.academy.home_work.HW_3__deal.validators.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static class EmailValidator implements Validator {

        public Boolean validate(String email){
            Boolean chekEmail = false;
            Pattern emailPattern = Pattern.compile(
                            "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+" +
                            "(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*" +
                            "@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
                            "(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|" +
                            "name|net|org|pro|tel|travel|[a-z][a-z])$");
            Matcher matcherEmail = emailPattern.matcher(email);
            if(matcherEmail.matches()){
                chekEmail = true;
            } else {}
            return chekEmail;

        }

    }

    public static void main(String[] args) {
        String menuItemI;
        String menuItemJ;

        Builder.fillInAr(Deal_builder.getArDeals(), Deal_builder.getArDealsStub());
        Builder.fillInAr(Deal_builder.getArDealGoods(), Deal_builder.getArDealGoodsStub());
        Builder.fillInAr(Person_builder.getArPersons(), Person_builder.getArPersonsStub());
        Builder.fillInAr(Good_builder.getArGoods(),Good_builder.getArGoodsStub());

        do {
            System.out.println(
                                "▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼\n"+
                                "ГЛАВНОЕ МЕНЮ \n" +
                                "▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲\n"+
                                "▶ Для создания новой сделки введите \"1\"    " +
                                "▶ Для просмотра информации по сделкам введите \"2\"    " +
                                "▶ Для просмотра данных массивов введите \"3\".");
            menuItemI = Builder.scanNext();

            switch (menuItemI){
                case "1": Deal_builder.createDeal();
                    break;

                case "2":
                    String memuItem2;
                    do {
                        System.out.println ("▶ Для просмотра информации о сделке введите ее ID   " +
                                            "▶ Для просмотра всех сделок введите \"0\"   " +
                                            "▶ Для выхода из меню введите другой символ");
                        memuItem2 = Builder.scanNext();
                        if (memuItem2.matches("[1-9]\\d*")){
                            Deal_builder.showDealInfo(Integer.parseInt(memuItem2));
                        } else if (memuItem2.matches("0")){
                            Integer countDeals = Builder.getFirstFreeArItem(Deal_builder.getArDeals());
                            for(int i = 1; i < countDeals; i++){
                                Deal_builder.showDealInfo(i);
                            }
                        }else {}

                    }while (memuItem2.matches("(0(?=)|[1-9])\\d*"));

                    break;

                case "3":

                    do{
                        System.out.println("Выберите массив: " +
                                            "1 - Сделки, 2 - Клиенты, 3 - Товары, 4 - Связи сделок с товарами");
                        menuItemJ = Builder.scanNext();

                        switch (menuItemJ) {
                            case "1": Builder.showAr(Deal_builder.getArDeals(), "10");
                                break;

                            case "2": Builder.showAr(Person_builder.getArPersons(), "10");
                                break;

                            case "3": Builder.showAr(Good_builder.getArGoods(), "10");
                                break;

                            case "4": Builder.showAr(Deal_builder.getArDeals(), "10");
                                break;

                            default: break;
                        }
                    } while (menuItemJ.matches("[1-4]{1}"));

                    break;

                default: break;
            }
        } while (menuItemI.matches("[1-3]{1}"));

    }

    public static String validateEmail(){
        Boolean isEmailValid = false;
        String email;
        EmailValidator eV = new EmailValidator();

        do {
            email = Builder.scanNextLine();
            isEmailValid = eV.validate(email);

            if (!isEmailValid){
                System.out.println("Email введен в неверном формате, повторите ввод");
            } else {}

        } while (!isEmailValid);

        return email;
    }


}
