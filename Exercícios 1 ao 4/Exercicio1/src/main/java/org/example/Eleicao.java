package org.example;

public class Eleicao {

    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;

    public Eleicao(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public double calcularPercentualValidos() {
        return (double) votosValidos / totalEleitores * 100;
    }

    public double calcularPercentualBrancos() {
        return (double) votosBrancos / totalEleitores * 100;
    }

    public double calcularPercentualNulos() {
        return (double) votosNulos / totalEleitores * 100;
    }

}
