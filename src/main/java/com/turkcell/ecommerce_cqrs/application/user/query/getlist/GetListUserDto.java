package com.turkcell.ecommerce_cqrs.application.user.query.getlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListUserDto {
   private UUID id;
   private String name;
}
