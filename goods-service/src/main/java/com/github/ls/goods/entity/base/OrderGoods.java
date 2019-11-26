package com.github.ls.goods.entity.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shop_order_goods")
public class OrderGoods implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("order_no")
    @NotBlank
    @Column(name = "order_no", length = 50)
    private String orderNo;

    @JsonProperty("goods_id")
    @NotBlank
    @Column(name = "goods_id", length = 50)
    private String goodsId;

    @JsonProperty("goods_number")
    @Min(value = 1)
    @Column(name = "goods_number")
    private Long goodsNumber;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;
}
