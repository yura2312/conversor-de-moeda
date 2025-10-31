package controller;

import dto.ExchangeResponse;
import model.CurrencyEnum;
import model.CurrencyExchange;
import service.JsonService;
import service.HttpService;

public class Controller {
    private final HttpService htppService;
    private final JsonService jsonService;

    public Controller(HttpService httpService, JsonService jsonService) {
        this.htppService = httpService;
        this.jsonService = jsonService;
    }

    public ExchangeResponse defaultConversion(CurrencyExchange currencyExchange, double amount) {
        String json = htppService.getJson(currencyExchange);
        jsonService.setConversionRateFromAPI(currencyExchange, json);
        return new ExchangeResponse(currencyExchange, amount);
    }

    public boolean validateInput(String fromCurrency, String toCurrency, double amount) {
        if (CurrencyEnum.validateEnum(fromCurrency) == null || CurrencyEnum.validateEnum(toCurrency) == null) {
            System.out.println("ERRO: Moeda digitada não existe, ou não é suportada pela API.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Erro: \n Número igual a 0 ou negativo");
            return false;
        }
        return true;
    }

    public ExchangeResponse customConversion(CurrencyExchange currencyExchange, double amount) {
        String json = htppService.getJson(currencyExchange);
        jsonService.setConversionRateFromAPI(currencyExchange, json);
        return new ExchangeResponse(currencyExchange, amount);
    }
}
