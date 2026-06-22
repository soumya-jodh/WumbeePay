package com.soumya.wumbee.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
public class MechantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, length = 500)
    private String targetUrl; //www.brand.com/webhook/success

    @Column(nullable = false, length = 255)
    private String webhookSecretHash;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(length = 255)
    private String eventTypes; //not enum beacuse it can be a list of event

}
