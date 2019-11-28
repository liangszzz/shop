package com.github.ls.order.dao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.goods.entity.Goods;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderSubmitVO implements Serializable {

    @Builder
    public OrderSubmitVO(@Valid @NotNull @Singular List<UserCoupon> coupons, @Valid @NotNull @Singular List<Goods> goods) {
        this.coupons = coupons;
        this.goods = goods;
    }

    @Valid
    @NotNull
    @JsonProperty("coupons")
    private List<UserCoupon> coupons;

    @Valid
    @NotNull
    @JsonProperty("goods")
    private List<Goods> goods;

}
