/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1.logica;

import edd.practica1.visual.Avatares;
import edd.practica1.visual.Jugador;

/**
 *
 * @author Saul
 */
public class Correr {
    public static ListaEnlazada listaJ;
    public static ListaEnlazada listaP;
    public static ListaEnlazada listaZ;
    public static Jugador panJugador;
    public static Avatares panAvatar;
    public void comenzar(){
        listaJ = new ListaEnlazada();
        listaP = new ListaEnlazada();
        listaZ = new ListaEnlazada();
        panJugador = new Jugador();
        panAvatar = new Avatares();
    }
}
