package com.soumya.wumbee.vault.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "vault_card")
public class VaultCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 4)
    private String lastFour;

    @Column(nullable = false, length = 6)
    private String bin; // first 6 digit

    @Column(nullable = false)
    private byte[] encryptedPan;

    @Column(nullable = false)
    private byte[] encryptedDek;

    @Column(nullable = false)
    private String brand; // card company

    @Column(nullable = false)
    private String expirtMonth;

    @Column(nullable = false)
    private String expirtYear;

    @Column(nullable = false)
    private String cardHolderName;

    private LocalDate deletedAt;
}



