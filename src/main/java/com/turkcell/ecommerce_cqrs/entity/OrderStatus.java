package com.turkcell.ecommerce_cqrs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_statuses")
public class OrderStatus {
    @Id
    @UuidGenerator
    private UUID id;


    private String status;

    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
    private List<Order> orders;
}
