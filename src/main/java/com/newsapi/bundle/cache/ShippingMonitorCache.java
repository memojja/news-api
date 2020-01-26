package com.newsapi.bundle.cache;

import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;

import java.util.Optional;

public interface ShippingMonitorCache {
    Optional<ShippingMonitoringDTO> getShippingMonitoringDTOBySaleId(Long saleId);
    void addShippingMonitoringDTO(Long saleId,ShippingMonitoringDTO shippingMonitoringDTO);
}
