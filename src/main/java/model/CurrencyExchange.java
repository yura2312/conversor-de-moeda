package model;

public class CurrencyExchange {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private double conversionRate;

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public CurrencyExchange(Currency fromCurrency, Currency toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    @Override
    public String toString() {
        return "1 " + fromCurrency.nome + " = " + conversionRate + " " +toCurrency.nome;
    }
}
