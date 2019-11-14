package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "cl_user_info")
public class ClUserInfo implements Serializable {

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
    
    private String userName;
    private String gender;
    private String idcardAddress;
    private String idcard;
    private String phoneNo;
    private String identityType;
    private String idcardPhotoPath;
    private String healthStatus;
    private String degree;
    private String colleges;
    private String major;
    private String residentialAddress;
    private String maritalStatus;
    private String companyName;
    private String branchName;
    private String companyPhoneNo;
    private String companyAddress;
    private String bankAccount;
    private String bankCardType;
    private String reservePhoneNo;
    private String bankName;
    private BigDecimal personalIncome;
    private BigDecimal monthlyExpenditure;
    private String qq;
    private String wechat;
    private String bankProvince;
    private String bankCity;
    private String bankSubBranchName;
    private String bankCode;
    private String customerProfessionalInfo;
    private Date certificateExpiryDate;

}
