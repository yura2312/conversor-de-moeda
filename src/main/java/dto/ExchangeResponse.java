package dto;

import model.CurrencyExchange;

public record ExchangeResponse(
        CurrencyExchange currencyExchange,
        double fromCurrencyAmount
) {
    @Override
    public String toString() {
        return "%f %s = %f %s".formatted(
                fromCurrencyAmount, currencyExchange.getFromCurrency().currencyName,
                fromCurrencyAmount * currencyExchange.getConversionRate(), currencyExchange.getToCurrency().currencyName);
    }
}
