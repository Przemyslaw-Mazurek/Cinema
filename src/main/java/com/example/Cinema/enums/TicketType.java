package com.example.Cinema.enums;

public enum TicketType {

    NORMAL(100),
    REDUCED(50),
    VIP(150);

    private final int priceModifierPercentage;

    TicketType(int priceModifierPercentage) {
        this.priceModifierPercentage = priceModifierPercentage;
    }
}
