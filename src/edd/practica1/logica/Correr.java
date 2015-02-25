/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1.logica;

import edd.practica1.visual.Avatares;
import edd.practica1.visual.Jugador;
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    java.io.File fichero;
    java.io.FileWriter escribirFichero;
    java.io.PrintWriter print;
    
    public void comenzar(){
        listaJ = new ListaEnlazada();
        listaP = new ListaEnlazada();
        listaZ = new ListaEnlazada();
        panJugador = new Jugador();
        panAvatar = new Avatares();
    }
    public void generarGraph(String nombre){
        try{
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Users\\Saul\\Desktop\\Graphs\\" + nombre + ".txt";
            String fileOutputPath = "C:\\Users\\Saul\\Desktop\\" + nombre + ".jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String [] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        }catch(Exception e){

        }
    }
    public void generarArchivo(String nombre){
        try {
            fichero = new java.io.File(nombre);
            escribirFichero = new java.io.FileWriter(fichero, false);
            print = new java.io.PrintWriter(escribirFichero);
            
        } catch (IOException ex) {
            Logger.getLogger(Correr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void archivoLista(int tipo){
        ListaEnlazada listaAux = null;
        if(tipo == 0){
            listaAux = listaJ;
        }else if(tipo == 1){
            listaAux = listaP;
        }else if(tipo == 2){
            listaAux = listaZ;
        }
        if(!listaAux.esVacia()){
            Nodo temp = listaAux.getPrimero();
            cabecera();
            while(temp != null){
                if(temp.getSiguiente()!= null){
                    print.println(temp.getDatos().getNombre() + "->" + temp.getSiguiente().getDatos().getNombre() + ";");
                    if(tipo == 0){
                        if(!temp.getDatos().getLista().esVacia()){
                            Nodo aux = temp.getDatos().getLista().getPrimero();
                            print.println(temp.getDatos().getNombre() + "->" + aux.getDatos().getNombre());
                            while(aux!=null){
                                if(aux.getSiguiente()!=null){
                                    print.println(aux.getDatos().getNombre() + "->" + aux.getSiguiente().getDatos().getNombre() + ";");
                                }
                                aux = aux.getSiguiente();
                            }
                        }
                    }
                }
                temp = temp.getSiguiente();
            }
            cerrar();
        }
    }
    private void cabecera(){
        print.println("digraph Grapho");
        print.println("{");
    }
    private void cerrar(){
        print.println("}");
        try {
            escribirFichero.close();
        } catch (IOException ex) {
            Logger.getLogger(Correr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrir(){
        try {
            Desktop.getDesktop().open(fichero);
        } catch (IOException ex) {
            Logger.getLogger(Correr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
