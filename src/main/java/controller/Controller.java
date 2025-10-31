package controller;

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

    public void defaultConversion(CurrencyExchange currencyExchange){
        String json = htppService.getJson(currencyExchange);
        jsonService.setConversionRateFromAPI(currencyExchange, json);
    }

    public void customConversion(CurrencyExchange currencyExchange){

    }
}
