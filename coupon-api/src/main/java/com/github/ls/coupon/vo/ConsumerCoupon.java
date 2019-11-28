package com.github.ls.coupon.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.coupon.entity.UserCoupon;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class ConsumerCoupon implements Serializable {

    @Builder
    public ConsumerCoupon(@NotBlank String orderNo, @Valid @NotNull @Singular List<UserCoupon> coupons) {
        this.orderNo = orderNo;
        this.coupons = coupons;
    }

    @NotBlank
    @JsonProperty("order_no")
    private String orderNo;

    @Valid
    @NotNull
    @JsonProperty("coupons")
    private List<UserCoupon> coupons;


}
