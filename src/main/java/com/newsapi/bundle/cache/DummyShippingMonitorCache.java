package com.newsapi.bundle.cache;

import com.newsapi.bundle.model.dto.ShippingMonitoringDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Primary
public class DummyShippingMonitorCache implements ShippingMonitorCache {


    /**
     * TODO it will be replace redis or hazelcast. and will be add ttl parameter.
      */
    private ConcurrentHashMap<Long,ShippingMonitoringDTO> inMemory = new ConcurrentHashMap<>();


    @Override
    public Optional<ShippingMonitoringDTO> getShippingMonitoringDTOBySaleId(Long saleId) {
        return Optional.ofNullable(inMemory.get(saleId));
    }

    @Override
    public void addShippingMonitoringDTO(Long saleId, ShippingMonitoringDTO shippingMonitoringDTO) {
        inMemory.put(saleId,shippingMonitoringDTO);
    }
}
