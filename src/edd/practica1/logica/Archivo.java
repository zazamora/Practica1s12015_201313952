/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.practica1.logica;

import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saul
 */
public class Archivo {
    java.io.File fichero;
    java.io.FileWriter escribirFichero;
    java.io.PrintWriter print;
    public void generarGraph(String nombre){
        try{
            String path = "C:\\Users\\Saul\\Documents\\NetBeansProjects\\[EDD]Practica1_201313952\\";
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = path + nombre + ".txt";
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
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
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
    public void archivoPila(Pila pila){
        if(!pila.isEmpty()){
            Pila pilaAux = pila;
            Data auxDato = new Data();
            cabecera();
            while((auxDato = pilaAux.pop()) != null){
                if(auxDato != null){
                    print.println(auxDato.getNombre() + "->" + pilaAux.pop().getNombre() + ";");
                }else{
                    print.println(auxDato.getNombre()  + ";");
                }
            }
            cerrar();
        }
    }
}
