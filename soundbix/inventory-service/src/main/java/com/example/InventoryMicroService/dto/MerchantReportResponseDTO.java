package com.example.InventoryMicroService.dto;

import com.example.InventoryMicroService.entity.Merchant;
import lombok.Data;

@Data
public class MerchantReportResponseDTO {
    private String id;
    private String productId;
    private int totalStock;
    private int totalSale;
    private int currentStock;
    private int merchantRating;
    private Merchant merchant;
}
