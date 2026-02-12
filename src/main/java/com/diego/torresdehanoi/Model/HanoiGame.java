package com.diego.torresdehanoi.Model;

public class HanoiGame {

    private Torre[] torres;
    private int numTorres;
    private int contador;


    public HanoiGame(int numTorres, int numDiscos) {

        this.numTorres = numTorres;
        this.contador = 0;

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
            contador++;
            return true;
        }

        // Caso 2: destino no vacío
        Disco discoDestino = torres[destino].peek();

        if (discoOrigen.getTamano() < discoDestino.getTamano()) {

            torres[origen].pop();
            torres[destino].push(discoOrigen);
            contador++;
            return true;
        }

        return false;
    }


    public boolean resuelto() {
        // verificar si última torre tiene todos los discos
        return false;
    }
}
