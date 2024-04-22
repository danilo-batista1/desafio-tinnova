package org.example;

public class Fatorial {

    // Método para calcular o fatorial de forma recursiva
    public long calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Número deve ser não-negativo.");
        }
        if (n == 0) {
            return 1; // Caso base: fatorial de 0 é 1
        }
        return n * calcular(n - 1); // Recursão: n! = n * (n-1)!
    }

}
