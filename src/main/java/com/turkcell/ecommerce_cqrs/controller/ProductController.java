package com.turkcell.ecommerce_cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs3.application.product.command.create.CreateProductCommand;
import com.turkcell.turkcellcqrs3.application.product.command.create.CreatedProductResponse;
import com.turkcell.turkcellcqrs3.application.product.command.delete.DeleteProductCommand;
import com.turkcell.turkcellcqrs3.application.product.command.delete.DeletedProductResponse;
import com.turkcell.turkcellcqrs3.application.product.command.update.UpdateProductCommand;
import com.turkcell.turkcellcqrs3.application.product.command.update.UpdatedProductResponse;
import com.turkcell.turkcellcqrs3.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends BaseController {


    public ProductController(Pipeline pipeline) {
        super(pipeline);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedProductResponse create(@RequestBody CreateProductCommand createProductCommand) {
        return  createProductCommand.execute(pipeline);
    }
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public UpdatedProductResponse update(@RequestBody UpdateProductCommand updateProductCommand) {
        return updateProductCommand.execute(pipeline);
    }
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public DeletedProductResponse delete(@RequestBody DeleteProductCommand deleteProductCommand) {
        return deleteProductCommand.execute(pipeline);
    }



}
