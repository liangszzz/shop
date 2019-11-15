package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
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

    @JSONField(name = "user_name")
    @Column(name = "user_name", length = 50)
    private String userName;

    @JSONField(name = "gender")
    @Column(name = "gender", length = 50)
    private String gender;

    @JSONField(name = "idcard_address")
    @Column(name = "idcard_address", length = 50)
    private String idcardAddress;

    @JSONField(name = "idcard")
    @Column(name = "idcard", length = 50)
    private String idcard;

    @JSONField(name = "phone_no")
    @Column(name = "phone_no", length = 50)
    private String phoneNo;

    @JSONField(name = "identity_type")
    @Column(name = "identity_type", length = 50)
    private String identityType;

    @JSONField(name = "idcard_photo_path")
    @Column(name = "idcard_photo_path", length = 50)
    private String idcardPhotoPath;

    @JSONField(name = "health_status")
    @Column(name = "health_status", length = 50)
    private String healthStatus;

    @JSONField(name = "degree")
    @Column(name = "degree", length = 50)
    private String degree;

    @JSONField(name = "colleges")
    @Column(name = "colleges", length = 50)
    private String colleges;

    @JSONField(name = "major")
    @Column(name = "major", length = 50)
    private String major;

    @JSONField(name = "residential_address")
    @Column(name = "residential_address", length = 50)
    private String residentialAddress;

    @JSONField(name = "marital_status")
    @Column(name = "marital_status", length = 50)
    private String maritalStatus;

    @JSONField(name = "company_name")
    @Column(name = "company_name", length = 50)
    private String companyName;

    @JSONField(name = "branch_name")
    @Column(name = "branch_name", length = 50)
    private String branchName;

    @JSONField(name = "company_phone_no")
    @Column(name = "company_phone_no", length = 50)
    private String companyPhoneNo;

    @JSONField(name = "company_address")
    @Column(name = "company_address", length = 50)
    private String companyAddress;

    @JSONField(name = "bank_account")
    @Column(name = "bank_account", length = 50)
    private String bankAccount;

    @JSONField(name = "bank_card_type")
    @Column(name = "bank_card_type", length = 50)
    private String bankCardType;

    @JSONField(name = "reserve_phone_no")
    @Column(name = "reserve_phone_no", length = 50)
    private String reservePhoneNo;

    @JSONField(name = "bank_name")
    @Column(name = "bank_name", length = 50)
    private String bankName;

    @JSONField(name = "personal_income")
    @Column(name = "personal_income", length = 50)
    private BigDecimal personalIncome;

    @JSONField(name = "monthly_expenditure")
    @Column(name = "monthly_expenditure", length = 50)
    private BigDecimal monthlyExpenditure;

    @JSONField(name = "qq")
    @Column(name = "qq", length = 50)
    private String qq;

    @JSONField(name = "wechat")
    @Column(name = "wechat", length = 50)
    private String wechat;

    @JSONField(name = "bank_province")
    @Column(name = "bank_province", length = 50)
    private String bankProvince;

    @JSONField(name = "bank_city")
    @Column(name = "bank_city", length = 50)
    private String bankCity;

    @JSONField(name = "bank_sub_branch_name")
    @Column(name = "bank_sub_branch_name", length = 50)
    private String bankSubBranchName;

    @JSONField(name = "bank_code")
    @Column(name = "bank_code", length = 50)
    private String bankCode;

    @JSONField(name = "customer_professional_info")
    @Column(name = "customer_professional_info", length = 50)
    private String customerProfessionalInfo;

    @JSONField(name = "certificate_expiry_date",format = "yyyy-MM-dd")
    @Column(name = "certificate_expiry_date", length = 50)
    private Date certificateExpiryDate;

}
