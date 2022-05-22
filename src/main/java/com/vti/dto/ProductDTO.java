package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ProductDTO {


    private Integer id;

    private String productName;

    private String price;

    private String quantity;

    private String categoryName;
}
