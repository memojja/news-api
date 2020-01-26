package com.newsapi.bundle.model.request;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {
    private Long saleId;
    private Boolean status;
    private Timestamp createdAt;
}
