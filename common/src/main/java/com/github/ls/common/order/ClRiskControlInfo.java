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
@Table(name = "cl_risk_control_info")
public class ClRiskControlInfo implements Serializable {

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

    @JSONField(name = "address_type")
    @Column(name = "address_type", length = 50)
    private long addressType;

    @JSONField(name = "device_mac")
    @Column(name = "device_mac", length = 50)
    private String deviceMac;

    @JSONField(name = "plan_breath_way")
    @Column(name = "plan_breath_way", length = 50)
    private long planBreathWay;

    @JSONField(name = "social_account")
    @Column(name = "social_account", length = 50)
    private String socialAccount;

    @JSONField(name = "social_account_type")
    @Column(name = "social_account_type", length = 1)
    private long socialAccountType;

    @JSONField(name = "month_rate")
    @Column(name = "month_rate", length = 50)
    private double monthRate;

    @JSONField(name = "address_info_checked")
    @Column(name = "address_info_checked", length = 50)
    private long addressInfoChecked;

    @JSONField(name = "is_manually_audited")
    @Column(name = "is_manually_audited", length = 50)
    private long isManuallyAudited;

    @JSONField(name = "is_multiple_idcard")
    @Column(name = "is_multiple_idcard", length = 50)
    private long isMultipleIdcard;

    @JSONField(name = "is_work_checked")
    @Column(name = "is_work_checked", length = 50)
    private long isWorkChecked;

    @JSONField(name = "is_contact_checked")
    @Column(name = "is_contact_checked", length = 50)
    private long isContactChecked;

    @JSONField(name = "idcard_name_consistency")
    @Column(name = "idcard_name_consistency", length = 50)
    private long idcardNameConsistency;

    @JSONField(name = "idcard_name_channel")
    @Column(name = "idcard_name_channel", length = 50)
    private String idcardNameChannel;

    @JSONField(name = "idcard_name_mobile_channel")
    @Column(name = "idcard_name_mobile_channel", length = 50)
    private String idcardNameMobileChannel;

    @JSONField(name = "idcard_name_bank_no_channel")
    @Column(name = "idcard_name_bank_no_channel", length = 50)
    private String idcardNameBanknoChannel;

    @JSONField(name = "is_Black_list")
    @Column(name = "is_Black_list", length = 50)
    private long isBlacklist;

    @JSONField(name = "black_list_channel")
    @Column(name = "black_list_channel", length = 50)
    private String blacklistChannel;

    @JSONField(name = "is_court_black_list")
    @Column(name = "is_court_black_list", length = 50)
    private long isCourtBlacklist;

    @JSONField(name = "court_black_list_channel")
    @Column(name = "court_black_list_channel", length = 50)
    private String courtBlacklistChannel;

    @JSONField(name = "is_police_black_list")
    @Column(name = "is_police_black_list", length = 50)
    private long isPoliceBlacklist;

    @JSONField(name = "police_black_list_channel")
    @Column(name = "police_black_list_channel", length = 50)
    private String policeBlacklistChannel;

    @JSONField(name = "car_use_year")
    @Column(name = "car_use_year")
    private Integer carUseYear;

    @JSONField(name = "contact_name")
    @Column(name = "contact_name", length = 50)
    private String carEngineNo;

    @JSONField(name = "contact_name")
    @Column(name = "car_frame_no", length = 50)
    private String carFrameNo;

    @JSONField(name = "car_exercise_info")
    @Column(name = "car_exercise_info", length = 50)
    private double carExerciseInfo;

    @JSONField(name = "car_brand")
    @Column(name = "car_brand", length = 50)
    private String carBrand;

    @JSONField(name = "car_type")
    @Column(name = "car_type", length = 50)
    private String carType;

    @JSONField(name = "is_have_accident")
    @Column(name = "is_have_accident", length = 50)
    private long isHaveAccident;

    @JSONField(name = "accident_type")
    @Column(name = "accident_type", length = 50)
    private long accidentType;

    @NotBlank
    @JSONField(name = "car_Cost")
    @Column(name = "car_Cost")
    private BigDecimal carCost;

    @JSONField(name = "credit_line_proportion")
    @Column(name = "credit_line_proportion", length = 50)
    private String creditLineProportion;

    @JSONField(name = "merchants_name")
    @Column(name = "merchants_name", length = 50)
    private String merchantsName;

    @JSONField(name = "merchants_province")
    @Column(name = "merchants_province", length = 50)
    private String merchantsProvince;

    @JSONField(name = "merchants_city")
    @Column(name = "merchants_city", length = 50)
    private String merchantsCity;

    @JSONField(name = "third_party_no")
    @Column(name = "third_party_no", length = 50)
    private String thirdPartyNo;

    @JSONField(name = "car_pledge_date")
    @Column(name = "car_pledge_date")
    private Date carPledgeDate;

    @JSONField(name = "product_type")
    @Column(name = "product_type", length = 50)
    private String productType;

    @JSONField(name = "td_Score")
    @Column(name = "td_Score")
    private Integer tdScore;

    @JSONField(name = "af_score")
    @Column(name = "af_score")
    private Integer afScore;

    @JSONField(name = "td_amount")
    @Column(name = "td_amount")
    private Integer tdAmount;

    @JSONField(name = "xy_black")
    @Column(name = "xy_black")
    private Integer xyBlack;

    @JSONField(name = "af_black")
    @Column(name = "af_black")
    private Integer afBlack;


}
