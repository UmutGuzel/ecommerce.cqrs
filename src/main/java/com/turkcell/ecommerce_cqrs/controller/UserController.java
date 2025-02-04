package com.turkcell.ecommerce_cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.ecommerce_cqrs.application.user.command.change_password.ChangePasswordCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.change_password.ChangePasswordResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.create.CreatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.delete.DeleteUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.delete.DeletedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.login.LoginCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.login.LoginCommandResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdateUserCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update.UpdatedUserResponse;
import com.turkcell.ecommerce_cqrs.application.user.command.update_user_role.UpdateUserRoleCommand;
import com.turkcell.ecommerce_cqrs.application.user.command.update_user_role.UpdateUserRoleResponse;
import com.turkcell.ecommerce_cqrs.application.user.query.getlist.GetListUserDto;
import com.turkcell.ecommerce_cqrs.application.user.query.getlist.GetListUserQuery;
import com.turkcell.ecommerce_cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {
    public UserController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedUserResponse create(@RequestBody CreateUserCommand createUserCommand) {
        return createUserCommand.execute(pipeline);
    }
    @PutMapping
    @ResponseStatus(code=HttpStatus.OK)
    public UpdatedUserResponse update(@RequestBody UpdateUserCommand updateUserCommand) {
        return updateUserCommand.execute(pipeline);
    }

    @PutMapping("/change-password")
    @ResponseStatus(code=HttpStatus.OK)
    public ChangePasswordResponse changePassword(@RequestBody ChangePasswordCommand changePasswordCommand) {
        return changePasswordCommand.execute(pipeline);
    }

    @PutMapping("/change-role")
    @ResponseStatus(code=HttpStatus.OK)
    public UpdateUserRoleResponse changeRole(@RequestBody UpdateUserRoleCommand updateUserRoleCommand) {
        return updateUserRoleCommand.execute(pipeline);
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetListUserDto> getList(@RequestBody GetListUserQuery getListUserQuery) {
        return getListUserQuery.execute(pipeline);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public LoginCommandResponse login(@RequestBody LoginCommand loginCommand) {
        return loginCommand.execute(pipeline);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public DeletedUserResponse delete(@RequestBody DeleteUserCommand deleteUserCommand) {
        return deleteUserCommand.execute(pipeline);
    }


}
