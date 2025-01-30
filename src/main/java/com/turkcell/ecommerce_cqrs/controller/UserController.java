package com.turkcell.ecommerce_cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.ecommerce_cqrs.application.user.create.CreateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.create.CreatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.delete.DeleteUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.delete.DeletedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.update.UpdateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.update.UpdatedUserResponse;
import com.turkcell.ecommerce_cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {


    public UserController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedUserResponse create(@RequestBody CreateUserCommand createUserCommand) {

        return createUserCommand.execute(pipeline);
    }
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public UpdatedUserResponse update(@RequestBody UpdateUserCommand updateUserCommand) {
        return updateUserCommand.execute(pipeline);
    }
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public DeletedUserResponse delete(@RequestBody DeleteUserCommand deleteUserCommand) {
        return deleteUserCommand.execute(pipeline);
    }


}
