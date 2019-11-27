package com.github.ls.order.entity.base;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cl_risk_control_info")
public final class ClRiskControlInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "load_order_no", length = 50, unique = true)
    @JsonProperty(value = "load_order_no")
    private String loadOrderNo;

    @Column(name = "biz_order_no", length = 50, unique = true)
    @JsonProperty(value = "biz_order_no")
    private String bizOrderNo;

    @JsonProperty(value = "address_type")
    @Column(name = "address_type", length = 50)
    private Integer addressType;

    @JsonProperty(value = "device_mac")
    @Column(name = "device_mac", length = 50)
    private String deviceMac;

    @JsonProperty(value = "plan_breath_way")
    @Column(name = "plan_breath_way")
    private Integer planBreathWay;

    @JsonProperty(value = "social_account")
    @Column(name = "social_account", length = 50)
    private String socialAccount;

    @JsonProperty(value = "social_account_type")
    @Column(name = "social_account_type", length = 1)
    private Integer socialAccountType;

    @JsonProperty(value = "month_rate")
    @Column(name = "month_rate", length = 50)
    private BigDecimal monthRate;

    @JsonProperty(value = "address_info_checked")
    @Column(name = "address_info_checked", length = 50)
    private Integer addressInfoChecked;

    @JsonProperty(value = "is_manually_audited")
    @Column(name = "is_manually_audited", length = 50)
    private Integer isManuallyAudited;

    @JsonProperty(value = "is_multiple_idcard")
    @Column(name = "is_multiple_idcard", length = 50)
    private Integer isMultipleIdcard;

    @JsonProperty(value = "is_work_checked")
    @Column(name = "is_work_checked", length = 50)
    private Integer isWorkChecked;

    @JsonProperty(value = "is_contact_checked")
    @Column(name = "is_contact_checked", length = 50)
    private Integer isContactChecked;

    @JsonProperty(value = "idcard_name_consistency")
    @Column(name = "idcard_name_consistency", length = 50)
    private Integer idcardNameConsistency;

    @JsonProperty(value = "idcard_name_channel")
    @Column(name = "idcard_name_channel", length = 50)
    private String idcardNameChannel;

    @JsonProperty(value = "idcard_name_mobile_channel")
    @Column(name = "idcard_name_mobile_channel", length = 50)
    private String idcardNameMobileChannel;

    @JsonProperty(value = "idcard_name_bank_no_channel")
    @Column(name = "idcard_name_bank_no_channel", length = 50)
    private String idcardNameBanknoChannel;

    @JsonProperty(value = "is_Black_list")
    @Column(name = "is_Black_list", length = 50)
    private Integer isBlacklist;

    @JsonProperty(value = "black_list_channel")
    @Column(name = "black_list_channel", length = 50)
    private String blacklistChannel;

    @JsonProperty(value = "is_court_black_list")
    @Column(name = "is_court_black_list", length = 50)
    private Integer isCourtBlacklist;

    @JsonProperty(value = "court_black_list_channel")
    @Column(name = "court_black_list_channel", length = 50)
    private String courtBlacklistChannel;

    @JsonProperty(value = "is_police_black_list")
    @Column(name = "is_police_black_list", length = 50)
    private Integer isPoliceBlacklist;

    @JsonProperty(value = "police_black_list_channel")
    @Column(name = "police_black_list_channel", length = 50)
    private String policeBlacklistChannel;

    @JsonProperty(value = "car_use_year")
    @Column(name = "car_use_year")
    private Integer carUseYear;


    @JsonProperty(value = "car_engine_no")
    @Column(name = "car_engine_no", length = 50)
    private String carEngineNo;

    @JsonProperty(value = "car_frame_no")
    @Column(name = "car_frame_no", length = 50)
    private String carFrameNo;

    @JsonProperty(value = "car_exercise_info")
    @Column(name = "car_exercise_info")
    private BigDecimal carExerciseInfo;

    @JsonProperty(value = "car_brand")
    @Column(name = "car_brand", length = 50)
    private String carBrand;


    @JsonProperty(value = "car_type")
    @Column(name = "car_type", length = 50)
    private String carType;

    @JsonProperty(value = "is_have_accident")
    @Column(name = "is_have_accident")
    private Integer isHaveAccident;

    @JsonProperty(value = "accident_type")
    @Column(name = "accident_type")
    private Integer accidentType;

    @JsonProperty(value = "car_cost")
    @Column(name = "car_cost")
    private BigDecimal carCost;


    @JsonProperty(value = "credit_line_proportion")
    @Column(name = "credit_line_proportion", length = 50)
    private String creditLineProportion;

    @JsonProperty(value = "merchants_name")
    @Column(name = "merchants_name", length = 50)
    private String merchantsName;

    @JsonProperty(value = "merchants_province")
    @Column(name = "merchants_province", length = 50)
    private String merchantsProvince;

    @JsonProperty(value = "merchants_city")
    @Column(name = "merchants_city", length = 50)
    private String merchantsCity;

    @JsonProperty(value = "third_party_no")
    @Column(name = "third_party_no", length = 50)
    private String thirdPartyNo;

    @JsonProperty(value = "car_pledge_date")
    @Column(name = "car_pledge_date")
    private LocalDate carPledgeDate;

    @JsonProperty(value = "product_type")
    @Column(name = "product_type", length = 50)
    private String productType;

    @JsonProperty(value = "td_Score")
    @Column(name = "td_Score")
    private Integer tdScore;

    @JsonProperty(value = "af_score")
    @Column(name = "af_score")
    private Integer afScore;

    @JsonProperty(value = "td_amount")
    @Column(name = "td_amount")
    private Integer tdAmount;

    @JsonProperty(value = "xy_black")
    @Column(name = "xy_black")
    private Integer xyBlack;

    @JsonProperty(value = "af_black")
    @Column(name = "af_black")
    private Integer afBlack;
}
