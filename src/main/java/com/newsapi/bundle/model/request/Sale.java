package com.newsapi.bundle.model.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private String saleCode;
    private Long productId;
}
