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
public class NodoMatriz {
    private NodoMatriz mArriba = null;
    private NodoMatriz mAbajo = null;
    private NodoMatriz mDerecha = null;
    private NodoMatriz mIzquierda = null;
    
    private ListaEnlazada mElementos = null;
    
    private String columna = "";
    private int fila = 0;

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public void agregarAvatar(Data dato){
        if(dato == null){
            return;
        }
        if(mElementos == null){
            fila = dato.getFila();
            columna = dato.getColumna();
            mElementos = new ListaEnlazada();
        }
        mElementos.InsertarFinal(dato);
    }

    public NodoMatriz getArriba() {
        return mArriba;
    }

    public void setArriba(NodoMatriz mArriba) {
        this.mArriba = mArriba;
    }

    public NodoMatriz getAbajo() {
        return mAbajo;
    }

    public void setAbajo(NodoMatriz mAbajo) {
        this.mAbajo = mAbajo;
    }

    public NodoMatriz getDerecha() {
        return mDerecha;
    }

    public void setDerecha(NodoMatriz mDerecha) {
        this.mDerecha = mDerecha;
    }

    public NodoMatriz getIzquierda() {
        return mIzquierda;
    }

    public void setIzquierda(NodoMatriz mIzquierda) {
        this.mIzquierda = mIzquierda;
    }

    public ListaEnlazada getElementos() {
        return mElementos;
    }

    public void setElementos(ListaEnlazada mElementos) {
        this.mElementos = mElementos;
    }
    
   
}
