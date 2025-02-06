package com.turkcell.ecommerce_cqrs.application.category.mapper;


import com.turkcell.ecommerce_cqrs.application.category.command.create.CreateCategoryCommand;
import com.turkcell.ecommerce_cqrs.application.category.command.create.CreatedCategoryResponse;
import com.turkcell.ecommerce_cqrs.domain.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);

    //ManuelMapping
    //CreateCategoryCommand ->Category elde etmek istiyorum Source->CreateCategoryCommand Target ->Category
    //Mapstruct yapısında otomatik yapmak için target türünde method üretiyorum
    //Çünkü bu method ortaya bir Category çıkartmalı
    //kaynak olarak ne kullanıcağıno da içine yazıyorum
    //Target fonksiyon_ismi(Source s);
    //burada isimen aynı ise otomatik commandlicek
    //peki isimen aynı değil ne yapacağiz
    //bunu biz belirtiyoruz şu şekilde
    //@Mapping(source="title",target="name") gibi kaynağın titile ı targıtın name i oluyor

    Category convertCreateCategoryCommandToCategory(CreateCategoryCommand createCategoryCommand);
    CreatedCategoryResponse convertCategoryToCreatedCategoryResponse(Category category);



}
