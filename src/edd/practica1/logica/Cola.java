/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1.logica;
import java.util.LinkedList;
/**
 *
 * @author Saul
 */
public class Cola <T> {
        LinkedList cola = new LinkedList();
        
        //Encolar dato
        public void encolar(T dato){
            cola.addFirst(dato);
        }
        
        //Desencolar dato
        public T desencolar(){
            return (T)cola.removeLast();
        }
        
}
