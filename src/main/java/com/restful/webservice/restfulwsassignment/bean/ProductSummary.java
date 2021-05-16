package com.restful.webservice.restfulwsassignment.bean;

public class ProductSummary {
    private int product_id;
    private int price;
    private String vat_band;

    public ProductSummary() {

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVat_band() {
        return vat_band;
    }

    public void setVat_band(String vat_band) {
        this.vat_band = vat_band;
    }
}
