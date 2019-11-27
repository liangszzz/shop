package com.github.ls.order.entity.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("order_no")
    @NotBlank
    @Column(name = "order_no", length = 50, unique = true)
    private String orderNo;

    @NotBlank
    @JsonProperty("username")
    @Column(name = "username")
    private String username;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

}
