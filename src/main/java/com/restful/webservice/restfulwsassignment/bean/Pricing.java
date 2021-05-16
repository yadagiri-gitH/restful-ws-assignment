package com.restful.webservice.restfulwsassignment.bean;

import java.util.List;

public class Pricing {
    private List<ProductSummary> prices;
    private VatBand vat_bands;

    public Pricing() {
    }

    public void setPrices(List<ProductSummary> prices) {
        this.prices = prices;
    }

    public List<ProductSummary> getPrices() {
        return prices;
    }

    public VatBand getVat_bands() {
        return vat_bands;
    }

    public void setVat_bands(VatBand vat_bands) {
        this.vat_bands = vat_bands;
    }
}
