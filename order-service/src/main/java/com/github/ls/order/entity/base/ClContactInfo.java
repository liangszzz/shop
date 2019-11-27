package com.github.ls.order.entity.base;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cl_contact_info")
public class ClContactInfo implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "load_order_no", length = 50)
  @JsonProperty(value = "load_order_no")
  private String loadOrderNo;

  @Column(name = "biz_order_no", length = 50)
  @JsonProperty(value = "biz_order_no")
  private String bizOrderNo;

  @JsonProperty(value = "contact_name")
  @Column(name = "contact_name", length = 50)
  private String contactName;

  @JsonProperty(value = "contact_phone")
  @Column(name = "contact_phone", length = 11)
  private String contactPhone;

  @JsonProperty(value = "contact_relationship")
  @Column(name = "contact_relationship", length = 1)
  private String contactRelationship;

}
