package com.example.art.service;

import com.example.art.model.Delivery;
import static com.example.art.model.Delivery.DELIVERED;
import com.example.art.model.ProductInfo;
import com.example.art.model.ProductType;
import static com.example.art.model.ProductType.ELECTRONIC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductGenerationService {
    private static final Random RANDOM = new Random();

    private static final List<String> productTitles = List.of(
            "UltraHD 4K Smart LED TV with Voice Control",
            "Wireless Noise-Cancelling Over-Ear Headphones",
            "Ergonomic Adjustable Office Chair with Lumbar Support",
            "High-Speed Blender with Multiple Settings and BPA-Free Jar",
            "Portable Power Bank with Fast Charging Technology",
            "Stainless Steel Multi-Cooker with Digital Display",
            "Water-Resistant Fitness Tracker with Heart Rate Monitor",
            "Cordless Stick Vacuum Cleaner with HEPA Filter",
            "Smart Wi-Fi Video Doorbell with Motion Detection",
            "Eco-Friendly Bamboo Cutting Board Set with Juice Grooves",
            "Premium Memory Foam Mattress with Cooling Gel",
            "Bluetooth Car Adapter with Hands-Free Calling and Music Streaming",
            "Outdoor Solar LED Pathway Lights with Auto On/Off",
            "Non-Stick Cookware Set with Heat-Resistant Handles",
            "Compact Travel Laptop Backpack with USB Charging Port",
            "Electric Adjustable Standing Desk with Memory Presets",
            "Portable Bluetooth Speaker with Deep Bass and Long Battery Life",
            "Professional-Grade Stainless Steel Chef Knife Set with Wooden Block",
            "High-Resolution Wireless Security Camera System with Night Vision",
            "Heavy-Duty Waterproof Tent with Easy Setup and Spacious Interior",
            "Digital Air Fryer with Pre-Programmed Settings and Timer",
            "Advanced Hair Dryer with Ionic Technology and Diffuser",
            "Smart Home Thermostat with Remote Access and Energy Saving Mode",
            "Luxury Egyptian Cotton Bath Towel Set with High Absorbency",
            "Electric Pressure Washer with Adjustable Nozzle and Detergent Tank"
    );


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
        productInfo.setTitle(productTitles.get(RANDOM.nextInt(productTitles.size())));
        productInfo.setDelivery(Delivery.values()[RANDOM.nextInt(Delivery.values().length)]);
        productInfo.setOrderedDaysAgo(RANDOM.nextInt(30));
        productInfo.setWarrantyDaysTotal(RANDOM.nextInt(365));
        productInfo.setTrackAndTraceUrl("http://postnl.nl/tracktrace/?B=" + RANDOM.nextInt(10000000));
        productInfo.setProductType(ProductType.values()[RANDOM.nextInt(ProductType.values().length)]);
        return productInfo;
    }
}
