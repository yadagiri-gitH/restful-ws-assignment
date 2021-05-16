package com.restful.webservice.restfulwsassignment.bean;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TotalOrderSummary {
    private int totalPrice;
    private double totalVAT;
    private List<ProductVatPrice> productVatPriceList;

    public TotalOrderSummary() {

    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    public List<ProductVatPrice> getProductPriceVATList() {
        return productVatPriceList;
    }

    public void setProductPriceVATList(List<ProductVatPrice> productVatPriceList) {
        this.productVatPriceList = productVatPriceList;
    }

}
