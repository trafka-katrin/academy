package by.academy.home_work.HW_deal;

import by.academy.home_work.HW_deal.goods.Good;
import by.academy.home_work.HW_deal.goods.Sale_in_lots;
import by.academy.home_work.HW_deal.validators.Date_validator;

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
            {"DEAL_ID","DEAL_DATE","SELLER_ID","BUYER_ID","BUYER_SUMM","DEAL_SUMM","DEAL_RESULT"},
            {"1","01.01.2020","2","1","0","40.00","true"},
            {"2","02.02.2020","1","2","1","130.00","false"}};
    private String dealDate;
    private Integer sellerId;
    private Integer buyerId;
    private Double dealSumm;
    private Boolean dealResult;

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
        dealX.chouseArShow(Person.arPersons);
        dealX.chouseOneItemEnter(Person.arPersons, "seller");

        System.out.println("1.1. ДАННЫЕ ПРЕДМЕТА СДЕЛКИ");
        Main.fillInAr(dealX.arDealGoodsIDTemp,dealX.arDealGoodsIdTempStub);

        do {
            System.out.println("Выберите товар для сделки или создайте новый");
            dealX.chouseArShow(Good.getArGoods());
            dealX.chouseOneItemEnter(Good.getArGoods(), "tempGood");
            System.out.println("Внести еще 1 товар в сделку? Внести - \"да\", пропустить - все остальное ");
        } while (Main.scanNext().toLowerCase().matches("да"));

        System.out.println("2.0 ДАННЫЕ ПОКУПАТЕЛЯ");
        System.out.println("Выберите существующего клиента или внесите нового");
        dealX.chouseArShow(Person.arPersons);
        dealX.chouseOneItemEnter(Person.arPersons, "buyer");

        System.out.println("3.0 ПРОВЕРКА ВОЗМОЖНОСТИ СДЕЛКИ");
        Good goodN = new Good();
        dealX.dealBeOrNotToBe(goodN.countDealGoods());
        dealX.setDealDataToAr();

        Main.showAr(arDeals,"5");
        Main.showAr(arDealGoods,"5");
        showDealInfo();

    }

    private void setGoodDataToArTemp(Integer goodID){
        System.out.println("Введите количество товара");
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
        }

    }

    private void setDealDataToAr(){
        Integer q = Main.getFirstFreeArItem(arDeals);
        arDeals[q][0] = q.toString();
        arDeals[q][1] = dealDate;
        arDeals[q][2] = sellerId.toString();
        arDeals[q][3] = buyerId.toString();
        arDeals[q][4] = " ";
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

    }

    private void chouseArShow(String m[][]){
        System.out.println("Показать список существующих? Показать - \"да\", пропустить - все остальное ");
        Boolean ch = Main.scanNext().toLowerCase().contains("да");

        if(ch){
            Main.showAr(m, "5");
        }

    }

    public void chouseOneItemEnter(String s [][], String sName){
        System.out.println("Для выбора существующего элемента введите его ID, чтобы внести новый введите 0");
        Integer existingItemId = Main.isScanNotNegativeInt();

            if (existingItemId > 0 && existingItemId < (Main.getFirstFreeArItem(s))){
                Integer arFirstStrLen = s[0].length;
                System.out.print("Выбран элемент c ID ");

                    for(int i = 0;i<arFirstStrLen;i++) {
                        System.out.print(s[existingItemId][i] + " | ");
                    }

                    System.out.println(" ");

                    if (sName.matches("tempGood")) {
                        setGoodDataToArTemp(existingItemId);
                    } else if (sName.matches("seller")){
                        sellerId = existingItemId;
                    } else if (sName.matches("buyer")){
                        buyerId = existingItemId;
                    } else {}

            } else if (existingItemId == 0){

                    if (sName.matches("tempGood")) {
                        existingItemId = Good.createGood();
                        setGoodDataToArTemp(existingItemId);
                    } else if (sName.matches("seller")){
                        sellerId = Person.createPerson();
                    } else if (sName.matches("buyer")) {
                        buyerId = Person.createPerson();
                    } else {}

            } else {
                System.out.println("Элемента  с таким ID не существует");
                chouseOneItemEnter(s, sName);
                return;
            }

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
                System.out.println(" состоялась ");
            } else {
                System.out.println(" не состоялась");
            }

            System.out.println();

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
                    for (int j = 0; j < arDealGoods[0].length; j++) {
                        if (arDealGoods[i][12].matches(dealNum.toString()) || arDealGoods[i][12].matches("DEAL_ID")) {
                            System.out.print(arDealGoods [i][j] + " | ");
                        } else {}
                    }

                System.out.println(" ");
            }
        }

    }


}
