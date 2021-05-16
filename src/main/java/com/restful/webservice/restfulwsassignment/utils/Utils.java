package com.restful.webservice.restfulwsassignment.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.webservice.restfulwsassignment.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Utils {

    @Autowired
    private ObjectMapper objectMapper;

    public int retrieveProductPrice(int product_id) throws IOException {
        Pricing pricing = getPricingData();
        List<ProductSummary> productSummaries = pricing.getPrices();
        for (ProductSummary productSummary : productSummaries) {
            if (product_id == productSummary.getProduct_id()) {
                return productSummary.getPrice();
            }
        }
        return 0;
    }

    public double retrieveProductVAT(int product_id) throws IOException {
        Pricing pricing = getPricingData();
        VatBand vatband = pricing.getVat_bands();
        List<ProductSummary> productSummaries = pricing.getPrices();

        for (ProductSummary productSummary : productSummaries) {
            if (product_id == productSummary.getProduct_id()) {
                String vatbandType = productSummary.getVat_band();
                if ("standard".equals(vatbandType)) {
                    return vatband.getStandard();
                } else
                    return vatband.getZero();
            }
        }

        return 0;
    }

    public ProductVatPrice buildProductVatPrice(int product_id, int price, int quantity, double vat) {
        ProductVatPrice productVatPrice = new ProductVatPrice();
        productVatPrice.setProduct_id(product_id);
        productVatPrice.setQuantity(quantity);
        productVatPrice.setPrice(quantity * price);
        productVatPrice.setVat(price * vat);
        return productVatPrice;
    }

    public TotalOrderSummary buildTotalOrderSummary(int totalPrice, double totalVAT, List<ProductVatPrice> vatPriceList) {
        TotalOrderSummary totalOrderSummary = new TotalOrderSummary();
        totalOrderSummary.setTotalPrice(totalPrice);
        totalOrderSummary.setTotalVAT(totalVAT);
        totalOrderSummary.setProductPriceVATList(vatPriceList);
        return totalOrderSummary;
    }

    public Pricing getPricingData() throws IOException {
        // Pricing pricing = objectMapper.readValue(new URL("https://github.com/tailsdotcom/coding-test-pricing-service/blob/master/pricing.json"), Pricing.class);
        Path filePath = Paths.get("src", "main", "resources", "pricing.json");
        return objectMapper.readValue(new File(filePath.toAbsolutePath().toString()), Pricing.class);
    }
}

