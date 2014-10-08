/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casino;

import java.util.ArrayList;
import org.fup.casino.logica.Carta;
import org.fup.casino.logica.Dealer;
import org.fup.casino.logica.Jugador;
import org.fup.casino.logica.MesaJugador;

/**
 *
 * @author Daniel Torres Reyes
 */
public class Casino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Carta carta = new Carta("A","♣");        
//        System.out.println("Los puntos de estas cartas son: "+carta.getPuntos());

        ArrayList<Carta> cartasdestapadas = new ArrayList<>();
        Carta temporal = null;

        Dealer d = new Dealer();
      
        d.mostarCartas();
        d.barajar(5);
        System.out.println("");
        d.mostarCartas();

        Jugador jug1 = new Jugador("Ricardo", 8000);
        Jugador jug2 = new Jugador("Alejandro", 6000);

        temporal = d.sacarCarta(false);
        cartasdestapadas.add(temporal);
        jug1.pedirCarta(temporal);
        jug1.pedirCarta(d.sacarCarta(true));

//        temporal = d.sacarCarta(false);
//        cartasdestapadas.add(temporal);
//        jug2.pedirCarta(temporal);
//        jug2.pedirCarta(d.sacarCarta(true));
        
//        temporal=d.sacarCarta(false);
//        cartasdestapadas.add(temporal);
//        d.pedirCarta(temporal);
//        d.pedirCarta(d.sacarCarta(true));

        System.out.println("");
        MesaJugador mj = new MesaJugador(d);

        mj.sentarJugador(jug1);
        mj.sentarJugador(jug2);

        mj.mostrarJugadores();

//        d.mostarCartas();
//        System.out.println("");
//        System.out.print("cartas destapadas: ");
//            for (int i = 0; i < cartasdestapadas.size(); i++) {
//            Carta car = cartasdestapadas.get(i);
//            System.out.print(car.getValor() + "" + car.getPinta() + ",");
//        }

    }
}
