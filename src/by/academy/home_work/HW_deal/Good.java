package by.academy.home_work.HW_deal;

public class Good {
    private String goodName;
    private String goodType;
    private Double goodPrice;
    private static String arGoods [][] = new String[100][7];
    private static String arGoodsStub [][] = {
            {"GOOD_ID","GOOD_TYPE","GOOD_MODEL","GOOD_PRICE"},
            {"1","Чайник","императорский багряный", "10"},
            {"2","Холодильник","фантазия снегурочки №1","20"}
    };

    public Good(){
        this.goodName = "Шило в мешке";
        this.goodPrice = 0.0;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public String getPriceProduct(double priceProduct) {
        String s = Double.toString(priceProduct);
        return s;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = Double.parseDouble(goodPrice);
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    static void fillInArGoods(){
        for (int i = 0; i< arGoodsStub.length; i++){
            for (int j = 0; j< 4; j++){
                arGoods[i][j] = arGoodsStub[i][j];
            }
        }
    }

    public static void showArGoods(){
        // Проверка содержимого массива
        for (int i = 0; i< 5; i++){
            for (int j = 0; j< 4; j++){
                System.out.print(arGoods [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }

    static Integer getFirstFreeArGoodsId(){
        Integer n = null;
        for (int i = 0; i< arGoods.length; i++){
            if (arGoods[i][0]==null){
                n = i;
                break;
            }
        }
        return n;
    }

    public static Integer createGood(){
        System.out.println("Внесите данные нового товара");

        System.out.println("Введите тип товара");

        Good goodX = new Good();

        goodX.goodType = Main.scanNextLine();

        System.out.println("Введите модель");

        goodX.goodName = Main.scanNextLine();

        System.out.println("Введите цену");

        goodX.goodPrice = Double.parseDouble(Main.scanNextLine());

        System.out.println(goodX.goodType  + goodX.goodName + goodX.goodPrice);

        Good.setGoodsDataToAr(Good.getFirstFreeArGoodsId(), goodX.goodType, goodX.goodName, goodX.goodPrice.toString());

        Good.showArGoods();

        return (getFirstFreeArGoodsId() - 1);


    }

    private static void setGoodsDataToAr(Integer goodId, String goodType, String goodName, String goodPrice) {

        Integer arGooodNum = (goodId - 1);
        arGoods[goodId][0] = arGooodNum.toString();
        arGoods[goodId][1] = goodType;
        arGoods[goodId][2] = goodName;
        arGoods[goodId][3] = goodPrice;

    }

}
