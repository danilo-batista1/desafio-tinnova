package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiplosDeTresOuCinco calc = new MultiplosDeTresOuCinco(); // Instância da classe que calcula a soma

        System.out.println("Digite um número para calcular a soma dos múltiplos de 3 ou 5 abaixo dele:");
        int num = scanner.nextInt(); // Lê o número fornecido pelo usuário

        int resultado = calc.somaMultiplos(num); // Calcula a soma dos múltiplos de 3 ou 5
        System.out.println("A soma dos múltiplos de 3 ou 5 abaixo de " + num + " é: " + resultado);

        scanner.close();
    }

}