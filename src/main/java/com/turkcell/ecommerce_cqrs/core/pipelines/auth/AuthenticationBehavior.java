package com.turkcell.ecommerce_cqrs.core.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationBehavior implements Command.Middleware {
    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        if (c instanceof AuthenticatedRequest || c instanceof AuthorizedRequest) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated())
                throw new SecurityException("User is not authenticated");

            if (c instanceof AuthorizedRequest) {
                boolean hasRole = auth.getAuthorities().stream().anyMatch(
                        role -> (((AuthorizedRequest) c).getRequiredRoles().stream().anyMatch(
                                req -> req.equals(role.getAuthority()))));

                if (!hasRole)
                    throw new SecurityException("User is not authorized");
            }
        }
        return next.invoke();
    }
}
