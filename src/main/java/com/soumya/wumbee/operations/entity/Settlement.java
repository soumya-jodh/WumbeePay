package com.soumya.wumbee.operations.entity;

import com.soumya.wumbee.common.entity.Money;
import com.soumya.wumbee.common.enums.SettlementStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settlement")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID merchantId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gross_amounts_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "gross_amount_currency"))
    })
    private Money grossAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "refund_amounts_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "refund_amount_currency"))
    })
    private Money refundAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "fee_amounts_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "fee_amount_currency"))
    })
    private Money feeAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gst_amounts_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "gst_amount_currency"))
    })
    private Money gstAmount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "net_amounts_units")),
            @AttributeOverride(name = "currency", column = @Column(name = "net_amount_currency"))
    })
    private Money netAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SettlementStatus status;

    @Column(nullable = false, length = 20)
    private String bankReference;

    private LocalDateTime processedAt;

}
