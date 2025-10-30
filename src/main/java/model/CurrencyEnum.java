package model;

public enum CurrencyEnum {
    USD("Dólar"),
    BRL("Real brasileiro"),
    ARS("Peso Argentino"),
    BOB("Boliviano boliviano"),
    CLP("Peso chileno"),
    COP("Peso colombiano");


    public final String nome;

    CurrencyEnum(String nome) {
        this.nome = nome;
    }
}
