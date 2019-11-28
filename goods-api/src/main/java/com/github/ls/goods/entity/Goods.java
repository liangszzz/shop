package com.github.ls.goods.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
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
@Table(name = "shop_goods")
public class Goods implements Serializable {

    @Builder
    public Goods(@NotBlank String goodsNo, @NotBlank String goodsName, @Min(value = 1) Long goodsNumber, @DecimalMin(value = "0.01") BigDecimal goodsPrice, @Min(value = 0) Integer goodsStatus, LocalDateTime createDateTime) {
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.goodsNumber = goodsNumber;
        this.goodsPrice = goodsPrice;
        this.goodsStatus = goodsStatus;
        this.createDateTime = createDateTime;
    }

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
