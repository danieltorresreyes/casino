/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fup.casino.logica;

/**
 * Esta clase representa a una carta con atributos como valor y pinta
 *
 * @author Daniel Torres Reyes
 */
public class Carta {
    /**
     * Clase con la que vamos a representar cada una de las cartas de la baraja 
     * Declaración del atributo valor el cual puede ser una letra o numero
     */
    private String valor;
    /**
     * Declaración del atributo pinta el cual es un simbolo que representara a
     * los diamantes, corazones, picas y treboles
     * Declaramos un atributo de tipo boolean que retorna true si esta destapada 
     */
    private String pinta;
    private boolean tapada;

    /**
     *  Nuestra carta recibe un valor y una pinta de tipo String
     * @param valor
     * @param pinta
     * @param tapada
     */
    public Carta(String valor, String pinta) {
        this.valor = valor;
        this.pinta = pinta;
        this.tapada = true;
    }
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPinta() {
        return pinta;
    }

    public void setPinta(String pinta) {
        this.pinta = pinta;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    /**
     * Declaramos getPuntos que parcea ese valor
     */ 
    /**
     * determina un valor entero al valor de la carta
     * @return int
     */
    public int getPuntos() {
        if (null != valor) {
            switch (valor) {

                case "J":
                case "Q":
                case "K":
                    return 10;
                case "A":
                    return 11;

                default:
                    return Integer.parseInt(valor);
            }
        }
        return -100;
    }
    

    

}


