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
            nuevo.setSiguiente(primero);
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
    //Imprimir datos de la lista
    public void print() {
    // if the list is empty, do nothing
        if (!esVacia()) {
          Nodo tmp = primero;
          // iterates until the list is finished
          while (tmp != null) {
            System.out.println(tmp.getDatos().getNombre());
            tmp = tmp.getSiguiente();
          }
        }else{
            System.out.println("La lista esta vacia.");
        }
    }
    //Calcular cuantos hay en la lista
    public int Cuantos_Elementos(){
        Nodo aux = null;
        int i=0;
        aux = primero;
 
        while(aux != null){
            aux = aux.getSiguiente();
            i++;
        }
        return i;
 
    }
    //Devolver primero de la lista
    public Nodo getPrimero(){
        Nodo aux = null;
        if(!esVacia()){
            aux = primero;
        }
        return aux;
    }
    
    //Devolver el ultimo de la lista
    public Nodo getUltimo(){
        Nodo elemen = null;
        Nodo aux = null;
        if (!esVacia()){
            aux = primero;
            while(aux.getSiguiente() != null)  aux = aux.getSiguiente();
                elemen = aux;
        }
        return elemen;
    }
    //Buscar por tipo
    public Nodo getBusqueda(int tipo){
        Nodo aux = primero;
        Nodo temp = null;
        if(!esVacia()){
            while(aux != null){
                if(aux.getDatos().getTipo() == tipo){
                    temp = aux;
                    break;
                }
                aux = aux.getSiguiente();
            }
        }
        return temp;
    }
    //Obtener por posicion
    public Nodo buscarPosicion(int pos){
 
        Nodo aux, temp = null;
        int cont=1;
 
        aux=primero;
        while(aux!=null){
            if (pos == cont){
                temp = aux;
                break;
            }
            aux = aux.getSiguiente();
            cont++;
            
        }
        return temp;
    }
    
    
    //Metodo para saber si está vacía la lista
    public boolean esVacia(){
        if(primero == null){
            return true;
        }else{
            return false;
        }
    }
    
    //Vacia la lista
    public void vaciarLista(){
        primero = null;
    }
}
