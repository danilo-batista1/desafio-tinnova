package org.example;

public class MultiplosDeTresOuCinco {

    // Método que retorna a soma dos múltiplos de 3 ou 5 até um número X
    public int somaMultiplos(int x) {
        int soma = 0;
        for (int i = 1; i < x; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }
        return soma;
    }

}
