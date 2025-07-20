package com.site.subrentalbilling.entity;

import com.site.subrentalbilling.type.BillingDocumentStateType;
import com.site.subrentalbilling.type.PaymentPlan;
import com.site.subrentalbilling.type.PaymentType;
import com.site.subrentalcore.entity.BaseEntity;
import com.site.subrentalcore.util.AttributeEncryptorConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbilling_document",
        indexes = {
                @Index(name = "IDX_INVOICE_DATA", columnList = "invoice_date"),
                @Index(name = "IDX_PAYMENT_DATA", columnList = "payment_date"),
        }
)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillingDocumentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BillingDocumentStateType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private MerchantEntity merchantEntity;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "product_name")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "tax_free_amount")
    private BigDecimal taxFreeAmount;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_name")
    private String buyerName;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_phone")
    private String buyerPhone;

    @Convert(converter = AttributeEncryptorConverter.class)
    @Column(name = "buyer_email")
    private String buyerEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_plan")
    private PaymentPlan paymentPlan;

    @Column(name = "next_day_retry")
    private Boolean nextDayRetry;

    @Column(name = "next_period_retry")
    private Boolean nextPeriodRetry;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "external_id")
    private String externalId;

    @OneToMany(mappedBy = "billingDocumentEntity", fetch = FetchType.LAZY)
    private Set<BillingDocumentDetailEntity> billingDocumentDetailEntities;

    /*@OneToMany(mappedBy = "billingDocumentEntity", fetch = FetchType.LAZY)
    private Set<BillingDocumentDiscountEntity> billingDocumentDiscountEntities;

    @OneToMany(mappedBy = "billingDocumentEntity", fetch = FetchType.LAZY)
    private Set<BillingDocumentPaymentEntity> billingDocumentPaymentEntities;

    @OneToMany(mappedBy = "billingDocumentEntity", fetch = FetchType.LAZY)
    private Set<BillingDocumentPaymentKakaoPayEntity> billingDocumentPaymentKakaoPayEntities;*/
}
