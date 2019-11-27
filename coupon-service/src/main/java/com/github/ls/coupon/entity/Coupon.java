package com.github.ls.coupon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_coupon")
public class Coupon implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @JsonProperty("coupon_no")
    @Column(name = "coupon_no", length = 50, unique = true)
    private String couponNo;

    @NotBlank
    @JsonProperty("coupon_name")
    @Column(name = "coupon_name", length = 50)
    private String couponName;

    @Min(value = 1)
    @JsonProperty("coupon_number")
    @Column(name = "coupon_number")
    private Long couponNumber;

    @JsonProperty("username")
    @Column(name = "username")
    private String username;

    @DecimalMin(value = "0.01")
    @JsonProperty("coupon_amount")
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;

    @Min(value = 0)
    @JsonProperty("coupon_status")
    @Column(name = "coupon_status")
    private Integer couponStatus;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;
}
