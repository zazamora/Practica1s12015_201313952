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
public class Pila{
    Nodo fin;
    int size;
    public Pila(){
        fin = null;
        size = 0;
    }
    //Ingresa elemento a la pila
    public void push(Data dato){
        Nodo nuevo = new Nodo(dato);
        if(dato != null){
            if(fin == null){
                fin = nuevo;
            }else{
                nuevo.setSiguiente(fin);
                fin = nuevo;
            }
            size++;
        }
    }
    //Retorna elemento de la pila
    public Data pop(){
        if(fin == null){
            return null;
        }
        Data dato = fin.getDatos();
        fin = fin.getSiguiente();
        size--;
        return dato;
    }
    //Verifica si la pila esta vacia
    public boolean isEmpty(){
        return (size == 0);
    }
    //Retorna el tamaño de la pila
    public int size(){
        return size;
    }
    //Retorna el valor del ultimo dato de la pila
    public Data peek(){
        if(fin == null){
            return null;
        }else{
            return fin.getDatos();
        }
    }
}
