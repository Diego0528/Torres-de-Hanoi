package com.diego.torresdehanoi.Model;

import java.util.List;

public class HanoiSolver {

    private void resolver(int n, int origen, int auxiliar, int destino) {
        if (n == 1) {
            movimientos.add(new Movimiento(origen, destino));
        } else {
            resolver(n - 1, origen, destino, auxiliar, movimientos);
            movimientos.add(new Movimiento(origen, destino));
            resolver(n - 1, auxiliar, origen, destino, movimientos);
        }
    }
}
