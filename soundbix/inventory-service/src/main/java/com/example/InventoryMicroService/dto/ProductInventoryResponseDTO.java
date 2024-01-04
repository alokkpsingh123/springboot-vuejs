package com.example.InventoryMicroService.dto;

import com.example.InventoryMicroService.entity.Merchant;
import lombok.Data;

@Data
public class ProductInventoryResponseDTO {
    private String id;

    private String productId;

    private int stock;
    private double price;
    private float discount;
    private Merchant merchant1;
}
