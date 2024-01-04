package com.example.InventoryMicroService.dto;

import com.example.InventoryMicroService.entity.MerchantReport;
import com.example.InventoryMicroService.entity.ProductInventory;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class MerchantResponseDTO {
    String id;
    String merchantName;
    String dateOfJoining;
    private Set<MerchantReport> merchantReportList= new HashSet<>();
    private Set<ProductInventory> productInventoriesList= new HashSet<>();
}
