package com.github.ls.coupon.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.coupon.entity.UserCoupon;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ConsumerCoupon implements Serializable {

    @NotBlank
    @JsonProperty("order_no")
    private String orderNo;

    @Valid
    @NotNull
    @JsonProperty("coupons")
    private List<UserCoupon> coupons;


}
