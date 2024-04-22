package org.example;

public class Main {

    public static void main(String[] args) {
        int[] vetor = {5, 3, 2, 4, 7, 3, 8, 6};

        // Chama o método sort da classe BubbleSort para ordenar o vetor
        BubbleSort.sort(vetor);

        System.out.println("Vetor ordenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}