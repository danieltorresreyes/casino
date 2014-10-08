/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casino.logica;

import java.util.ArrayList;

/**
 *
 * @author Daniel Torres Reyes
 */
public class Baraja {
    /**
     * Clase que representara nuestra baraja de 52 cartas
     * instancia 1 objeto Sigleton
     */
    private static Baraja baraja;
    private ArrayList<Carta> cartas;

    /**
     *  Metodo que se encarga de crear la baraja de 52 cartas
     *  Recorremos todos los valores y todos los Pintas posibles
     */  
    public Baraja() {
        cartas=new ArrayList<>();
        crBaraja();
    }

      public ArrayList<Carta>  getCartas() {
        return cartas;
    }
    public void setCartas(ArrayList<Carta>  cartas) {
        this.cartas = cartas;
    } 
           
    /**
     * se encarga de instanciar la clase Baraja
     * @return 
     */
    public static Baraja getInstance(){
        if (baraja == null){
            baraja = new Baraja();
        }
        return baraja;
    }
    /**
     * Motodo que se encarga de crear la baraja de 52 cartas
     */
    public void crBaraja() {
        String[] pintas = {"♥", "♦", "♣", "♠"};
        String[] valores = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        cartas = new ArrayList(52);
        for (int i = 0; i < pintas.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                Carta carta = new Carta(valores[j], pintas[i]);
                cartas.add(carta);
            }
        }
    }
 
}
