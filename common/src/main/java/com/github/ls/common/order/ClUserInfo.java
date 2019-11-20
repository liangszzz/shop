package com.github.ls.common.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "cl_user_info")
public class ClUserInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "load_order_no", length = 50, unique = true)
    @JsonProperty(value = "load_order_no")
    private String loadOrderNo;

    @Column(name = "biz_order_no", length = 50, unique = true)
    @JsonProperty(value = "biz_order_no")
    private String bizOrderNo;

    @JsonProperty(value = "user_name")
    @Column(name = "user_name", length = 50)
    private String userName;

    @JsonProperty(value = "gender")
    @Column(name = "gender", length = 50)
    private String gender;

    @JsonProperty(value = "idcard_address")
    @Column(name = "idcard_address", length = 50)
    private String idcardAddress;

    @JsonProperty(value = "idcard")
    @Column(name = "idcard", length = 50)
    private String idcard;

    @JsonProperty(value = "phone_no")
    @Column(name = "phone_no", length = 50)
    private String phoneNo;

    @JsonProperty(value = "identity_type")
    @Column(name = "identity_type", length = 50)
    private String identityType;

    @JsonProperty(value = "idcard_photo_path")
    @Column(name = "idcard_photo_path", length = 50)
    private String idcardPhotoPath;

    @JsonProperty(value = "health_status")
    @Column(name = "health_status", length = 50)
    private String healthStatus;

    @JsonProperty(value = "degree")
    @Column(name = "degree", length = 50)
    private String degree;

    @JsonProperty(value = "colleges")
    @Column(name = "colleges", length = 50)
    private String colleges;

    @JsonProperty(value = "major")
    @Column(name = "major", length = 50)
    private String major;

    @JsonProperty(value = "residential_address")
    @Column(name = "residential_address", length = 50)
    private String residentialAddress;

    @JsonProperty(value = "marital_status")
    @Column(name = "marital_status", length = 50)
    private String maritalStatus;

    @JsonProperty(value = "company_name")
    @Column(name = "company_name", length = 50)
    private String companyName;

    @JsonProperty(value = "branch_name")
    @Column(name = "branch_name", length = 50)
    private String branchName;

    @JsonProperty(value = "company_phone_no")
    @Column(name = "company_phone_no", length = 50)
    private String companyPhoneNo;

    @JsonProperty(value = "company_address")
    @Column(name = "company_address", length = 50)
    private String companyAddress;

    @JsonProperty(value = "bank_account")
    @Column(name = "bank_account", length = 50)
    private String bankAccount;

    @JsonProperty(value = "bank_card_type")
    @Column(name = "bank_card_type", length = 50)
    private String bankCardType;

    @JsonProperty(value = "reserve_phone_no")
    @Column(name = "reserve_phone_no", length = 50)
    private String reservePhoneNo;

    @JsonProperty(value = "bank_name")
    @Column(name = "bank_name", length = 50)
    private String bankName;

    @JsonProperty(value = "personal_income")
    @Column(name = "personal_income", length = 50)
    private BigDecimal personalIncome;

    @JsonProperty(value = "monthly_expenditure")
    @Column(name = "monthly_expenditure", length = 50)
    private BigDecimal monthlyExpenditure;

    @JsonProperty(value = "qq")
    @Column(name = "qq", length = 50)
    private String qq;

    @JsonProperty(value = "wechat")
    @Column(name = "wechat", length = 50)
    private String wechat;

    @JsonProperty(value = "bank_province")
    @Column(name = "bank_province", length = 50)
    private String bankProvince;

    @JsonProperty(value = "bank_city")
    @Column(name = "bank_city", length = 50)
    private String bankCity;

    @JsonProperty(value = "bank_sub_branch_name")
    @Column(name = "bank_sub_branch_name", length = 50)
    private String bankSubBranchName;

    @JsonProperty(value = "bank_code")
    @Column(name = "bank_code", length = 50)
    private String bankCode;

    @JsonProperty(value = "customer_professional_info")
    @Column(name = "customer_professional_info", length = 50)
    private String customerProfessionalInfo;

    @JsonFormat(timezone = "yyyy-MM-dd")
    @JsonProperty(value = "certificate_expiry_date")
    @Column(name = "certificate_expiry_date", length = 50)
    private Date certificateExpiryDate;

}
