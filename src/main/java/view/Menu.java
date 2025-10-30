package view;

import controller.Controller;
import model.CurrencyExchange;
import service.JsonService;
import service.HttpService;
import model.CurrencyEnum;

import java.util.Scanner;

public class Menu {

    private final JsonService jsonService;
    private final HttpService httpService;
    private final Controller controller;
    Scanner scanner = new Scanner(System.in);

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

    public Menu() {
        this.jsonService = new JsonService();
        this.httpService = new HttpService();
        this.controller = new Controller(this.httpService, this.jsonService);
    }


    public void showMenu() {
        int menuIndex = -1;
        while (menuIndex != 0) {
            CurrencyExchange exchange = null;
            System.out.println(OPTIONS);
            menuIndex = scanner.nextInt();
            scanner.nextLine();
            switch (menuIndex) {
                case 1: {
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.BRL);
                    break;
                }
                case 2: {
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.ARS);
                    break;
                }
                case 3: {
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.COP);
                    break;
                }
                case 4: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.USD);
                    break;
                }
                case 5: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.ARS);
                    break;
                }
                case 6: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.COP);
                    break;
                }
                case 0: {
                    System.out.println("Fechando...");
                    return;
                }
                default:
                    System.out.println("Digite uma opção válida: ");
            }

            if (exchange!=null){
                controller.conversion(exchange);
                System.out.println(exchange);
            }

            System.out.println("Aperte qualquer tecla para continuar...");
            scanner.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

}
