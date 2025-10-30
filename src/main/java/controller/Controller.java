package controller;

import model.CurrencyExchange;
import parser.JsonService;
import service.HttpService;

public class Controller {
    HttpService htppService;
    CurrencyExchange currencyExchange;
    JsonService jsonService;

    public Controller(HttpService httpService, CurrencyExchange currencyExchange, JsonService jsonService) {
        this.htppService = httpService;
        this.currencyExchange = currencyExchange;
        this.jsonService = jsonService;
    }

    public void conversion(){
        String json = htppService.getJson();
        jsonService.setConversionRateFromAPI(currencyExchange, json);
        System.out.println(currencyExchange);
    }

}
