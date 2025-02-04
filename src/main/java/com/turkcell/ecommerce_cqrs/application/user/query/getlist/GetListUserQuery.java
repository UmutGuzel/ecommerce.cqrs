package com.turkcell.ecommerce_cqrs.application.user.query.getlist;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.application.user.mapper.UserMapper;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.ecommerce_cqrs.core.pipelines.auth.AuthorizedRequest;
import com.turkcell.ecommerce_cqrs.domain.entity.User;
import com.turkcell.ecommerce_cqrs.persistance.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

public class GetListUserQuery implements Command<List<GetListUserDto>>, AuthenticatedRequest {
    @Component
    @RequiredArgsConstructor
    public static class GetListBookQueryHandler implements Command.Handler<GetListUserQuery, List<GetListUserDto>>{
        private final UserRepository userRepository;
        private final UserMapper userMapper;

        @Override
        public List<GetListUserDto> handle(GetListUserQuery getListUserQuery) {
            List<User> users = userRepository.findAll();
            return userMapper.toListUserDto(users);
        }
    }
}
