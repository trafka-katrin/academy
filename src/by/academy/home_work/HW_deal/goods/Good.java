package by.academy.home_work.HW_deal.goods;

import by.academy.home_work.HW_deal.Deal;
import by.academy.home_work.HW_deal.Main;

public class Good {
    protected static Double discontByGoodsSumm = 5.0;
    protected static String arGoodsStub [][] = {
            {"GOOD_ID","GOOD_TYPE","GOOD_NAME","GOOD_PRICE","SALE_TYPE","GOOD_LOT_SIZE"},
            {"1","Чайник","императорский багряный", "10.00","by_piece","1"},
            {"2","Холодильник","фантазия снегурочки №2","20.00","by_piece","1"},
            {"3","Дрова","непослушный Буратино","1.00","in_lots","10"},
            {"4","Компот","аннигиляция сознания 76°","40.00","by_volume","1",}};
    protected static String arGoods [][] = new String[100][arGoodsStub[0].length];
    protected Integer goodID;
    protected String goodType;
    protected String goodName;
    protected String goodCount;
    protected String saleType;
    protected String lotSize;
    protected String taraData;
    protected Double totalTaraPrice = 0.0;
    protected Double bruttoPrice;
    protected Double goodPrice;
    protected Double goodSalePrice;
    protected Double goodDiscontSize;

    public Good(){
    }

    public static String[][] getArGoods() {
        return arGoods;
    }

    public static String[][] getArGoodsStub() {
        return arGoodsStub;
    }

    public static Integer createGood(){
        System.out.println("Внесите данные нового товара");
        System.out.println("Введите способ продажи товара: ▶ поштучно \"1\"    ▶ на разлив \"2\"    ▶ партиями \"3\"");

        Integer saleType = Main.isScanNotNegativeInt();

        Good goodX = new Good();

        do {

            if (saleType == 1) {
                goodX = new Sale_by_piece();
            } else if (saleType == 2) {
                goodX = new Sale_by_volume();
            } else if (saleType == 3) {
                goodX = new Sale_in_lots();
            } else {
                System.out.println("Число не входит в предложенный диапазон повторите ввод");
                saleType = Main.isScanNotNegativeInt();
            }

        } while (saleType < 1 && saleType > 3);

        System.out.println("Введите тип товара ");
        goodX.goodType = Main.scanNextLine();

        System.out.println("Введите модель");
        goodX.goodName = Main.scanNextLine();

        System.out.println("Введите цену");
        goodX.goodPrice = Double.parseDouble(Main.scanNextLine());

        Good.setGoodsDataToAr(Main.getFirstFreeArItem(arGoods), goodX.goodType, goodX.goodName,
                            goodX.goodPrice.toString(), goodX.saleType, goodX.lotSize);

        System.out.println("Создан новый товар ");
        Main.showArItem(arGoods, Main.getFirstFreeArItem(arGoods)-1);

        return (Main.getFirstFreeArItem(arGoods) - 1);

    }

    protected static void setGoodsDataToAr(Integer goodId, String goodType, String goodName, String goodPrice,
                                           String saleType, String lotSize) {
        arGoods[goodId][0] = goodId.toString();
        arGoods[goodId][1] = goodType;
        arGoods[goodId][2] = goodName;
        arGoods[goodId][3] = goodPrice;
        arGoods[goodId][4] = saleType;
        arGoods[goodId][5] = lotSize;

    }

    public Double countDealGoods (){
        System.out.println("Расчет суммы сделки");
        Double dealSumm = 0.00;
        Integer dealArGoodsCount = Main.getFirstFreeArItem(Deal.getArDealGoods());

        for (int i = 0; i < Main.getFirstFreeArItem(Deal.arDealGoodsIDTemp); i++){

            if (Deal.arDealGoodsIDTemp[i][0].matches("[\\d]+")){

                    goodID = Integer.parseInt(Deal.arDealGoodsIDTemp[i][0]);
                    goodCount = Deal.arDealGoodsIDTemp[i][1];
                    saleType = Good.arGoods[goodID][4];
                    lotSize = Good.arGoods[goodID][5];
                    goodPrice = Double.parseDouble(Good.arGoods[goodID][3]);
                    Double goodsPrice = goodPrice * Double.parseDouble(goodCount);
                    bruttoPrice = goodsPrice;

                    if (saleType.matches("by_volume")){       //данные тары
                            Double [][] tempTaraData = Sale_by_volume.getTaraData(Integer.parseInt(goodCount));
                            taraData = setTaraData(tempTaraData);
                            totalTaraPrice =
                                    tempTaraData[0][0]*tempTaraData[0][1] +
                                    tempTaraData[1][0]*tempTaraData[1][1] +
                                    tempTaraData[2][0]*tempTaraData[2][1];
                            bruttoPrice =totalTaraPrice + goodsPrice;
                    } else {}

                goodDiscontSize = chekDiscount(Integer.parseInt(goodCount), goodPrice, saleType,
                                                lotSize, totalTaraPrice);

                goodSalePrice = bruttoPrice - bruttoPrice/100 * goodDiscontSize;

                System.out.println(i + " Товар " + Good.arGoods[goodID][1] + " " + Good.arGoods[goodID][2] + " по " +
                        goodPrice + " у.ё. " + goodCount + " штука, sale type " + saleType +
                        " (" + lotSize + "), на сумму " + goodsPrice);

                if (saleType.matches("by_volume")){
                    System.out.println(taraData);
                } else {}

                if (goodSalePrice < goodsPrice && goodSalePrice > 0){
                    System.out.printf("           Цена со скидкой %.0f %% %.2f \n", goodDiscontSize, goodSalePrice);
                } else {}

                Deal.arDealGoodsIDTemp[i][2] = Good.arGoods[goodID][1];
                Deal.arDealGoodsIDTemp[i][3] = Good.arGoods[goodID][2];
                Deal.arDealGoodsIDTemp[i][4] = saleType;
                Deal.arDealGoodsIDTemp[i][5] = Good.arGoods[goodID][3];
                Deal.arDealGoodsIDTemp[i][6] = lotSize;
                Deal.arDealGoodsIDTemp[i][7] = taraData;
                Deal.arDealGoodsIDTemp[i][8] = totalTaraPrice.toString();
                Deal.arDealGoodsIDTemp[i][9] = goodsPrice.toString();
                Deal.arDealGoodsIDTemp[i][10] = goodDiscontSize.toString();
                Deal.arDealGoodsIDTemp[i][11] = goodSalePrice.toString();

                dealSumm =  goodSalePrice + dealSumm;
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
