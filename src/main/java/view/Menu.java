package view;

import controller.Controller;
import model.CurrencyExchange;
import service.JsonService;
import service.HttpService;
import model.CurrencyEnum;

import java.util.Scanner;

public class Menu {


    JsonService jsonService;
    HttpService httpService;
    Controller controller;

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
                    CurrencyEnum fromCurrency = CurrencyEnum.USD;
                    CurrencyEnum toCurrency = CurrencyEnum.BRL;
                    CurrencyExchange exchange = new CurrencyExchange(fromCurrency, toCurrency);
                    jsonService = new JsonService(exchange);
                    httpService = new HttpService(exchange);
                    controller = new Controller(httpService, exchange, jsonService);
                    controller.conversion();
                }
                default:
                    return;
            }
        }
    }

}
