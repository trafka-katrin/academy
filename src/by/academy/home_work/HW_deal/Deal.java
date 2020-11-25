package by.academy.home_work.HW_deal;

import by.academy.home_work.HW_deal.goods.Good;
import by.academy.home_work.HW_deal.goods.Sale_in_lots;
import by.academy.home_work.HW_deal.validators.Date_validator;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Deal {
    public static String arDealGoodsIDTemp[][] = new String[100][13];
    public static String arDealGoodsIdTempStub[][] = {
            {"GOOD_ID", "GOODS_COUNT", "GOOD_TYPE", "GOOD_MODEL", "SALE_TYPE", "PRICE", "GOOD_LOT_SIZE",
            "TARA_DATA", "TARA_PRICE", "GOODS_PRICE", "DISCOUNT", "SALE_PRICE", "DEAL_ID"}};
    public static String arDealGoods[][] = new String[100][13];
    static String arDealGoodsStub[][] = {
            {"GOOD_ID", "GOODS_COUNT", "GOOD_TYPE", "GOOD_MODEL", "SALE_TYPE","PRICE", "GOOD_LOT_SIZE",
            "TARA_DATA", "TARA_PRICE", "GOODS_PRICE", "DISCOUNT", "SALE_PRICE","DEAL_ID"},
            {"2","2","1","2","2","1","2","2","1","2","2","1","1"},
            {"2","2","1","2","2","1","2","2","1","2","2","1","1"},
            {"2","2","1","2","2","1","2","2","1","2","2","1","1"}};
    static String arDeals [][] = new String[100][7];
    static String arDealsStub [][] = {
            {"DEAL_ID","DEAL_DATE","SELLER_ID","BUYER_ID","DEADLINE","DEAL_SUMM","DEAL_RESULT"},
            {"1","01.01.2020","2","1","0","40.00","true"},
            {"2","02.02.2020","1","2","1","130.00","false"}};
    private String dealDate;
    private Integer sellerId;
    private Integer buyerId;
    private Double dealSumm;
    private Boolean dealResult;
    private Date dealDeadline;

    public Deal (){
    }

    public static String[][] getArDealGoods() {
        return arDealGoods;
    }

    public static void createDeal(){
        System.out.println("СОЗДАНИЕ НОВОЙ СДЕЛКИ");
        Deal dealX = new Deal();

        System.out.println("Введите дату сделки в формате dd/MM/yyyy или dd-ММ-yyyy ");
        dealX.dealDate = Date_validator.validateDate();
        Date_validator.parceDate(dealX.dealDate);

        System.out.println("1.0. ДАННЫЕ ПРОДАВЦА");
        System.out.println("Выберите существующего клиента или внесите нового");
        dealX.chouseArItem( "seller");

        System.out.println("1.1. ДАННЫЕ ПРЕДМЕТА СДЕЛКИ");
        Main.fillInAr(dealX.arDealGoodsIDTemp,dealX.arDealGoodsIdTempStub);

        System.out.println("Выберите товар для сделки или создайте новый");
        String switchGoodMenu = "1";

        do {

            if (switchGoodMenu.matches("1")) {
                dealX.chouseArItem("tempGood");
            } else if (switchGoodMenu.matches("0")){
                dealX.deleteGoodFromDeal();
            } else {}

            if (Main.getFirstFreeArItem(arDealGoodsIDTemp)<2){
                System.out.println("В сделке 0 товаров. Внесите хотя бы 1 товар");
                switchGoodMenu = "1";
            } else {
                System.out.println("Внести еще 1 товар в сделку \"1\", удалить товар из сделки - \"0\", " +
                        "перейти к следующему шагу - все остальное ");
                switchGoodMenu = Main.scanNext();
            }

        } while (switchGoodMenu.matches("[10]"));

        System.out.println("2.0 ДАННЫЕ ПОКУПАТЕЛЯ");
        System.out.println("Выберите существующего клиента или внесите нового");
        dealX.chouseArItem("buyer");

        System.out.println("3.0 ПРОВЕРКА ВОЗМОЖНОСТИ СДЕЛКИ");
        Good goodN = new Good();
        dealX.dealBeOrNotToBe(goodN.countDealGoods());
        dealX.setDealDataToAr();


    }

    private void setGoodDataToArTemp(Integer goodID){
        System.out.println("Введите количество товара для сделки");
        Integer tempGoodCount = Main.isScanNotNegativeInt();

        if (tempGoodCount == 0){
            System.out.println("Выбранный товар не внесен в сделку, т.к. его количество = 0");
            return;
        } else {
            if (Good.getArGoods()[goodID][4].matches("in_lots")){
                tempGoodCount = Sale_in_lots.chekGoodCount(tempGoodCount, goodID);
                if (tempGoodCount < 0){
                    setGoodDataToArTemp(goodID);
                    return;
                } else {}
            } else {}
            Integer freeTempGoodId = Main.getFirstFreeArItem(arDealGoodsIDTemp);
            arDealGoodsIDTemp[freeTempGoodId][0] = goodID.toString();
            arDealGoodsIDTemp[freeTempGoodId][1] = tempGoodCount.toString();
            System.out.println("Товар с ID " + goodID + " внесен в сделку");
            return;
        }

    }

    private void deleteGoodFromDeal(){
        System.out.println("Товары в сделке");

        for (int i = 1; i < Main.getFirstFreeArItem(arDealGoodsIDTemp); i++){
            for (int j = 0; j < Main.getFirstFreeArItem(Good.getArGoods()); j++){
                if (Good.getArGoods()[j][0].matches(arDealGoodsIDTemp[i][0])){
                    for (int k = 0 ; k < Good.getArGoods()[0].length; k++){
                        System.out.print(Good.getArGoods()[j][k] + "  | ");
                    }
                }
            }
            System.out.println(" ");
        }

        String numberInS;
         do {
            System.out.println("Введите ID товара. который нужно удалить, для выхода из меню удаления - \"0\"");
            numberInS = Main.scanNext();
            if(numberInS.matches("[1-9]\\d*")){

                Integer goodIDPosition = 0;

                for (int i = 1; i < Main.getFirstFreeArItem(arDealGoodsIDTemp); i++){

                    if (arDealGoodsIDTemp[i][0].matches(numberInS)){
                        goodIDPosition = i;
                    } else {}

                }

                if (goodIDPosition > 0){
                    String tempAr [][] = new String[arDealGoodsIDTemp.length][arDealGoodsIDTemp[0].length];
                    Integer arStrCounter = 0;

                    for (int i = 0 ; i < (Main.getFirstFreeArItem(arDealGoodsIDTemp)-1); i++){
                        if (i == goodIDPosition) {
                            arStrCounter++;
                        } else {}

                        for (int j = 0; j < 2; j++) {
                            tempAr[i][j] = arDealGoodsIDTemp[arStrCounter][j];
                        }
                        arStrCounter++;
                    }

                    arDealGoodsIDTemp = tempAr;
                    System.out.println("Товар с ID " + numberInS + " удален из сделки");
                    return;

                } else {
                    System.out.println("Товара с таким ID нет в сделке");
                }

            } else if (numberInS.matches("0")){
                return;
            } else {}
        }while (!numberInS.matches("[1-9]\\d*"));

    }

    private void setDealDataToAr(){
        Integer q = Main.getFirstFreeArItem(arDeals);
        arDeals[q][0] = q.toString();
        arDeals[q][1] = dealDate;
        arDeals[q][2] = sellerId.toString();
        arDeals[q][3] = buyerId.toString();
        arDeals[q][4] = LocalDateTime.now().plus(Period.ofDays(10)).
                                            format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a"));
        arDeals[q][5] = dealSumm.toString();
        arDeals[q][6] = dealResult.toString();
        Integer m = Main.getFirstFreeArItem(arDealGoods);
        Integer n = Main.getFirstFreeArItem(arDealGoodsIDTemp) -1;
        Integer k = 1;

        for (int i = m; i < (m + n) ;i++){
                arDealGoods[i][0] = arDealGoodsIDTemp[k][0];
                arDealGoods[i][1] = arDealGoodsIDTemp[k][1];
                arDealGoods[i][2] = arDealGoodsIDTemp[k][2];
                arDealGoods[i][3] = arDealGoodsIDTemp[k][3];
                arDealGoods[i][4] = arDealGoodsIDTemp[k][4];
                arDealGoods[i][5] = arDealGoodsIDTemp[k][5];
                arDealGoods[i][6] = arDealGoodsIDTemp[k][6];
                arDealGoods[i][7] = arDealGoodsIDTemp[k][7];
                arDealGoods[i][8] = arDealGoodsIDTemp[k][8];
                arDealGoods[i][9] = arDealGoodsIDTemp[k][9];
                arDealGoods[i][10] = arDealGoodsIDTemp[k][10];
                arDealGoods[i][11] = arDealGoodsIDTemp[k][11];
                arDealGoods[i][12] = q.toString();
                k++;
        }

        if (dealResult){
            Person.updatePersonMoney(buyerId, dealSumm);
        }

        System.out.println("ID сделки " + q + "(deadline date " + arDeals[q][4]+ ")");

    }

    private void chouseArItem(String menuType) {
        Boolean repitMenu = true;
        String strIn;
        Integer itemID;
        String arToShow[][];

        if (menuType.matches("tempGood")) {
            arToShow = Good.getArGoods();
        } else {
            arToShow = Person.arPersons;
        }

        do {
            System.out.println("Просмотр списка существующих - \"s\", создание нового - \"0\", " +
                    "выбор существующего - ID элемента списка");
            strIn = Main.scanNext();

            if (strIn.matches("s")) {
                        Main.showAr(arToShow, Main.getFirstFreeArItem(arToShow).toString());
                        continue;
            } else if (strIn.matches("0")) {

                        if (menuType.matches("tempGood")) {
                            itemID = Good.createGood();
                            setGoodDataToArTemp(itemID);
                            return;
                        } else if (menuType.matches("seller")) {
                            sellerId = Person.createPerson();
                            return;
                        } else if (menuType.matches("buyer")) {
                            buyerId = Person.createPerson();
                            return;
                        } else {}

            } else if (strIn.matches("^[1-9]\\d*")) {
                        itemID = Integer.parseInt(strIn);

                        if (itemID < (Main.getFirstFreeArItem(arToShow))) {
                            System.out.print("Выбран элемент c ID " + itemID);
                            Main.showArItem(arToShow, itemID);
                        } else {
                            System.out.println("Элемента  с таким ID не существует, повторите ввод");
                            continue;
                        }

                        if (menuType.matches("tempGood")) {
                            setGoodDataToArTemp(itemID);
                            return;
                        } else if (menuType.matches("seller")) {
                            sellerId = itemID;
                            return;
                        } else if (menuType.matches("buyer")) {
                            buyerId = itemID;
                            return;
                        } else {}
            } else {
                System.out.println("Такого варианта в меню нет, повторите ввод");
                continue;
            }

        } while (repitMenu);

    }

    void dealBeOrNotToBe(Double dealSumm){
        Double summ = Double.parseDouble(Person.arPersons[buyerId][2]);
        if (dealSumm > summ){
            System.out.println("Сделка века не состоялась. Нужно больше золота ");
            dealResult = false;
        } else {
            System.out.println("Сделка века состоялась. Несите шампанское! ");
            dealResult = true;
        }
        this.dealSumm = dealSumm;

    }

    public static void showDealInfo() {
        System.out.println("Введите номер сделки для просмотра информации по ней, для просмотра всех сделок введите 0");
        Integer dealNum = Main.isScanNotNegativeInt();

        if (dealNum > 0 && dealNum < Main.getFirstFreeArItem(arDeals)) {
            System.out.print("Сделка № " + dealNum + ". От " + arDeals[dealNum][1]);
            System.out.printf(" На сумму %.2f", Double.parseDouble(arDeals[dealNum][5]));

            if (Boolean.parseBoolean(arDeals[dealNum][6])){
                System.out.println(" состоялась (deadline date " + arDeals[dealNum][4] + ") ");
            } else {
                System.out.println(" не состоялась");
            }

            for (int i = 0; i < Main.getFirstFreeArItem(Person.arPersons) ; i++){
                if (Person.arPersons[i][0].matches(arDeals[dealNum][2])){
                    System.out.println("Продавец : " + Person.arPersons[i][1]);
                }
            }

            for (int i = 0; i < Main.getFirstFreeArItem(Person.arPersons) ; i++){
                if (Person.arPersons[i][0].matches(arDeals[dealNum][3])){
                    System.out.println("Покупатель: " + Person.arPersons[i][1]);
                }
            }

            System.out.println("Предмет сделки: " + "\n_______________");

            for (int i = 0; i < Main.getFirstFreeArItem(arDealGoods); i++) {
                if (arDealGoods[i][12].matches(dealNum.toString()) || arDealGoods[i][12].matches("DEAL_ID")){

                    for (int j = 0; j < arDealGoods[0].length; j++) {
                            System.out.print(arDealGoods [i][j] + " | ");
                        }

                    System.out.print("\n");

                    } else {}
            }
        }

    }


}
