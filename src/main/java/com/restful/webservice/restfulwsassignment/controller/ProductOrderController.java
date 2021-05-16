package com.restful.webservice.restfulwsassignment.controller;

import com.restful.webservice.restfulwsassignment.bean.*;
import com.restful.webservice.restfulwsassignment.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductOrderController {

    @Autowired
    private Utils utils;

    @PostMapping("/orders")
    public TotalOrderSummary Orders(@RequestBody ProductOrder productOrder) throws IOException {
        Order order = productOrder.getOrder();
        List<Item> items = order.getItems();
        int totalPrice = 0;
        double totalVAT = 0.0;
        List<ProductVatPrice> vatPriceList = new ArrayList<>();

        for (Item item : items) {
            int price = utils.retrieveProductPrice(item.getProduct_id());
            double vat = utils.retrieveProductVAT(item.getProduct_id());
            int quantity = item.getQuantity();
            vatPriceList.add(utils.buildProductVatPrice(item.getProduct_id(), price, quantity, vat));
            totalPrice += quantity * price;
            totalVAT += price * vat;
        }

        return utils.buildTotalOrderSummary(totalPrice, totalVAT, vatPriceList);
    }

}
