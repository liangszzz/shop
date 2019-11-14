package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Table(name = "cl_contact_info")
public class ClContactInfo implements Serializable {
  @Id
  @GeneratedValue
  private long id;

  @NotBlank
  @Column(name = "load_order_no", length = 50, unique = true)
  @JSONField(name = "load_order_no")
  private String loadOrderNo;

  @NotBlank
  @Column(name = "biz_order_no", length = 50, unique = true)
  @JSONField(name = "biz_order_no")
  private String bizOrderNo;

  @NotBlank
  @JSONField(name = "contact_name")
  @Column(name = "contact_name", length = 50)
  private String contactName;

  @NotBlank
  @JSONField(name = "contact_phone")
  @Column(name = "contact_phone", length = 11)
  private String contactPhone;

  @NotBlank
  @JSONField(name = "contact_relationship")
  @Column(name = "contact_relationship", length = 1)
  private String contactRelationship;

}
