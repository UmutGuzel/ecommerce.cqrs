package com.turkcell.ecommerce_cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.ecommerce_cqrs.application.category.command.create.CreateCategoryCommand;
import com.turkcell.ecommerce_cqrs.application.category.command.create.CreateSubCategoryCommand;
import com.turkcell.ecommerce_cqrs.application.category.command.create.CreateSubCategoryResponse;
import com.turkcell.ecommerce_cqrs.application.category.command.create.CreatedCategoryResponse;
import com.turkcell.ecommerce_cqrs.application.category.command.delete.DeleteCategoryCommand;
import com.turkcell.ecommerce_cqrs.application.category.command.delete.DeletedCategoryResponse;
import com.turkcell.ecommerce_cqrs.application.category.command.update.UpdatedCategoryCommand;
import com.turkcell.ecommerce_cqrs.application.category.command.update.UpdatedCategoryResponse;
import com.turkcell.ecommerce_cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//TODO:GETMAPPİNG
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController {


    public CategoryController(Pipeline pipeline) {
        super(pipeline);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedCategoryResponse create(@RequestBody CreateCategoryCommand createCategoryCommand) {
        return  createCategoryCommand.execute(pipeline);
    }
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public UpdatedCategoryResponse update(@RequestBody UpdatedCategoryCommand updatedCategoryCommand) {
        return  updatedCategoryCommand.execute(pipeline);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public DeletedCategoryResponse delete(@RequestBody DeleteCategoryCommand deleteCategoryCommand) {
        return  deleteCategoryCommand.execute(pipeline);
    }
    @PostMapping("/{parentId}/subcategories")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateSubCategoryResponse addSubcategory(@RequestBody CreateSubCategoryCommand createSubCategoryCommand) {
        return createSubCategoryCommand.execute(pipeline);


    }


}
