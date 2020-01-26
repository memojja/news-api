package com.newsapi.bundle.service;

import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShippingMonitoringService {

    private final ShippingMonitoringProxy shippingMonitoringProxy;

    @Autowired
    public ShippingMonitoringService(ShippingMonitoringProxy shippingMonitoringProxy) {
        this.shippingMonitoringProxy = shippingMonitoringProxy;
    }

    public ShippingMonitoringDTO getShippingMonitorBySaleId(Long saleId) {
        return shippingMonitoringProxy.getShippingMonitoring(saleId);
    }

}
