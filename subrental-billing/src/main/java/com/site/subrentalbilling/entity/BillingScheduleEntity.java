package com.site.subrentalbilling.entity;

import com.site.subrentalbilling.type.PaymentType;
import com.site.subrentalbilling.type.PeriodType;
import com.site.subrentalbilling.type.TaxBaseType;
import com.site.subrentalcore.entity.BaseEntity;
import com.site.subrentalcore.util.AttributeEncryptorConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbilling_schedule",
        indexes = {
                @Index(name = "IDX_BILLING_START_END", columnList = "billing_start, billing_end"),
                @Index(name = "IDX_NOTICE_DATE", columnList = "notice_date")
        }
)
@DynamicUpdate
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingScheduleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private MerchantEntity merchantEntity;

    @Column(name = "billing_start")
    private LocalDate billingStart;

    @Column(name = "billing_end")
    private LocalDate billingEnd;

    @Column(name = "notice_date")
    private LocalDate noticeDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "order_id")
    private String orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Column(name = "payment_day", nullable = false)
    private Integer paymentDay;

    @Column(name = "invoice_day")
    private Integer invoiceDay;

    @Column(name = "total_rounds")
    private Integer totalRounds;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "tax_base")
    private TaxBaseType taxBaseType;

    @Column(name = "product_name")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "period")
    private PeriodType period;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_name")
    private String buyerName;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_phone")
    private String buyerPhone;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_email")
    private String buyerEmail;

    @Column(name = "combined")
    private Boolean combined;

    @Column(name = "next_day_retry")
    private Boolean nextDayRetry;

    @Column(name = "next_period_retry")
    private Boolean nextPeriodRetry;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "state")
    private Boolean state;

    /*@OneToMany(mappedBy = "billingScheduleEntity", fetch = FetchType.LAZY)
    private Set<BillingScheduleModificationEntity> billingScheduleModificationEntities;

    @OneToMany(mappedBy = "billingScheduleEntity", fetch = FetchType.LAZY)
    private Set<BillingScheduleTaxEntity> billingScheduleTaxEntities;

    @OneToMany(mappedBy = "billingScheduleEntity", fetch = FetchType.LAZY)
    private Set<BillingSchedulePaymentKakaoPayEntity> billingSchedulePaymentKakaoPayEntity;*/
}
