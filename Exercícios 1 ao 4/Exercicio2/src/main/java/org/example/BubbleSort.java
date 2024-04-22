package org.example;

public class BubbleSort {

    public static void sort(int[] vetor) {
        int n = vetor.length;
        boolean trocado;

        for (int i = 0; i < n - 1; i++) {
            trocado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // Troca os elementos
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocado = true;
                }
            }
            // Se nenhum elemento foi trocado nesta iteração, o vetor está ordenado
            if (!trocado) {
                break;
            }
        }
    }

}
