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
public class ListaEnlazada {
    
    protected Nodo primero;
    
    public ListaEnlazada(){
        primero = null;
    }
    //Insertar al Principio de la lista
    public void InsertarFrente(Data datos){
        Nodo nuevo = new Nodo(datos);
        if(primero == null)
            primero = nuevo;
        else{
            nuevo.setSiguiente(nuevo);
            primero = nuevo;
        }
    }
    //Insertar al Final de la lista
    public void InsertarFinal(Data datos){
        Nodo nuevo = new Nodo(datos);
        Nodo aux;
        if(esVacia()){
            primero = nuevo;
        }else{
            aux = primero;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }
    
    //Quitar primer nodo de la lista
    public void EliminarFrente(){
        Nodo aux;
        if(!esVacia()){
            aux = primero;
            primero = primero.getSiguiente();
            aux = null;
        }
    }
    
    //Quitar ultimo nodo de la lista
    public void EliminarFinal(){
        if(primero.getSiguiente() == null){
            primero = null;
        }else{
            Nodo aux = primero;
            Nodo temp = null;
            while(aux.getSiguiente() != null){
                temp = aux;
                aux = aux.getSiguiente();
            }
            temp.setSiguiente(aux.getSiguiente());
        }
    }
    
    //Metodo para saber si está vacía la lista
    public boolean esVacia(){
        if(primero == null){
            return true;
        }else{
            return false;
        }
    }
}
