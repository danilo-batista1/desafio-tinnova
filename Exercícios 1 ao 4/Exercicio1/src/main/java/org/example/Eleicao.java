package org.example;

public class Eleicao {

    // Atributos da classe para armazenar os valores de eleitores e votos
    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;

    // Construtor para inicializar os dados da eleição
    public Eleicao(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    // Método para calcular o percentual de votos válidos
    public double calcularPercentualValidos() {
        return (double) votosValidos / totalEleitores * 100;
    }

    // Método para calcular o percentual de votos brancos
    public double calcularPercentualBrancos() {
        return (double) votosBrancos / totalEleitores * 100;
    }

    // Método para calcular o percentual de votos nulos
    public double calcularPercentualNulos() {
        return (double) votosNulos / totalEleitores * 100;
    }

}
