package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fatorial fatorial = new Fatorial(); // Criar uma instância da classe Fatorial

        System.out.println("Digite um número para calcular o fatorial:");
        int num = scanner.nextInt(); // Ler o número do usuário

        try {
            long resultado = fatorial.calcular(num); // Calcular o fatorial
            System.out.println("O fatorial de " + num + " é: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

}