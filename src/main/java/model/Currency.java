package model;

public enum Currency {
    USD("Dólar"),
    BRL("Real brasileiro"),
    ARS("Peso Argentino"),
    BOB("Boliviano boliviano"),
    CLP("Peso chileno"),
    COP("Peso colombiano");


    public final String nome;

    Currency(String nome) {
        this.nome = nome;
    }
}
