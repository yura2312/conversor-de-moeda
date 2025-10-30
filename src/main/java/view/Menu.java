package view;

import model.CurrencyExchange;
import parser.JsonService;
import service.HttpService;
import model.Currency;
import java.util.Scanner;

public class Menu {


    JsonService jsonService = new JsonService();
    HttpService httpService;
    public void showMenu() {
        String OPTIONS = """
                ********************************
                1) Dólar -> Real brasileiro
                2) Dolár -> Peso argentino
                3) Dólar -> Peso colombiano
                4) Real brasileiro -> Dólar
                5) Real brasileiro -> Peso argentino
                6) Real brasileiro -> Peso colombiano
                0) SAIR
                ********************************
                """;
        Scanner scanner = new Scanner(System.in);
        int menuIndex = -1;
        while (menuIndex != 0) {
            System.out.println(OPTIONS);
            menuIndex = scanner.nextInt();

            switch (menuIndex) {
                case 1: {
                    CurrencyExchange exchange = new CurrencyExchange(Currency.USD, Currency.BRL);
                    httpService = new HttpService(exchange);
                    String json = httpService.getJson();
                    jsonService.setConversionRateFromAPI(exchange, json);
                    System.out.println(exchange);
                }
                default: return;
            }
        }

    }

}
