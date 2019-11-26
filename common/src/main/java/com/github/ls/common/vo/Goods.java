package com.github.ls.common.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class Goods implements Serializable {

    private String goodsId;

    private String goodsName;

    private Long goodsNumber;

    private LocalDateTime createDateTime;

}
