package com.newsapi.bundle.service;

import com.newsapi.bundle.cache.ShippingMonitorCache;
import com.newsapi.bundle.client.SalesClient;
import com.newsapi.bundle.model.dto.DeliverStatus;
import com.newsapi.bundle.model.dto.ProductDTO;
import com.newsapi.bundle.model.dto.SaleDTO;
import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import com.newsapi.bundle.model.request.Product;
import com.newsapi.bundle.model.request.Sale;
import com.newsapi.bundle.model.request.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShippingMonitoringProxy {

    private final SalesClient salesClient;

    private final ShippingMonitorCache shippingMonitorCache;

    @Autowired
    public ShippingMonitoringProxy(SalesClient salesClient, ShippingMonitorCache shippingMonitorCache) {
        this.salesClient = salesClient;
        this.shippingMonitorCache = shippingMonitorCache;
    }

    public ShippingMonitoringDTO getShippingMonitoring(Long saleId) {
        Optional<ShippingMonitoringDTO> shippingMonitoringDTO = shippingMonitorCache.getShippingMonitoringDTOBySaleId(saleId);

        return shippingMonitoringDTO.orElseGet(() -> {
            ShippingMonitoringDTO response = getRemoteShippingMonitoringDTO(saleId);
            shippingMonitorCache.addShippingMonitoringDTO(saleId,response);
            return response;
        });

    }

    private ShippingMonitoringDTO getRemoteShippingMonitoringDTO(Long saleId){
        Sale sale = salesClient.findSaleById (saleId);
        Product product = salesClient.findProductById (sale.getProductId());
        Shipping shipping = salesClient.findShippingBySaleId (saleId);
        return ShippingMonitoringDTO.builder()
                .sale(new SaleDTO().toDTO(sale))
                .product(new ProductDTO().toDTO(product))
                .status(shipping.getStatus() ? DeliverStatus.COMPLETED.value() : DeliverStatus.NOT_COMPLETED.value())
                .build();
    }
}
