package com.turkcell.ecommerce_cqrs.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private String createdAt;
    private String updatedAt;


    @JsonBackReference
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="parentCategory")
    private Category parentCategory;



    @OneToMany(mappedBy="parentCategory")
    private Set<Category> linkedCategory = new HashSet<Category>();

}
