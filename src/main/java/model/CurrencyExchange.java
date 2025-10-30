package model;

public class CurrencyExchange {
    private final CurrencyEnum fromCurrencyEnum;
    private final CurrencyEnum toCurrencyEnum;
    private double conversionRate;

    public CurrencyEnum getFromCurrency() {
        return fromCurrencyEnum;
    }

    public CurrencyEnum getToCurrency() {
        return toCurrencyEnum;
    }

    public CurrencyExchange(CurrencyEnum fromCurrencyEnum, CurrencyEnum toCurrencyEnum) {
        this.fromCurrencyEnum = fromCurrencyEnum;
        this.toCurrencyEnum = toCurrencyEnum;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    @Override
    public String toString() {
        return "1 " + fromCurrencyEnum.nome + " = " + conversionRate + " " + toCurrencyEnum.nome;
    }
}
