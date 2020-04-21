package com.paypal.mappers;

import com.paypal.product.Product;
import com.paypal.product.ProductDTO;

public class ProductMapper {
    public static Product toEntity(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getQuantity()
        );
    }

    public static ProductDTO toDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity()
        );
    }

}
