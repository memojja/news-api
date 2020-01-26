package com.newsapi.bundle.controller;

import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import com.newsapi.bundle.service.ShippingMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingMonitoringController {

    private final ShippingMonitoringService shippingMonitoringService;

    @Autowired
    public ShippingMonitoringController(ShippingMonitoringService shippingMonitoringService) {
        this.shippingMonitoringService = shippingMonitoringService;
    }

    @GetMapping("/sale/{saleId}/shipping")
    public ShippingMonitoringDTO get(@PathVariable Long saleId){
        return shippingMonitoringService.getShippingMonitorBySaleId(saleId);
    }

//    @Override
//    public CompletableFuture <ResponseEntity <ShippingStatusResponse>> getShippingMonitorBySaleId(Long saleId) {
//
//        ShippingStatusResponse shippingStatusBySale = shippingStatusService.getShippingMonitorBySaleId (saleId);
//        return CompletableFuture.completedFuture (ResponseEntity.ok (shippingStatusBySale));
//
//    }

}
