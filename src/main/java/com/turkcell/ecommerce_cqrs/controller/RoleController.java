package com.turkcell.ecommerce_cqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.ecommerce_cqrs.application.role.command.create.CreateRoleCommand;
import com.turkcell.ecommerce_cqrs.application.role.command.create.CreateRoleResponse;
import com.turkcell.ecommerce_cqrs.application.role.query.get_all.GetRoleListQuery;
import com.turkcell.ecommerce_cqrs.application.role.query.get_all.RoleDto;
import com.turkcell.ecommerce_cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends BaseController {
    public RoleController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRoleResponse add(@RequestBody CreateRoleCommand createRoleCommand) {
        return createRoleCommand.execute(pipeline);
    }

    @GetMapping("/all")
    public List<RoleDto> getAll(@RequestBody GetRoleListQuery getRoleListQuery) {
        return getRoleListQuery.execute(pipeline);
    }
}
