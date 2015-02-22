/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1.logica;

/**
 *
 * @author Saul
 */
public class Data {
    private String nombre;
    private int cantidad;
    private String imagen;
    private int ataque;
    private int puntos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Data(String nombre, int cantidad, String imagen, int ataque, int puntos) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.ataque = ataque;
        this.puntos = puntos;
    }
    
}
