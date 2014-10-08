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
public class Jugador {

    /**
     * Declaracion una variable nombre de tipo String en nuestro arreglo
     * declaramos cartasd de tipo Carta
     */
    private String nombre;
    private int fichas;
    ArrayList<Carta> cartasd;

    //recibe un String y un entero en el metodo
    //Contructor le damos espacio de memoria 
    public Jugador(String nombre, int fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
        cartasd = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    /**
     * Motodo que retorna una carta de tipo carta y pedir carta
     *
     * @param carta
     */
    public void pedirCarta(Carta carta) {
        if (cartasd.size() < Constantes.Maximo_de_Cartas_del_Jugador) {
            cartasd.add(carta);
        } else {
            System.out.println(" El maximo de cartas por jugador es: " + Constantes.Maximo_de_Jugadores_en_la_Mesa);
        }
    }

    /**
     * Siver para mostrar las cartas del jugador
     */
    public void mostrarCartas() {
        Carta cartatempora = null;
        for (int i = 0; i < cartasd.size(); i++) {
            cartatempora = cartasd.get(i);
            if (cartatempora.isTapada()) {

                System.out.print(cartasd.get(i).getValor() + cartasd.get(i).getPinta() + ",");
            } else {
                System.out.print("(" + cartatempora.getValor() + "" + cartatempora.getPinta() + "),");
            }

        }

    }

    /**
     * Metodo que suma los puntos de las cartas del jugador
     *
     * @return
     */
    public int sumarCartas() {
        int acum = 0;
        for (int i = 0; i < cartasd.size(); i++) {
            acum = acum + cartasd.get(i).getPuntos();
            if (acum > 21 && cartasd.get(i).getValor().equals("A")) {
                acum = acum - 10;
            }
        }
        return acum;
    }

    /**
     * Metodo para contar las cartas abiertas de todos los jugadores las cartas
     * pequeñas se le aplica un valor de +1(2 3 4 5 6 7), y a todas las cartas
     * altas se le aplica un valor de -1(J Q K A 10) Las cartas neutras no se
     * cuentan.
     *
     * @param cartasAbiertas
     * @return int
     */
    public int contarCartas(ArrayList<Carta> cartasAbiertas) {
        int cuentaCartas = 0;
        for (Carta carta : cartasAbiertas) {
            switch (carta.getValor()) {
                case "10":
                case "J":
                case "Q":
                case "K":
                case "A":
                    cuentaCartas--;
                    break;
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    cuentaCartas++;
                    break;
                case "7":
                case "8":
                case "9":
                    cuentaCartas = cuentaCartas + 0;
                    break;
                default:
                    cuentaCartas = cuentaCartas + 0;
                    break;
            }

        }

        return cuentaCartas;
    }

    /**
     * metodo que sirve para el conteo de las cartas y sabe en que momento pide
     * otra carta y las condiciones para cada caso 10,15 - 16,17 - (18,21 si el conteo esta bajo) 
     *
     * @param cartasAbiertas
     * @return boolean
     */
    public boolean pensar(ArrayList<Carta> cartasAbiertas) {
        int ct = contarCartas(cartasAbiertas);
        int acumulador = sumarCartas();
        if (acumulador >= 18 && acumulador <= 21) {
            return false;
        } else if (acumulador >= 10 && acumulador <= 15) {
            return false;

        } else if (acumulador >= 16 && acumulador <= 17 && ct >= -2 && ct <= -4) {
            return false;
        }
        if (acumulador >= 10 && acumulador <= 15) {
            return true;
        } else if (acumulador >= 16 && acumulador <= 17) {
            return false;
        }

        if (acumulador >= 16 && acumulador <= 18 && ct >= -2 && ct <= -3) {
            return true;
        } else if (acumulador >= 10 && acumulador <= 15) {
            return false;
        }

        return false;

    }
}
