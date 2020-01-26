package com.newsapi.bundle.model.dto;

import com.newsapi.bundle.model.request.Product;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductDTO toDTO(Product product){
        id = product.getId();
        price = product.getPrice();
        name = product.getName();
        return this;
    }
}
