package com.site.subrentalbilling.entity;

import com.site.subrentalbilling.type.TaxBaseType;
import com.site.subrentalcore.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tbilling_document_detail")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BillingDocumentDetailEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_document_id")
    private BillingDocumentEntity billingDocumentEntity;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "tax_base")
    private TaxBaseType taxBaseType;

    @Column(name = "modification_amount")
    private BigDecimal modificationAmount;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "rounds")
    private Integer rounds;

    @ManyToOne
    @JoinColumn(name = "billing_schedule_id")
    private BillingScheduleEntity billingScheduleEntity;

    @Column(name = "external_id")
    private String externalId;

    /*@OneToMany(mappedBy = "billingDocumentDetailEntity")
    private Set<BillingDocumentModificationEntity> billingDocumentModificationEntity;*/
}
