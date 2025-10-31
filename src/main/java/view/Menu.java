package view;

import controller.Controller;
import dto.ExchangeResponse;
import model.CurrencyExchange;
import service.JsonService;
import service.HttpService;
import model.CurrencyEnum;

import java.util.Scanner;

public class Menu {

    private final JsonService jsonService = new JsonService();
    private final HttpService httpService = new HttpService();
    private final Controller controller = new Controller(httpService, jsonService);
    Scanner scanner = new Scanner(System.in);

    String OPTIONS = """
            ********************************
            1) Dólar -> Real brasileiro
            2) Dolár -> Peso argentino
            3) Dólar -> Peso colombiano
            4) Real brasileiro -> Dólar
            5) Real brasileiro -> Peso argentino
            6) Real brasileiro -> Peso colombiano
            7) Conversão personalizada
            0) SAIR
            ********************************
            """;


    public void showMenu() {
        int menuIndex;
        while (true) {
            CurrencyExchange exchange = null;
            double fromAmount = 1;
            ExchangeResponse response = null;
            System.out.println(OPTIONS);
            menuIndex = scanner.nextInt();
            scanner.nextLine();
            switch (menuIndex) {
                case 0: {
                    System.out.println("Fechando...");
                    return;
                }
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
                case 7: {
                    System.out.println("Qual a moeda de origem?");
                    String fromCurrency = scanner.nextLine().toUpperCase();

                    System.out.println("Quantia: ");
                    fromAmount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Qual a moeda de destino?");
                    String toCurrency = scanner.nextLine().toUpperCase();


                    boolean isValid = controller.validateInput(fromCurrency, toCurrency, fromAmount);
                    if (isValid) {
                        exchange = new CurrencyExchange(CurrencyEnum.valueOf(fromCurrency), CurrencyEnum.valueOf(toCurrency));
                        response = controller.customConversion(exchange, fromAmount);
                    }
                }
                default:
                    System.out.println("Digite uma opção válida: ");
            }

            if (exchange != null) {
                response = controller.defaultConversion(exchange, fromAmount);
            }
            if (response != null) System.out.println(response);

            System.out.println("Aperte enter para continuar...");
            scanner.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
