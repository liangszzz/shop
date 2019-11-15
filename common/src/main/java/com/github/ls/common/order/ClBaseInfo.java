package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "cl_base_info")
public class ClBaseInfo implements Serializable {

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

    @Null
    @Column(name = "zlx_order_no", length = 50, unique = true)
    private String zlxOrderNo;

    @Null
    @Null
    @Column(name = "orderStatus", length = 50)
    @JSONField(name = "order_status")
    private Integer orderStatus;

    @Column(name = "contract_no", length = 50)
    @JSONField(name = "contract_no")
    private String contractNo;

    @Column(name = "coop_channel", length = 50)
    @NotBlank
    @JSONField(name = "coop_channel")
    private String coopChannel;

    @Column(name = "borrow_usage", length = 50)
    @NotBlank
    @JSONField(name = "borrow_usage")
    private String borrowUsage;

    @Column(name = "load_date")
    @Null
    @JSONField(name = "load_date")
    private Date loadDate;

    @Column(name = "repayment_method", length = 50)
    @NotBlank
    @JSONField(name = "repayment_method")
    private String repaymentMethod;

    @Column(name = "evaluation_car_price", length = 50)
    @NotNull
    @JSONField(name = "evaluation_car_price")
    private BigDecimal evaluationCarPrice;

    @Column(name = "apply_amount", length = 50)
    @NotNull
    @JSONField(name = "apply_amount")
    private BigDecimal applyAmount;

    @Column(name = "actual_amount")
    @NotNull
    @JSONField(name = "actual_amount")
    private BigDecimal actualAmount;

    @Column(name = "annual_interest_rate", length = 50)
    @NotNull
    @JSONField(name = "annual_interest_rate")
    private BigDecimal annualInterestRate;

    @Column(name = "signing_province", length = 50)
    @JSONField(name = "signing_province")
    private String signingProvince;

    @Column(name = "signing_city", length = 50)
    @NotBlank
    @JSONField(name = "signing_city")
    private String signingCity;

    @Column(name = "whether_renew", length = 50)
    @NotBlank
    @JSONField(name = "whether_renew")
    private String whetherRenew;

    @Column(name = "mortgagee", length = 50)
    @JSONField(name = "mortgagee")
    private String mortgagee;

    @Column(name = "borrower_repayment_method", length = 50)
    @JSONField(name = "borrower_repayment_method")
    private String borrowerRepaymentMethod;

    @Column(name = "repayment_terms", length = 50)
    @NotBlank
    @JSONField(name = "repayment_terms")
    private String repaymentTerms;

    @Column(name = "repayment_times", length = 50)
    @JSONField(name = "repayment_times")
    private String repaymentTimes;

    @Column(name = "contract_start_date", length = 50)
    @JSONField(name = "contract_start_date", format = "yyyy-MM-dd")
    private Date contractStartDate;

    @Column(name = "contract_end_date", length = 50)
    @JSONField(name = "contract_end_date", format = "yyyy-MM-dd")
    private Date contractEndDate;

    @Column(name = "contract_due_days", length = 50)
    @JSONField(name = "contract_due_days")
    private String contractDueDays;

    @Column(name = "lenders_bank", length = 50)
    @JSONField(name = "lenders_bank")
    private String lendersBank;

    @Column(name = "lenders_account", length = 50)
    @JSONField(name = "lenders_account")
    private String lendersAccount;

    @Column(name = "lenders_status", length = 50)
    @JSONField(name = "lenders_status")
    private String lendersStatus;

    @Column(name = "lenders_order_no", length = 50)
    @JSONField(name = "lenders_order_no")
    private String lendersOrderNo;

    @Column(name = "institution_name", length = 50)
    @JSONField(name = "institution_name")
    private String institutionName;

    @Column(name = "institution_province", length = 50)
    @JSONField(name = "institution_province")
    private String institutionProvince;

    @Column(name = "institution_city", length = 50)
    @JSONField(name = "institution_city")
    private String institutionCity;

    @Column(name = "transfer_amount")
    @Null
    @JSONField(name = "transfer_amount")
    private BigDecimal transferAmount;

    @Column(name = "approve_amount")
    @NotNull
    @JSONField(name = "approve_amount")
    private BigDecimal approveAmount;

    @Column(name = "product_name", length = 50)
    @NotBlank
    @JSONField(name = "product_name")
    private String productName;

    @Column(name = "product_details", length = 50)
    @JSONField(name = "product_details")
    private String productDetails;

    @Column(name = "intermediary_service_agreement_signing_time", length = 50)
    @JSONField(name = "intermediary_service_agreement_signing_time")
    private String intermediaryServiceAgreementSigningTime;

    @Column(name = "intermediary_service_agreement_view_address", length = 50)
    @JSONField(name = "intermediary_service_agreement_view_address")
    private String intermediaryServiceAgreementViewAddress;

    @Column(name = "ca_license_protocol_signing_time", length = 50)
    @JSONField(name = "ca_license_protocol_signing_time")
    private String caLicenseProtocolSigningTime;

    @Column(name = "ca_license_protocol_view_address", length = 50)
    @JSONField(name = "ca_license_protocol_view_address")
    private String caLicenseProtocolViewAddress;

    @Column(name = "withholding_agreement_signing_time", length = 50)
    @JSONField(name = "withholding_agreement_signing_time")
    private String withholdingAgreementSigningTime;

    @Column(name = "withholding_protocol_view_address", length = 50)
    @JSONField(name = "withholding_protocol_view_address")
    private String withholdingProtocolViewAddress;

    @Column(name = "onLine", length = 50)
    @NotBlank
    @JSONField(name = "onLine")
    private String onLine;

    @Column(name = "payment_details", length = 50)
    @Null
    @JSONField(name = "payment_details")
    private String paymentDetails;

    @Column(name = "whether_paid", length = 50)
    @JSONField(name = "whether_paid")
    private String whetherPaid;

    @Column(name = "whether_deduct", length = 50)
    @JSONField(name = "whether_deduct")
    private String whetherDeduct;

    @Column(name = "intermediary_service_fee_amount", length = 50)
    @NotBlank
    @JSONField(name = "intermediary_service_fee_amount")
    private BigDecimal intermediaryServiceFeeAmount;

    @Column(name = "public_bank_name", length = 50)
    @JSONField(name = "public_bank_name")
    private String publicBankName;

    @Column(name = "public_bank_company_name", length = 50)
    @JSONField(name = "public_bank_company_name")
    private String publicBankCompanyName;

    @Column(name = "public_bank_no", length = 50)
    @JSONField(name = "public_bank_no")
    private String publicBankNo;

    @Column(name = "public_bank_account", length = 50)
    @JSONField(name = "public_bank_account")
    private String publicBankAccount;

    @Column(name = "public_bank_province", length = 50)
    @JSONField(name = "public_bank_province")
    private String publicBankProvince;

    @Column(name = "public_bank_city", length = 50)
    @JSONField(name = "public_bank_city")
    private String publicBankCity;

    @Column(name = "audit_name", length = 50)
    @Null
    @JSONField(name = "audit_name")
    private String auditName;

    @Column(name = "audit_date")
    @Null
    @JSONField(name = "audit_date")
    private Date auditDate;

    @Column(name = "create_by", length = 50)
    @Null
    @JSONField(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    @Null
    @JSONField(name = "create_date")
    private Date createDate;

    @Column(name = "loan_employers")
    @Null
    @JSONField(name = "loan_employers")
    private Integer loanEmployers;

    @Column(name = "branch_name", length = 50)
    @JSONField(name = "branch_name")
    private String branchName;

    @Column(name = "car_pledge_register_date", length = 50)
    @Null
    @JSONField(name = "car_pledge_register_date")
    private Date carPledgeRegisterDate;

    @Column(name = "wx_app_confirm", length = 50)
    @JSONField(name = "wx_app_confirm")
    private long wxAppConfirm;

    @Column(name = "fail_msg", length = 50)
    @JSONField(name = "fail_msg")
    private String failMsg;

}
