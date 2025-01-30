package com.turkcell.ecommerce_cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<CartItem> cartItems;



}
