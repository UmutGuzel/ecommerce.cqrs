package com.turkcell.ecommerce_cqrs.core.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest {
    List<String> getRequiredRoles();
}
