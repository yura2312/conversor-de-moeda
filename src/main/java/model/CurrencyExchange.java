package model;

import java.time.LocalDateTime;

public class CurrencyExchange {
    private final CurrencyEnum fromCurrencyEnum;
    private final CurrencyEnum toCurrencyEnum;
    private double conversionRate = 0;
    private final LocalDateTime localDateTime;

    public CurrencyEnum getFromCurrency() {
        return fromCurrencyEnum;
    }

    public CurrencyEnum getToCurrency() {
        return toCurrencyEnum;
    }

    public CurrencyExchange(CurrencyEnum fromCurrencyEnum, CurrencyEnum toCurrencyEnum, LocalDateTime localDateTime) {
        this.fromCurrencyEnum = fromCurrencyEnum;
        this.toCurrencyEnum = toCurrencyEnum;
        this.localDateTime = localDateTime;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
