package com.example.art.service;

import com.example.art.model.Delivery;
import static com.example.art.model.Delivery.DELIVERED;
import com.example.art.model.ProductInfo;
import com.example.art.model.ProductType;
import static com.example.art.model.ProductType.ELECTRONIC;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProductGenerationService {
    private static final Random RANDOM = new Random();
    public ProductInfo getDefault() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setTitle("Bol Hackathon fun package");
        productInfo.setDelivery(DELIVERED);
        productInfo.setOrderedDaysAgo(1);
        productInfo.setWarrantyDaysTotal(365);
        productInfo.setTrackAndTraceUrl("https://postnl.nl/tracktrace/?B=0987654321");
        productInfo.setProductType(ELECTRONIC);
        return productInfo;
    }
    public ProductInfo getRandom() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setTitle("Bol Hackathon product" + RANDOM.nextInt(1000));
        productInfo.setDelivery(Delivery.values()[RANDOM.nextInt(Delivery.values().length)]);
        productInfo.setOrderedDaysAgo(RANDOM.nextInt(30));
        productInfo.setWarrantyDaysTotal(RANDOM.nextInt(365));
        productInfo.setTrackAndTraceUrl("http://postnl.nl/tracktrace/?B=" + RANDOM.nextInt(10000000));
        productInfo.setProductType(ProductType.values()[RANDOM.nextInt(ProductType.values().length)]);
        return productInfo;
    }
}
