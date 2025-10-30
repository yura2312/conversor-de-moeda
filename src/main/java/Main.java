import model.CurrencyExchange;
import service.HttpService;
import view.Menu;

public class Main {
    static void main(String[] args) {
//
//        CurrencyExchange exchange = new CurrencyExchange("BRL", "USD");
//
//        HttpService service = new HttpService(exchange);
//        service.setAPIRoute();

        Menu menu = new Menu();
        menu.showMenu();
    }
}
