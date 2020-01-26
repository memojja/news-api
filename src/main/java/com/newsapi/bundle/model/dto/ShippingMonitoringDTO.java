package com.newsapi.bundle.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShippingMonitoringDTO {
    private String status;
    private SaleDTO sale;
    private ProductDTO product;
}
