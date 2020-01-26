package com.newsapi.bundle.client;

import com.newsapi.bundle.model.request.Product;
import com.newsapi.bundle.model.request.Sale;
import com.newsapi.bundle.model.request.Shipping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sales", url = "${sales.api}")
public interface SalesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sales/{saleId}")
    Sale findSaleById(@PathVariable("saleId") Long saleId);

    @RequestMapping(method = RequestMethod.GET, value = "/products/{productId}")
    Product findProductById(@PathVariable("productId") Long productId);

    @RequestMapping(method = RequestMethod.GET, value = "/shipping/{saleId}")
    Shipping findShippingBySaleId(@PathVariable("saleId") Long saleId);
}