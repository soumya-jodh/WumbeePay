package com.soumya.wumbee.common.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Embeddable
@AllArgsConstructor
public class Money {
    private BigInteger amountUnits;
    private String currency;

    protected Money() {}

    public static Money of(BigInteger amountUnits, String currency) {
        return new Money(amountUnits, currency);
    }

    public static Money inr(BigInteger amountUnits, String currency) {
        return new Money(amountUnits, "Inr");
    }

    public Money sum(Money other) {
        if(!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot perform add operation on different currencies");
        }
        return new Money(this.amountUnits.add(other.amountUnits), this.currency);
    }

    public Money subtract(Money other) {
        if(!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot perform subtract operation on different currencies");
        }
        return new Money(this.amountUnits.subtract(other.amountUnits), this.currency);
    }

}
