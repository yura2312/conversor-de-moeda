package service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.CurrencyExchange;

public class JsonService {

    CurrencyExchange currencyExchange;

    public JsonService(CurrencyExchange currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    public void setConversionRateFromAPI(CurrencyExchange currencyExchange, String json){
        JsonElement element = JsonParser.parseString(json);
        JsonObject object = element.getAsJsonObject();
        double conversionRate = object.get("conversion_rate").getAsDouble();
        currencyExchange.setConversionRate(conversionRate);
    }
}
