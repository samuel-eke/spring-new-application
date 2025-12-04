package com.samuelaptech.newstore.mappers;

import com.samuelaptech.newstore.dto.ProductDTO;
import com.samuelaptech.newstore.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDTO productToProductDTO(Product product);
}
