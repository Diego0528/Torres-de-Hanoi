package com.diego.torresdehanoi.Model;

import java.util.ArrayList;
import java.util.List;

public class HanoiGame {

    private Torre[] torres;
    public int getNumTorres() {
        return numTorres;
    }
    public int getNumDiscos() {
        return numDiscos;
    }

    private int numTorres;
    private int numDiscos;


    public HanoiGame(int numTorres, int numDiscos) {

        this.numTorres = numTorres;
        this.numDiscos = numDiscos;

        // Crear arreglo de torres
        torres = new Torre[numTorres];

        // Inicializar torres
        for (int i = 0; i < numTorres; i++) {
            torres[i] = new Torre(i, numDiscos);
        }

        // Llenar la primera torre con los discos
        for (int i = numDiscos; i >= 1; i--) {
            torres[0].push(new Disco(i));
        }
    }

    public boolean mover(int origen, int destino) {

        // Validar índices
        if (origen < 0 || origen >= torres.length ||
                destino < 0 || destino >= torres.length ||
                origen == destino) {
            return false;
        }

        // Validar que origen no esté vacío
        if (torres[origen].estaVacia()) {
            return false;
        }

        Disco discoOrigen = torres[origen].peek();

        // Caso 1: destino vacío
        if (torres[destino].estaVacia()) {

            torres[origen].pop();
            torres[destino].push(discoOrigen);
            return true;
        }

        // Caso 2: destino no vacío
        Disco discoDestino = torres[destino].peek();

        if (discoOrigen.getTamano() < discoDestino.getTamano()) {

            torres[origen].pop();
            torres[destino].push(discoOrigen);
            return true;
        }

        return false;
    }

    private List<int[]> movimientos = new ArrayList<>();

    public List<int[]> getMovimientos() {
        return movimientos;
    }

    public void resolver(int n, int origen, int auxiliar, int destino) {

        if (n == 1) {
            movimientos.add(new int[]{origen, destino});
            return;
        }

        resolver(n - 1, origen, destino, auxiliar);
        movimientos.add(new int[]{origen, destino});
        resolver(n - 1, auxiliar, origen, destino);
    }

    public boolean resuelto(int totalDiscos) {
        return torres[torres.length - 1].size() == totalDiscos;
    }
}
