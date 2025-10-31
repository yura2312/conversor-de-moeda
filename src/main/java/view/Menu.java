package view;

import controller.Controller;
import dto.ExchangeResponse;
import model.CurrencyExchange;
import service.JsonService;
import service.HttpService;
import model.CurrencyEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final JsonService jsonService = new JsonService();
    private final HttpService httpService = new HttpService();
    private final Controller controller = new Controller(httpService, jsonService);
    private List<ExchangeResponse> responseHistory = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    String OPTIONS = """
            *********************************
            1) Dólar -> Real brasileiro
            2) Dolár -> Peso argentino
            3) Dólar -> Peso colombiano
            4) Real brasileiro -> Dólar
            5) Real brasileiro -> Peso argentino
            6) Real brasileiro -> Peso colombiano
            7) Conversão personalizada
            8) Histórico de conversões
            0) SAIR
            ********************************""";


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
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.BRL, LocalDateTime.now());
                    break;
                }
                case 2: {
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.ARS, LocalDateTime.now());
                    break;
                }
                case 3: {
                    exchange = new CurrencyExchange(CurrencyEnum.USD, CurrencyEnum.COP, LocalDateTime.now());
                    break;
                }
                case 4: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.USD, LocalDateTime.now());
                    break;
                }
                case 5: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.ARS, LocalDateTime.now());
                    break;
                }
                case 6: {
                    exchange = new CurrencyExchange(CurrencyEnum.BRL, CurrencyEnum.COP, LocalDateTime.now());
                    break;
                }
                case 7: {
                    System.out.println("Qual o código da moeda de origem?");
                    String fromCurrency = scanner.nextLine().toUpperCase();

                    try {
                        System.out.println("Quantia: ");
                        fromAmount = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("ERRO: Erro de input, digite um número válido");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("Qual o código da moeda de destino?");
                    String toCurrency = scanner.nextLine().toUpperCase();


                    boolean isValid = controller.validateInput(fromCurrency, toCurrency, fromAmount);
                    if (isValid) {
                        exchange = new CurrencyExchange(CurrencyEnum.valueOf(fromCurrency), CurrencyEnum.valueOf(toCurrency), LocalDateTime.now());
                        response = controller.customConversion(exchange, fromAmount);
                    }
                    break;
                }
                case 8: {
                    showHistory();
                    break;
                }
                default:
                    System.out.println("Digite uma opção válida: ");
            }

            if (exchange != null) {
                response = controller.defaultConversion(exchange, fromAmount);
                responseHistory.add(response);
            }
            if (response != null) System.out.println(response);

            System.out.println("Aperte enter para continuar...");
            scanner.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    private void showHistory() {
        for (int i = 0; i < responseHistory.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + responseHistory.get(i) + "\t| Quando: "
                    + responseHistory.get(i).currencyExchange().getLocalDateTime().format(formatter));
        }
    }
}
