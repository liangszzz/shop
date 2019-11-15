package com.github.ls.common.bind;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@Entity
@Table(name = "bank_user_sign")
public class BankUserSign {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "phone_no",length = 20)
  @JsonProperty(value = "phone_no")
  private String phoneNo;

  @Column(name = "user_name",length = 20)
  @JsonProperty(value = "user_name")
  private String userName;

  @Column(name = "id_card",length = 20)
  @JsonProperty(value = "id_card")
  private String idCard;

  @Column(name = "bank_card",length = 20)
  @JsonProperty(value = "bank_card")
  private String bankCard;

  @Column(name = "bank_code",length = 20)
  @JsonProperty(value = "bank_code")
  private String bankCode;

  @Column(name = "bank_name",length = 20)
  @JsonProperty(value = "bank_name")
  private String bankName;

  @Column(name = "signed_id",length = 20)
  @JsonProperty(value = "signed_id")
  private String signedId;

  @Column(name = "protocol_no",length = 20)
  @JsonProperty(value = "protocol_no")
  private String protocolNo;

  @Null
  @Column(name = "create_time")
  @JsonProperty(value = "create_time")
  private Date createTime;

  @Null
  @Column(name = "update_time")
  @JsonProperty(value = "update_time")
  private Date updateTime;


}
