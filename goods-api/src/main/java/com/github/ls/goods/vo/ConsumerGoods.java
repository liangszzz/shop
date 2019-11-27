package com.github.ls.goods.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.goods.entity.Goods;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class ConsumerGoods implements Serializable {

    @NotBlank
    @JsonProperty("order_no")
    private String orderNo;


    @NotNull
    @Valid
    @JsonProperty("goods")
    private List<Goods> goods;


}
