package com.newsapi.bundle.model.dto;

import com.newsapi.bundle.model.request.Sale;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleDTO {
    private Long id;
    private String code;

    public SaleDTO toDTO(Sale sale){
        id = sale.getId();
        code = sale.getSaleCode();
        return this;
    }
}
