/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casino.logica;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Daniel Torres Reyes
 */
public class MesaJugador {

    /**
     * Declaramos un objeto de tipo Dealer Declaramos una lista de objetos de
     * tipo Jugador
     */
    private Dealer d;
    private ArrayList<Jugador> jugadores;
    /**
     * lista de objetos de tipo carta para las cartas abiertas de la mesa
     */
    ArrayList<Carta> cartasAbiertas = new ArrayList<>();

    /**
     * Constructor de mesa recibe como parametro Dealer
     *
     * @param d
     */
    public MesaJugador(Dealer d) {
        this.d = d;
        jugadores = new ArrayList<>();
    }

    /**
     * recibe como parametro jugador y lo que hace es agragar un jugador
     *
     * @param jugador
     */
    public void sentarJugador(Jugador jugador) {
        if (jugadores.size() < Constantes.Maximo_de_Jugadores_en_la_Mesa) {
            jugadores.add(jugador);
        } else {
            System.out.println("El maximo de jugadores por mesa es: " + Constantes.Maximo_de_Jugadores_en_la_Mesa);
        }
    }

    /**
     * recibe como parametro la posicion del jugador
     *
     * @param p
     */
    public void levantarJugador(int p) {
        jugadores.remove(p);
    }

    /**
     * muestra los jugadores
     */
    public void mostrarJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.print("En la posicion  " + i + " El Jugador: " + jugadores.get(i).getNombre()
                    + " Con Fichas: " + jugadores.get(i).getFichas() + " y cartas: ");

            jugadores.get(i).mostrarCartas();
            System.out.println("");
        }

        System.out.print("El Dealer: cartas: ");
        d.mostrarJuego();
        System.out.println("");

    }

    /**
     * inicio de partida se reparte una carta tapada y una destapada, retorna
     * una lista de objetos de tipo Carta para realizar el conteo
     *
     * @return lista
     */
    public ArrayList iniciodePartida() {
        Carta unaCarta;
        for (Jugador jugador : jugadores) {
            unaCarta = d.sacarCarta(true);
            jugador.pedirCarta(unaCarta);
            cartasAbiertas.add(unaCarta);
        }
        unaCarta = d.sacarCarta(true);
        d.pedirCarta(unaCarta);
        cartasAbiertas.add(unaCarta);

        for (Jugador jugador : jugadores) {
            unaCarta = d.sacarCarta(false);
            jugador.pedirCarta(unaCarta);
            cartasAbiertas.add(unaCarta);
        }
        unaCarta = d.sacarCarta(false);
        d.pedirCarta(unaCarta);
        return cartasAbiertas;
    }

    /**
     *
     *piensa los dos el jugador y el dealer 
     * @param numJugadores
     */
    public void jugarPartida(int numJugadores) {
        boolean respuesta = false;
        for (int i = 0; i < numJugadores; i++) {
            sentarJugador(new Jugador("jugador", 5000));
        }

        ArrayList<Carta> cartasAbiertas = iniciodePartida();

        for (Jugador jugador : jugadores) {
            respuesta = jugador.pensar(cartasAbiertas);          
            
            while (respuesta) {
                jugador.pedirCarta(d.sacarCarta(false));
                respuesta = jugador.pensar(cartasAbiertas);

            }     
    
        }
     
        respuesta = d.pensar(); 
         while (respuesta) {
                d.pedirCarta(d.sacarCarta(false));
                respuesta = d.pensar();

            }     

    }
    
    

}
