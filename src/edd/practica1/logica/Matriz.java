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
public class Matriz {
    
    private NodoMatriz mBase = new NodoMatriz();
    
    public Matriz(){
        
    }
    
    public void insertaNodo(Data dato){
        //Si la entrada viene vacia que no la agregue a la matriz
        if(dato == null){
            return;
        }
        
        int fila = dato.getFila();
        String columna = dato.getColumna();
        
        NodoMatriz temp = mBase;
        
        //*****************INGRESO DE NODO LA PRIMERA VEZ**************//
        /*CASO 1*/
        if(temp.getDerecha() == null && temp.getAbajo() == null){
            //Creamos el NODO DE FILA, COLUMNA y el NODO del dato como tal
            NodoMatriz nodoFila = new NodoMatriz();
            NodoMatriz nodoColumna = new NodoMatriz();
            NodoMatriz nodoElemento = new NodoMatriz();
            //Se agregan los datos a los nodos
            nodoFila.setFila(fila);
            nodoColumna.setColumna(columna);
            nodoElemento.agregarAvatar(dato);
            //NODO fila apunta a nodo Elemento y a nodo base
            nodoFila.setDerecha(nodoElemento);
            nodoFila.setArriba(temp);
            //Nodo columna apunta al nodo Elemento y al nodo base
            nodoColumna.setAbajo(nodoElemento);
            nodoColumna.setIzquierda(temp);
            //El nodo Elemento apunta a fila y columna
            nodoElemento.setArriba(nodoColumna);
            nodoElemento.setIzquierda(nodoFila);
            //Nodo base apunta a nodo fila y nodo columna
            temp.setDerecha(nodoColumna);
            temp.setAbajo(nodoFila);
            return;
        }
        /*--------------------------------------------------------*/
        //Temporal ahora toma al nuevo nodo Fila
        temp = mBase.getAbajo();
        boolean hayFila = false;
        boolean hayColumna = false;
        //Se verifica si ya hay una Columna
        while(temp != null){
            if(temp.getFila() == fila){
                hayFila = true;
                break;
            }
            temp = temp.getAbajo();
        }
        /*********************SI HAY FILA EXISTENTE*****************/
        if(hayFila){
            temp = temp.getDerecha();
            hayColumna = false;
            
            while(temp != null){
                //Compra si ya hay un elemento en la fila con la misma columna
                if(temp.getColumna().compareToIgnoreCase(columna) == 0){
                    hayColumna = true;
                    break;
                }
                temp = temp.getDerecha();
            }
            //SI EL ELEMENTO INGRESADO TIENE FILA Y COLUMNA EXISTENTE
            /***********CASO 2***************/
            if(hayColumna){
                temp.agregarAvatar(dato);
                return;
            }
            /********************CASO 3*************/
            //Si hay fila existente pero columna inexistente
            else{
                NodoMatriz temp2 = mBase.getDerecha();
                NodoMatriz nodoColumna = new NodoMatriz();
                nodoColumna.setColumna(columna);
                NodoMatriz nodoElemento = new NodoMatriz();
                nodoElemento.agregarAvatar(dato);
                while(temp2 != null){
                    if(temp2.getDerecha() != null){
                        nodoColumna.setAbajo(nodoElemento);
                        nodoColumna.setIzquierda(temp2);
                        nodoElemento.setArriba(nodoColumna);
                        temp2.setDerecha(nodoColumna);
                        break;
                    }
                    temp2 = temp2.getDerecha();
                }
                temp = temp2.getDerecha();
                boolean hayFila2 = false;
                NodoMatriz tempo = mBase.getAbajo();
                while(tempo != null){
                    if(tempo.getFila() == fila){
                        hayFila2 = true;
                        break;
                    }
                    tempo = tempo.getAbajo();
                }
                if(hayFila2){
                    NodoMatriz tempo2 = tempo.getDerecha();
                    while(tempo2 != null){
                        if(tempo2.getDerecha() == null){
                            tempo2.setDerecha(nodoElemento);
                            nodoElemento.setIzquierda(tempo2);
                            break;
                        }
                        tempo2 = tempo2.getDerecha();
                    }
                }
                return;
            }
        }else{
            /*****************************CAS 4 Y CASO 5******************/
            //NO HAY FILA
            NodoMatriz tem = mBase.getAbajo();
            NodoMatriz nodoFila = new NodoMatriz();
            nodoFila.setFila(fila);
            NodoMatriz nodoElemento = new NodoMatriz();
            nodoElemento.agregarAvatar(dato);
            while(tem != null){
                //caso 5
                if(tem.getFila()>fila){
                    NodoMatriz anteriorF = tem.getArriba();
                    nodoFila.setAbajo(temp);
                    nodoFila.setArriba(anteriorF);
                    nodoElemento.setIzquierda(nodoFila);
                    nodoFila.setDerecha(nodoElemento);
                    tem.setArriba(nodoFila);
                    anteriorF.setAbajo(nodoFila);
                    break;
                }else{
                    //caso 4
                    if(tem.getAbajo() == null){
                        tem.setAbajo(nodoFila);
                        nodoFila.setArriba(tem);
                        nodoFila.setDerecha(nodoElemento);
                        nodoElemento.setIzquierda(nodoFila);
                        break;
                    }
                }
                tem = tem.getAbajo();
            }
            NodoMatriz tempo = mBase.getDerecha();
            while(tempo != null){
                if(tempo.getColumna().compareToIgnoreCase(columna) == 0){
                    NodoMatriz temp4 = tempo.getAbajo();
                    if(temp4 != null){
                        while(temp4 != null){
                            if(temp4.getFila()>fila){
                                NodoMatriz anteriorF = temp4.getArriba();
                                nodoElemento.setAbajo(temp4);
                                nodoElemento.setArriba(anteriorF);
                                anteriorF.setAbajo(nodoElemento);
                                temp4.setArriba(nodoElemento);
                                break;
                            }
                            temp4 = temp4.getAbajo();
                        }
                        break;
                    }else{
                        nodoElemento.setArriba(temp4);
                        temp4.setAbajo(nodoElemento);
                        break;
                    }
                }else{
                    //caso 6
                    if(tempo.getDerecha() == null){
                        NodoMatriz nodoColumna = new NodoMatriz();
                        nodoColumna.setColumna(columna);
                        tempo.setDerecha(nodoColumna);
                        nodoColumna.setIzquierda(tempo);
                        nodoColumna.setAbajo(nodoElemento);
                        nodoElemento.setArriba(nodoColumna);
                    }
                }
                tempo = tempo.getDerecha();
            }
        }
        return;
    }
    
}
