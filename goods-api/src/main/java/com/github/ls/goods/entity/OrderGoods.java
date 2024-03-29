package com.github.ls.goods.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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

    @JsonProperty("goods_no")
    @NotBlank
    @Column(name = "goods_no", length = 50)
    private String goodsNo;

    @JsonProperty("goods_number")
    @Min(value = 1)
    @Column(name = "goods_number")
    private Long goodsNumber;

    @JsonProperty("goods_price")
    @DecimalMin(value = "0.01")
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;
}
