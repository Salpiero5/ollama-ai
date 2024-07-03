package com.example.art.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductInfo {
    private String title;
    private Delivery delivery;
    private int orderedDaysAgo;
    private int warrantyDaysTotal;
    private String trackAndTraceUrl;
    private ProductType productType;
}
