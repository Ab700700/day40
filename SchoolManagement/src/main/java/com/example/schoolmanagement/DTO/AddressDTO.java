package com.example.schoolmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacherid;
    private String area;
    private String street;
    private String buildingNumber;
}
