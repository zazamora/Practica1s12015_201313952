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
public class Cola  {
    Nodo first;
    Nodo end;
    int size;
    
    public Cola(){
        end = null;
        size = 0;
    }
    //Agregar un objeto a la cola
    public void encolar(Data dato){
        Nodo nuevo = new Nodo(dato);
        if(first == null){
            first = nuevo;
            end = nuevo;
        }else{
            end.setSiguiente(nuevo);
            end = nuevo;
        }
        size++;
    }
    
    //Sacar un objeto de la cola
    public Data desencolar(){
        if(first == null)
            return null;
        Data dato = first.getDatos();
        first = first.getSiguiente();
        size--;
        return dato;
    }
    
    //Verifica si esta vacia la cola
    public boolean isEmpty(){
        return (size == 0);
    }
    
    //Retorna el valor del primer dato
    public Data peek(){
        if(first == null)
            return null;
        else
            return first.getDatos();
    }
    
    //Retorna el numero de elementos
    public int size()
    {
        return size;
    }
}
