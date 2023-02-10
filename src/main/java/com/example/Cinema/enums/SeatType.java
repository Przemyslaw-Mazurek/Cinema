package com.example.Cinema.enums;

public enum SeatType {

    VIP(150),
    DISABLED(50),
    NORMAL(100);

    private final int priceModifierPercentage;

    SeatType(int priceModifierPercentage) {
        this.priceModifierPercentage = priceModifierPercentage;
    }
}
