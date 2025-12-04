package com.samuelaptech.newstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Long id;
    @JsonProperty("product_name")
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
