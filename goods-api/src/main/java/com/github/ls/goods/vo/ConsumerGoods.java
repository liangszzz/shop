package com.github.ls.goods.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.goods.entity.Goods;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ConsumerGoods implements Serializable {

    @Builder
    public ConsumerGoods(@NotBlank String orderNo, @NotNull @Valid @Singular List<Goods> goods) {
        this.orderNo = orderNo;
        this.goods = goods;
    }

    @NotBlank
    @JsonProperty("order_no")
    private String orderNo;


    @NotNull
    @Valid
    @JsonProperty("goods")
    private List<Goods> goods;


}
