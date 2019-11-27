package com.github.ls.coupon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_order_coupon")
public class OrderCoupon implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("order_no")
    @Column(name = "order_no", length = 50)
    private String orderNo;

    @JsonProperty("coupon_no")
    @Column(name = "coupon_no", length = 50)
    private String couponNo;

    @JsonProperty("coupon_number")
    @Column(name = "coupon_number")
    private Long couponNumber;

    @JsonProperty("coupon_amount")
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;
}
