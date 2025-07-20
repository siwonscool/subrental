package com.site.subrentalbilling.entity;

import com.site.subrentalcore.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tmerchant_kakaopay_setting")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantKakaoPaySettingEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private MerchantEntity merchantEntity;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "app_admin_key")
    private String appAdminKey;

    @Column(name = "rest_api_key")
    private String restApiKey;

    @Column(name = "cid")
    private String cid;

    @Column(name = "subscription_cid")
    private String subscriptionCid;

    @Column(name = "deposit_bank_name")
    private String depositBankName;

    @Column(name = "deposit_bank_account_number")
    private String depositBankAccountNumber;

    @Column(name = "state")
    private Boolean state;
}

