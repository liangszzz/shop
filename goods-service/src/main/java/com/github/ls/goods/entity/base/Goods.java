package com.github.ls.goods.entity.base;

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
@Table(name = "shop_goods")
public class Goods implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("goods_no")
    @NotBlank
    @Column(name = "goods_no", length = 50, unique = true)
    private String goodsNo;

    @JsonProperty("goods_name")
    @NotBlank
    @Column(name = "goods_name", length = 50)
    private String goodsName;

    @JsonProperty("goods_number")
    @Min(value = 1)
    @Column(name = "goods_number")
    private Long goodsNumber;

    @JsonProperty("goods_price")
    @DecimalMin(value = "0.01")
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    @JsonProperty("goods_status")
    @Min(value = 0)
    @Column(name = "goods_status")
    private Integer goodsStatus;

    @JsonProperty("create_date_time")
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    public Goods addGoodsNumber(Long number) {
        this.goodsNumber += number;
        return this;
    }
}
