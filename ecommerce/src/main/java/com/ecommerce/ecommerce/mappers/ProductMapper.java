package com.ecommerce.ecommerce.mappers;

import com.ecommerce.ecommerce.dto.*;
import com.ecommerce.ecommerce.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "sizes", target = "sizes")
    @Mapping(source = "colors", target = "colors")
    ProductDto toProductDto(Product product);

    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "sizes", target = "sizes")
    @Mapping(source = "colors", target = "colors")
    Product toProductEntity(ProductDto productDto);

    default List<CategoryDto> mapCategoriesToDto(List<Category> categories) {
        return categories.stream()
                .map(cat -> new CategoryDto(cat.getId(), cat.getCategory()))
                .collect(Collectors.toList());
    }

    default List<SizeDto> mapSizesToDto(List<Size> sizes) {
        return sizes.stream()
                .map(size -> new SizeDto(size.getId(), size.getSize()))
                .collect(Collectors.toList());
    }

    default List<ColorDto> mapColorsToDto(List<Color> colors) {
        return colors.stream()
                .map(color -> new ColorDto(color.getId(), color.getColor()))
                .collect(Collectors.toList());
    }

    default BrandDto mapBrandToDto(Brand brand) {
        return new BrandDto(brand.getId(), brand.getBrand());
    }
}