package com.diego.torresdehanoi.Model;

public class Torre {

    private Disco[] discos;
    private int tope;
    private int capacidad;
    private int id;

    public Torre() {}
    public Torre(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.discos = new Disco[capacidad];
        this.tope = 0;
    }

    public boolean push(Disco disco) {
        if (tope >= capacidad) {
            return false; // torre llena
        }
        discos[tope] = disco;
        tope++;
        return true;
    }

    public Disco pop() {
        if (estaVacia()) {
            return null;
        }
        tope--;
        Disco disco = discos[tope];
        discos[tope] = null; // limpiar referencia
        return disco;
    }

    public Disco peek() {
        if (estaVacia()) {
            return null;
        }
        return discos[tope - 1];
    }

    public boolean estaVacia() {
        return tope == 0;
    }

    public boolean estaLlena() {
        return tope == capacidad;
    }

    public int size() {
        return tope;
    }

    public int getId() {
        return id;
    }
}
