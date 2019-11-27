package com.github.ls.order.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.order.entity.base.ClAttachmentInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AddAttachmentVO implements Serializable {

    @NotBlank
    @JsonProperty(value = "order_no")
    private String order_no;

    @Valid
    @NotNull
    @JsonProperty(value = "attachment_info")
    private List<ClAttachmentInfo> list;
}
