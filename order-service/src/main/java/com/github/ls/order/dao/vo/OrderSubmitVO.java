package com.github.ls.order.dao.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.goods.entity.Goods;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class OrderSubmitVO implements Serializable {

    @Valid
    @NotNull
    @JsonProperty("coupons")
    private List<UserCoupon> coupons;

    @Valid
    @NotNull
    @JsonProperty("goods")
    private List<Goods> goods;

}
