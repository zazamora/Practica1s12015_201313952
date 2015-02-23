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
    private String ataque;
    private int puntos;
    private String tipo;
    private ListaEnlazada lista = new ListaEnlazada();
    public ListaEnlazada getLista(){
        return lista;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Data() {
        
    }

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

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Data(String nombre,String imagen, String ataque, int puntos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ataque = ataque;
        this.puntos = puntos;
    }
    
}
