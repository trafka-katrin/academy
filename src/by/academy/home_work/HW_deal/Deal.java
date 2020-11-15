package by.academy.home_work.HW_deal;

public class Deal {
    private Integer dealId;
    private String dealDate;
    private Integer sellerId;
    private Integer buyerId;
    private Double dealSumm;
    private Boolean dealResult;
    private String goodsIDTemp [][] = new String[100][3];
    private static String arGoodsId [][] = new String [100][3];
    private static String arGoodsIdStub [][] = {
            {"GOODS_ID","GOODS_COUNT","DEAL_ID"},
    };
    private static String arDeals [][] = new String[100][7];
    private static String arDealsStub [][] = {
            {"DEAL_ID","DEAL_DATE","SELLER_ID","BUYER_ID","ARGOODS_ID","DEAL_SUMM","DEAL_RESULT"},
            {"0","00.00.0000","0","1","0","10.00","true"},
            {"1","00.00.0000","1","0","1","200.00","false"}
    };

    public Deal (String dealDate){
        this.dealId = getFirstFreeArDealsId();
        this.dealDate = dealDate;
        Integer arDealIdNumber = dealId - 1;
        arDeals[dealId][0] = arDealIdNumber.toString();
        arDeals[dealId][1] = dealDate;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public static void createDeal(){

        System.out.println("Введите дату сделки ");

        Deal dealx = new Deal(Main.scanNext());

        System.out.println("Данные продавца");
        Person.createPerson();

        System.out.println("Данные предмета сделки");

        do {
        System.out.println("Выберите товары для сделки");
        Deal.chouseGoodArShow();
        dealx.chouse1GoodEnter();
        System.out.println("Внести еще 1 товар ?");

        } while (Main.scanNext().toLowerCase().matches("да"));


        System.out.println("Данные покупателя");
        Person.createPerson();



    }

    static void fillInArDeals(){
        for (int i = 0; i< arDealsStub.length; i++){
            for (int j = 0; j< 7; j++){
                arDeals[i][j] = arDealsStub[i][j];
            }
        }
    }

    static void fillInArGoodsTemp(){
        for (int i = 0; i< arGoodsIdStub.length; i++){
            for (int j = 0; j< 7; j++){
                arGoodsId[i][j] = arGoodsIdStub[i][j];
            }
        }
    }

    private static Integer getFirstFreeArDealsId(){
        Integer n = null;
        for (int i = 0; i< arDeals.length; i++){
            if (arDeals[i][0]==null){
                n = i;
                break;
            }
        }
        return n;
    }

    private Integer getFirstFreeArGoodsTempId(){
        Integer n = null;

            for (int i = 0; i< goodsIDTemp.length; i++){
            if (goodsIDTemp[i][0]==null){
                n = i;
                break;
            }
        }
        return n;
    }
    private void setGoodDataToArTemp(Integer goodID){
        System.out.println("Введите количество товара");

        String tempGoodCount = Main.isScanInt().toString();
        Integer freeTempGoodId = getFirstFreeArGoodsTempId();
        goodsIDTemp[freeTempGoodId][0] = goodID.toString();
        goodsIDTemp[freeTempGoodId][1] = tempGoodCount;
        showArGoodsTemp();


    }

    public static void chouseGoodArShow (){
        System.out.println("Показать доступный для выбора список товаров? (да/нет)");
        Boolean ch = Main.scanNext().toLowerCase().contains("да");
        if(ch){
            Good.showArGoods();
        }

    }

    public void chouse1GoodEnter(){
        System.out.println("Для выбора существующего товара введите его ID, чтобы внести новый введите 0");
        Integer intEnter = Main.isScanInt();
        if (intEnter>=0){
            if (intEnter > 0 && intEnter < (Good.getFirstFreeArGoodsId())-1){
                System.out.println("Выбран товар с номером " + intEnter);
                setGoodDataToArTemp(intEnter);

            } else if (intEnter == 0){
                intEnter = Good.createGood();
                setGoodDataToArTemp(intEnter);
            } else {
                System.out.println("Товара с таким ID не существует");
                chouse1GoodEnter();
            }
        } else {
            System.out.println("Введите число больше 0");
            chouse1GoodEnter();

        }

    }

    public void chouseGoodsEnter(){

    }

    public static void showArDeals(){
        // Проверка содержимого массива
        for (int i = 0; i< 5; i++){
            for (int j = 0; j< 7; j++){
                System.out.print(Deal.arDeals [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }

    public void showArGoodsTemp(){
        // Проверка содержимого массива
        for (int i = 0; i< 5; i++){
            for (int j = 0; j< 3; j++){
                System.out.print(goodsIDTemp [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }







}
