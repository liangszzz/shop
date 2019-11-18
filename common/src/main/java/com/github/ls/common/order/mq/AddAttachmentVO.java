package com.github.ls.common.order.mq;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.common.order.ClAttachmentInfo;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class AddAttachmentVO implements Serializable {

    public AddAttachmentVO() {
    }

    public AddAttachmentVO(String order_no, List<ClAttachmentInfo> list) {
        this.order_no = order_no;
        this.list = list;
    }

    @NotBlank
    @JsonProperty(value = "order_no")
    private String order_no;

    @Valid
    @NotNull
    @JsonProperty(value = "attachment_info")
    private List<ClAttachmentInfo> list;
}
