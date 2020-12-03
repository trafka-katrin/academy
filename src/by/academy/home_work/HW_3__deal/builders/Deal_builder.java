package by.academy.home_work.HW_3__deal.builders;

import by.academy.home_work.HW_3__deal.Deal;
import by.academy.home_work.HW_3__deal.goods.Good;
import by.academy.home_work.HW_3__deal.goods.Sale_by_piece;
import by.academy.home_work.HW_3__deal.goods.Sale_by_volume;
import by.academy.home_work.HW_3__deal.goods.Sale_in_lots;
import by.academy.home_work.HW_3__deal.validators.Date_validator;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Deal_builder extends Builder{
    private static String arDealGoodsIdTempStub[][] = {
            {"GOOD_ID", "GOODS_COUNT", "GOOD_TYPE", "GOOD_MODEL", "SALE_TYPE", "PRICE", "GOOD_LOT_SIZE",
            "TARA_DATA", "TARA_PRICE", "GOODS_PRICE", "DISCOUNT", "SALE_PRICE", "DEAL_ID"}};
    private static String arDealGoodsIDTemp[][] = new String[100][arDealGoodsIdTempStub[0].length];
    private static String arDealGoodsStub[][] = {
            {"GOOD_ID", "GOODS_COUNT", "GOOD_TYPE", "GOOD_MODEL", "SALE_TYPE","PRICE", "GOOD_LOT_SIZE",
            "TARA_DATA", "TARA_PRICE", "GOODS_PRICE", "DISCOUNT", "SALE_PRICE","DEAL_ID"},
            {"testID","1","Что-то неведомое","модель-1","by_piece","10.0","1", null ,null,"10.0","0","10.0","1"},
            {"testID","2","Что-то неведомое","модель-2 ","by_piece","20.0","1", null ,null,"40.0","0","40.0","1"},
            {"testID","3","Что-то неведомое","модель-3 ","by_piece","30.0","1", null ,null,"90.0","0","90.0","2"}};
    private static String arDealGoods[][] = new String[100][arDealGoodsStub[0].length];
    private static String arDealsStub [][] = {
            {"DEAL_ID","DEAL_DATE","SELLER_ID","BUYER_ID","DEADLINE","DEAL_SUMM","DEAL_RESULT"},
            {"1","01.01.2020","2","1","0","40.00","true"},
            {"2","02.02.2020","1","2","1","130.00","false"}};
    private static String arDeals [][] = new String[100][arDealsStub[0].length];

    public static String[][] getArDealGoodsIDTemp() {
        return arDealGoodsIDTemp;
    }

    public static void setArDealGoodsIDTemp(String arDealGoodsIDTemp, int s, int s1) {
        Deal_builder.arDealGoodsIDTemp[s][s1] = arDealGoodsIDTemp;
    }

    public static String[][] getArDealGoodsStub() {
        return arDealGoodsStub;
    }

    public static String[][] getArDealsStub() {
        return arDealsStub;
    }

    public static String[][] getArDeals() {
        return arDeals;
    }

    public static String[][] getArDealGoods() {
        return arDealGoods;
    }

    public static void createDeal(){
        System.out.println( "-----------------------------------------\n" +
                            "СОЗДАНИЕ НОВОЙ СДЕЛКИ\n" +
                            "-----------------------------------------");
        Deal_builder deal_builder = new Deal_builder();
        Deal dealX = new Deal();

        System.out.println("Введите дату сделки в формате dd/MM/yyyy или dd-ММ-yyyy ");
        dealX.setDealDate(Date_validator.validateDate());
        Date_validator.parceDate(dealX.getDealDate());

        System.out.println( "_________________________________________\n" +
                            "1. ДАННЫЕ ПРОДАВЦА\n");

        System.out.println("Выберите существующего клиента или внесите нового");
        deal_builder.chouseArItem( "seller", dealX);

        System.out.println( "_________________________________________\n" +
                            "1.1. ДАННЫЕ ПРЕДМЕТА СДЕЛКИ\n");
        Builder.fillInAr(arDealGoodsIDTemp, arDealGoodsIdTempStub);

        System.out.println("Выберите товар для сделки или создайте новый");
        String switchGoodMenu = "1";

        do {

            if (switchGoodMenu.matches("1")) {
                deal_builder.chouseArItem("tempGood", dealX);
            } else if (switchGoodMenu.matches("0")){
                deal_builder.deleteGoodFromDeal();
            } else {}

            if (Builder.getFirstFreeArItem(arDealGoodsIDTemp)<2){
                System.out.println("В сделке 0 товаров. Внесите хотя бы 1 товар");
                switchGoodMenu = "1";
            } else {
                System.out.println("▶ Внести еще 1 товар в сделку \"1\"   ▶ Удалить товар из сделки - \"0\"   " +
                        "▶ Перейти к следующему шагу - все остальное ");
                switchGoodMenu = Builder.scanNext();
            }

        } while (switchGoodMenu.matches("[10]"));

        System.out.println( "_________________________________________\n"+
                            "2.0 ДАННЫЕ ПОКУПАТЕЛЯ\n");
        System.out.println("Выберите существующего клиента или внесите нового");
        deal_builder.chouseArItem("buyer", dealX);

        System.out.println( "_________________________________________\n"+
                            "3.0 ПРОВЕРКА ВОЗМОЖНОСТИ СДЕЛКИ\n");
        Good goodN = new Good();
        deal_builder.dealBeOrNotToBe(deal_builder.countDealGoods(goodN), dealX);
        deal_builder.setDealDataToAr(dealX);


    }

    private void setGoodDataToArTemp(Integer goodID){
        System.out.println("Введите количество товара для сделки");
        Integer tempGoodCount = Builder.isScanNotNegativeInt();

        if (tempGoodCount == 0){
            System.out.println("Выбранный товар не внесен в сделку, т.к. его количество = 0");
            return;
        } else {
            if (Good_builder.getArGoods()[goodID][4].matches("in_lots")){
                tempGoodCount = Sale_in_lots.chekGoodCount(tempGoodCount, goodID);
                if (tempGoodCount < 0){
                    setGoodDataToArTemp(goodID);
                    return;
                } else {}
            } else {}
            Integer freeTempGoodId = Builder.getFirstFreeArItem(arDealGoodsIDTemp);
            arDealGoodsIDTemp[freeTempGoodId][0] = goodID.toString();
            arDealGoodsIDTemp[freeTempGoodId][1] = tempGoodCount.toString();
            System.out.println("Товар с ID " + goodID + " внесен в сделку");
            return;
        }

    }

    private void deleteGoodFromDeal(){
        System.out.println("Товары в сделке");

        for (int i = 1; i < Builder.getFirstFreeArItem(arDealGoodsIDTemp); i++){
            for (int j = 0; j < Builder.getFirstFreeArItem(Good_builder.getArGoods()); j++){
                if (Good_builder.getArGoods()[j][0].matches(arDealGoodsIDTemp[i][0])){
                    for (int k = 0 ; k < Good_builder.getArGoods()[0].length; k++){
                        System.out.print(Good_builder.getArGoods()[j][k] + "  | ");
                    }
                }
            }
            System.out.println(" ");
        }

        String numberInS;
         do {
            System.out.println("Введите ID товара. который нужно удалить, для выхода из меню удаления - \"0\"");
            numberInS = Builder.scanNext();
            if(numberInS.matches("[1-9]\\d*")){

                Integer goodIDPosition = 0;

                for (int i = 1; i < Builder.getFirstFreeArItem(arDealGoodsIDTemp); i++){

                    if (arDealGoodsIDTemp[i][0].matches(numberInS)){
                        goodIDPosition = i;
                    } else {}

                }

                if (goodIDPosition > 0){
                    String tempAr [][] = new String[arDealGoodsIDTemp.length][arDealGoodsIDTemp[0].length];
                    Integer arStrCounter = 0;

                    for (int i = 0 ; i < (Builder.getFirstFreeArItem(arDealGoodsIDTemp)-1); i++){
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

    private void setDealDataToAr(Deal dealX){
        Integer q = Builder.getFirstFreeArItem(arDeals);
        arDeals[q][0] = q.toString();
        arDeals[q][1] = dealX.getDealDate();
        arDeals[q][2] = dealX.getSellerId().toString();
        arDeals[q][3] = dealX.getBuyerId().toString();
        arDeals[q][4] = LocalDateTime.now().plus(Period.ofDays(10)).
                                            format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a"));
        arDeals[q][5] = dealX.getDealSumm().toString();
        arDeals[q][6] = dealX.getDealResult().toString();
        Integer m = Builder.getFirstFreeArItem(arDealGoods);
        Integer n = Builder.getFirstFreeArItem(arDealGoodsIDTemp) -1;
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

        if (dealX.getDealResult()){
            Person_builder.updatePersonMoney(dealX.getBuyerId(), dealX.getDealSumm());
        }

        System.out.println("\nID сделки " + q + "(deadline date " + arDeals[q][4]+ ")");

    }

    private void chouseArItem(String menuType, Deal dealX) {
        Boolean repitMenu = true;
        String strIn;
        Integer itemID;
        String arToShow[][];

        if (menuType.matches("tempGood")) {
            arToShow = Good_builder.getArGoods();
        } else {
            arToShow = Person_builder.getArPersons();
        }

        do {
            System.out.println("▶ Просмотр списка существующих - \"s\"   ▶ Создание нового - \"0\"   " +
                    "▶ Выбор существующего - ID элемента списка");
            strIn = Builder.scanNext();

            if (strIn.matches("s")) {
                        Builder.showAr(arToShow, Builder.getFirstFreeArItem(arToShow).toString());
                        continue;
            } else if (strIn.matches("0")) {

                        if (menuType.matches("tempGood")) {
                            itemID = Good_builder.createGood();
                            setGoodDataToArTemp(itemID);
                            return;
                        } else if (menuType.matches("seller")) {
                            dealX.setSellerId(Person_builder.createPerson());
                            return;
                        } else if (menuType.matches("buyer")) {
                            dealX.setBuyerId(Person_builder.createPerson());
                            return;
                        } else {}

            } else if (strIn.matches("^[1-9]\\d*")) {
                        itemID = Integer.parseInt(strIn);

                        if (itemID < (Builder.getFirstFreeArItem(arToShow))) {
                            System.out.print("Выбран элемент c ID " + itemID);
                            Builder.showArItem(arToShow, itemID);
                        } else {
                            System.out.println("Элемента  с таким ID не существует, повторите ввод");
                            continue;
                        }

                        if (menuType.matches("tempGood")) {
                            setGoodDataToArTemp(itemID);
                            return;
                        } else if (menuType.matches("seller")) {
                            dealX.setSellerId(itemID);
                            return;
                        } else if (menuType.matches("buyer")) {
                            dealX.setBuyerId(itemID);
                            return;
                        } else {}
            } else {
                System.out.println("Такого варианта в меню нет, повторите ввод");
                continue;
            }

        } while (repitMenu);

    }

    public void dealBeOrNotToBe(Double dealSumm, Deal dealX){
        Double summ = Double.parseDouble(Person_builder.getArPersons()[dealX.getBuyerId()][2]);
        if (dealSumm > summ){
            System.out.println("Сделка века не состоялась. Нужно больше золота ");
            dealX.setDealResult(false);
        } else {
            System.out.println("Сделка века состоялась. Несите шампанское! ");
            dealX.setDealResult(true);
        }
        dealX.setDealSumm(dealSumm);

    }

    public static void showDealInfo(Integer dealNum) {

        if (dealNum > 0 && dealNum < Builder.getFirstFreeArItem(arDeals)) {
            System.out.print("Сделка № " + dealNum + ". От " + arDeals[dealNum][1]);
            System.out.printf(" На сумму %.2f", Double.parseDouble(arDeals[dealNum][5]));

            if (Boolean.parseBoolean(arDeals[dealNum][6])){
                System.out.println(" состоялась (deadline date " + arDeals[dealNum][4] + ") ");
            } else {
                System.out.println(" не состоялась");
            }

            for (int i = 0; i < Builder.getFirstFreeArItem(Person_builder.getArPersons()) ; i++){
                if (Person_builder.getArPersons()[i][0].matches(arDeals[dealNum][2])){
                    System.out.println("Продавец : " + Person_builder.getArPersons()[i][1]);
                }
            }

            for (int i = 0; i < Builder.getFirstFreeArItem(Person_builder.getArPersons()) ; i++){
                if (Person_builder.getArPersons()[i][0].matches(arDeals[dealNum][3])){
                    System.out.println("Покупатель: " + Person_builder.getArPersons()[i][1]);
                }
            }

            System.out.println("Предмет сделки: " + "\n_______________");

            for (int i = 0; i < Builder.getFirstFreeArItem(arDealGoods); i++) {
                if (arDealGoods[i][12].matches(dealNum.toString()) || arDealGoods[i][12].matches("DEAL_ID")){

                    for (int j = 0; j < arDealGoods[0].length; j++) {
                            System.out.print(arDealGoods [i][j] + " | ");
                        }

                    System.out.print("\n");

                    } else {}
            }

            System.out.print("\n");
        } else {
            System.out.println("Cделки с таким ID не существует");
        }

    }

    public Double countDealGoods (Good goodX){
        System.out.println("Расчет суммы сделки");
        Double dealSumm = 0.00;
        Integer dealArGoodsCount = Builder.getFirstFreeArItem(Deal_builder.getArDealGoods());

        for (int i = 0; i < Builder.getFirstFreeArItem(Deal_builder.getArDealGoodsIDTemp()); i++){

            if (Deal_builder.getArDealGoodsIDTemp()[i][0].matches("[\\d]+")){
                int goodID = Integer.parseInt(getArDealGoodsIDTemp()[i][0]);
                goodX.setGoodID(goodID);
                goodX.setGoodCount(getArDealGoodsIDTemp()[i][1]);
                goodX.setSaleType(Good_builder.getArGoods()[goodID][4]);
                goodX.setLotSize(Good_builder.getArGoods()[goodID][5]);
                goodX.setGoodPrice(Double.parseDouble(Good_builder.getArGoods()[goodID][3]));

                Double goodsPrice = goodX.getGoodPrice() * Double.parseDouble(goodX.getGoodCount());
                goodX.setBruttoPrice(goodsPrice);

                if (goodX.getSaleType().matches("by_volume")){       //данные тары
                    Double [][] tempTaraData = Sale_by_volume.getTaraData(Integer.parseInt(goodX.getGoodCount()));
                    goodX.setTaraData(setTaraData(tempTaraData));
                    Double totalTaraPrice =
                                    tempTaraData[0][0]*tempTaraData[0][1] +
                                    tempTaraData[1][0]*tempTaraData[1][1] +
                                    tempTaraData[2][0]*tempTaraData[2][1];
                    goodX.setTotalTaraPrice(totalTaraPrice);
                    goodX.setBruttoPrice(totalTaraPrice + goodsPrice);
                } else {}

                Double goodDiscontSize = chekDiscount(Integer.parseInt(goodX.getGoodCount()), goodX.getGoodPrice(),
                                                goodX.getSaleType(), goodX.getLotSize(),goodX.getTotalTaraPrice());
                goodX.setGoodDiscontSize(goodDiscontSize);

                goodX.setGoodSalePrice(goodX.getBruttoPrice() - goodX.getBruttoPrice()/100 * goodDiscontSize);

                System.out.println( i + " Товар " + Good_builder.arGoods[goodID][1] + " " +
                                    Good_builder.arGoods[goodID][2] + " по " +
                                    goodX.getGoodPrice() + " у.ё. " + goodX.getGoodCount() +
                                    " штука, sale type " + goodX.getSaleType() + " (" +
                                    goodX.getLotSize() + "), на сумму " + goodsPrice);

                if (goodX.getSaleType().matches("by_volume")){
                    System.out.println(goodX.getTaraData());
                } else {}

                if (goodX.getGoodSalePrice() < goodsPrice && goodX.getGoodSalePrice() > 0){
                    System.out.printf("           Цена со скидкой %.0f %% %.2f \n", goodDiscontSize,
                                        goodX.getGoodSalePrice());
                } else {}

                Deal_builder.setArDealGoodsIDTemp(Good_builder.arGoods[goodID][1], i,2);
                Deal_builder.setArDealGoodsIDTemp(Good_builder.arGoods[goodID][2], i,3);
                Deal_builder.setArDealGoodsIDTemp(goodX.getSaleType(), i,4);
                Deal_builder.setArDealGoodsIDTemp(Good_builder.arGoods[goodID][3], i,5);
                Deal_builder.setArDealGoodsIDTemp(goodX.getLotSize(), i, 6);
                Deal_builder.setArDealGoodsIDTemp(goodX.getTaraData(), i, 7);
                Deal_builder.setArDealGoodsIDTemp(goodX.getTotalTaraPrice().toString(),i,8);
                Deal_builder.setArDealGoodsIDTemp(goodsPrice.toString(), i, 9);
                Deal_builder.setArDealGoodsIDTemp(goodDiscontSize.toString(), i,10);
                Deal_builder.setArDealGoodsIDTemp(goodX.getGoodSalePrice().toString(), i,11);

                dealSumm =  goodX.getGoodSalePrice() + dealSumm;
                dealArGoodsCount++;

            } else {}
        }

        System.out.printf("Итоговая сумма сделки: %.2f \n", dealSumm);System.out.println();
        return dealSumm;

    }

    private String setTaraData (Double [][] tempTaraData){

        StringBuilder tD = new StringBuilder(" Тара: ");

        for(int j = 0; j < 3; j++){

            if (tempTaraData[j][0]>0){
                Double tempTaraSumm = tempTaraData[j][0] * tempTaraData[j][1];
                String addTaraData = String.format("    %.0f  шт. по %.0f л = %.2f у.ё. ", tempTaraData[j][0],
                        tempTaraData[j][2],tempTaraSumm );
                tD.append(addTaraData);
            } else {}
        }

        return tD.toString();

    }

    private Double chekDiscount(Integer goodCount, Double goodPrice, String saleType, String lotSize,
                                Double totalTaraPrice) {
        Double discount = 0.0;

        if (saleType.matches("by_piece")){
            discount = Sale_by_piece.chekDiscount(goodPrice,goodCount);
        } else if (saleType.matches("by_volume")){
            discount = Sale_by_volume.chekDiscount(totalTaraPrice, goodCount, goodPrice);
        } else if (saleType.matches("in_lots")){
            discount = Sale_in_lots.chekDiscount(lotSize, goodCount);
        }
        return discount;

    }


}
