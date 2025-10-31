package model;

public enum CurrencyEnum {
    USD("Dólar"),
    BRL("Real brasileiro"),
    ARS("Peso Argentino"),
    BOB("Boliviano boliviano"),
    CLP("Peso chileno"),
    COP("Peso colombiano");


    public final String currencyName;

    CurrencyEnum(String currencyName) {
        this.currencyName = currencyName;
    }

    public static CurrencyEnum validateEnum(String currency) {
        for (CurrencyEnum currencyEnum : CurrencyEnum.values()) {
            if (currencyEnum.name().equals(currency)) {
                return CurrencyEnum.valueOf(currency);
            }
        }
        return null;
    }
}
