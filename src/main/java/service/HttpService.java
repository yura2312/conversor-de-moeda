package service;

import model.CurrencyExchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {


    public HttpService() {
    }


    private URI setAPIRoute(CurrencyExchange exchange) {
        StringBuilder stringBuilder = new StringBuilder();
        String API_KEY = System.getenv("API_KEY");
        stringBuilder.append("https://v6.exchangerate-api.com/v6/")
                .append(API_KEY + "/pair/")
                .append(exchange.getFromCurrency() + "/")
                .append(exchange.getToCurrency() + "/");
        return URI.create(String.valueOf(stringBuilder));
    }

    public String getJson(CurrencyExchange exchange) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(setAPIRoute(exchange))
                .build();


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Erro ao pegar resposta da API: ", e);
        }
    }
}
