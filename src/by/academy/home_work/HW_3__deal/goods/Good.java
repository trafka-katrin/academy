package by.academy.home_work.HW_3__deal.goods;

import by.academy.home_work.HW_3__deal.builders.Deal_builder;
import by.academy.home_work.HW_3__deal.builders.Builder;

public class Good {
    protected static Double discontByGoodsSumm = 5.0;

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

    public static Double getDiscontByGoodsSumm() {
        return discontByGoodsSumm;
    }

    public static void setDiscontByGoodsSumm(Double discontByGoodsSumm) {
        Good.discontByGoodsSumm = discontByGoodsSumm;
    }

    public Integer getGoodID() {
        return goodID;
    }

    public void setGoodID(Integer goodID) {
        this.goodID = goodID;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(String goodCount) {
        this.goodCount = goodCount;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getLotSize() {
        return lotSize;
    }

    public void setLotSize(String lotSize) {
        this.lotSize = lotSize;
    }

    public String getTaraData() {
        return taraData;
    }

    public void setTaraData(String taraData) {
        this.taraData = taraData;
    }

    public Double getTotalTaraPrice() {
        return totalTaraPrice;
    }

    public void setTotalTaraPrice(Double totalTaraPrice) {
        this.totalTaraPrice = totalTaraPrice;
    }

    public Double getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(Double bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Double getGoodSalePrice() {
        return goodSalePrice;
    }

    public void setGoodSalePrice(Double goodSalePrice) {
        this.goodSalePrice = goodSalePrice;
    }

    public Double getGoodDiscontSize() {
        return goodDiscontSize;
    }

    public void setGoodDiscontSize(Double goodDiscontSize) {
        this.goodDiscontSize = goodDiscontSize;
    }
}
