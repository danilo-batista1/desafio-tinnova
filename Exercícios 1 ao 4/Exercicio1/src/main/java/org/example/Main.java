package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Criando uma instância da classe Eleicao com os dados fornecidos
        Eleicao eleicao = new Eleicao(1000, 800, 150, 50);

        // Exibindo os resultados
        System.out.println("Percentual de Votos Válidos: " + eleicao.calcularPercentualValidos() + "%");
        System.out.println("Percentual de Votos Brancos: " + eleicao.calcularPercentualBrancos() + "%");
        System.out.println("Percentual de Votos Nulos: " + eleicao.calcularPercentualNulos() + "%");
    }

}