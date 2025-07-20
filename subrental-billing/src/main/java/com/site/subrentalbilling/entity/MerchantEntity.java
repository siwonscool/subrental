package com.site.subrentalbilling.entity;

import com.site.subrentalbilling.type.BusinessType;
import com.site.subrentalcore.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tmerchant")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantEntity extends BaseEntity {
    @Id
    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "business_name")
    private String businessName;

    @Enumerated(EnumType.STRING)
    @Column(name = "business_type")
    private BusinessType businessType;

    @Column(name = "ninedock_store_id")
    private String ninedockStoreId;

    @Column(name = "billing_attempt_count")
    private Integer billingAttemptCount;

    @Column(name = "billing_attempt_day_period")
    private Integer billingAttemptDayPeriod;

    @Column(name = "billing_retry_count")
    private Integer billingRetryCount;

    @Column(name = "billing_retry_min_period")
    private Integer billingRetryMinPeriod;

    @Column(name = "idp_auth_server_info")
    private String idpAuthServerInfo;

    @Column(name = "callback_url")
    private String callbackUrl;

    @OneToMany(mappedBy = "merchantEntity", fetch = FetchType.LAZY)
    private Set<MerchantKakaoPaySettingEntity> merchantKakaoPaySettingEntities;
}

