package com.diego.torresdehanoi.Model;

import java.util.List;

public class HanoiSolver {

    public List<Movimiento> resolver(int discos) {
        List<Movimiento> movimientos = new ArrayList<>();
        hanoi(discos, 0, 1, 2, movimientos);
        return movimientos;
    }

    private void hanoi(int n, int origen, int auxiliar, int destino, List<Movimiento> movimientos) {
        if (n == 1) {
            movimientos.add(new Movimiento(origen, destino));
        } else {
            hanoi(n - 1, origen, destino, auxiliar, movimientos);
            movimientos.add(new Movimiento(origen, destino));
            hanoi(n - 1, auxiliar, origen, destino, movimientos);
        }
    }
}
