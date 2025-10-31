package dto;

import model.CurrencyExchange;

public record ExchangeResponse(
        CurrencyExchange currencyExchange,
        double fromCurrencyAmount
) {
    @Override
    public String toString() {
        return "%.2f %s = %.2f %s".formatted(
                fromCurrencyAmount, currencyExchange.getFromCurrency().currencyName,
                fromCurrencyAmount * currencyExchange.getConversionRate(), currencyExchange.getToCurrency().currencyName);
    }
}
