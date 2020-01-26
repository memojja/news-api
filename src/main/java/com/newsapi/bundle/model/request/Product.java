package com.newsapi.bundle.model.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String category;
    private String name;
    private BigDecimal price;
    private String image;
}
