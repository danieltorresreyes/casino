/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casino.logica;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel Torres Reyes
 * Dealer o repartidor 
 */
public class Dealer {
    /**
      * Declaracion de un objeto de tipo baraja
      * Declaramos un arreglo de cartas de tipo Carta
     */
    private Baraja baraja;
    private ArrayList<Carta>  cartas;  
    
    /**
     * Constructor
     */
    public Dealer() {        
        baraja = Baraja.getInstance();
        cartas = new ArrayList<>();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    } 
    /**
     * metodo que muetra las cartas  
     */
    public void mostarCartas() {
        ArrayList<Carta> cartasBaraja = baraja.getCartas();
        for (int i = 0; i < cartasBaraja.size(); i++) {
            Carta car = cartasBaraja.get(i);
            System.out.print(car.getValor() + "" + car.getPinta() + ",");
        }

    }
        
//           for (int i=0; i < baraja.getCartas().size(); i++){
//           System.out.print(baraja.getCartas().get(i).getValor()+baraja.getCartas().get(i).getPinta()+",");
//        }
//    }
//        
    /**
     * Recibe tapada de tipo boolean que Saca una carta de la baraja tapada,indica que en su posicion ahora no hay nada
     * @param tapada
     * @return 
     */
    public Carta sacarCarta(boolean tapada) {
      Carta carta=baraja.getCartas().get(0);
      baraja.getCartas().remove(0);
      baraja.getCartas().add(new Carta("_", "_"));
      carta.setTapada(tapada);
      return carta;
    }
    
    /**
     * Motodo que revuelve las Cartas en nveces segun el parametro que recibe 
     * @param nVeces 
     */
    public void barajar(int nVeces) {
        ArrayList<Carta> cartas = baraja.getCartas();
        int i = 0, n = nVeces;
        Random numAleatorio = new Random();
        while (i < n) {
            for (int j = 0; j < cartas.size(); j++) {
                int pibote = numAleatorio.nextInt(52);
                Carta temp = cartas.get(i);
                cartas.set(i, cartas.get(pibote));
                cartas.set(pibote, temp);
            }
            i++;
        }
    }
    
    /**
     * recibe una carta de tipo Carta piderCartas lo que hace es pedir carta 
     * @param carta 
     */
    public void pedirCarta(Carta carta){
        if (cartas.size()<Constantes.Maximo_de_Cartas_del_Jugador){
        cartas.add(carta);
    }else{
        System.out.println("El maximo de cartas por jugador es: "+ Constantes.Maximo_de_Jugadores_en_la_Mesa);
        }
    }
    /**
     * Declaramos un metodo sumarCartas int
     * permite mirar los puntos del valor de la cartas
     * @return int
     */
    public int sumarCartas() {
        int acum = 0;
        for (int i = 0; i < cartas.size(); i++) {
            acum = acum + cartas.get(i).getPuntos();

        }
        return acum;
    }

    //Declaramos un metodo pensar de tipo boolean 
    public boolean pensar() {
        int acomulador=0;
        for (Carta carta:cartas){
            acomulador=acomulador+carta.getPuntos();
    }
        return acomulador<17;
    }

    /**
     * En esta parte retorna una cartas tapada 
     */
    public void mostrarJuego() {
        Carta cartatemp = null;
        for (int i = 0; i < cartas.size(); i++) {
            cartatemp = cartas.get(i);
            if (cartatemp.isTapada()) {
                System.out.print(cartatemp.getValor() + "" + cartatemp.getPinta() + ",");

            } else {
                System.out.print("(" + cartatemp.getValor() + "" + cartatemp.getPinta() + "),");
            }
        }
    }
    
  
}
