/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import gestion_empresa_autobuses.Viaje;
import java.io.Serializable;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class LEG<E> implements Serializable{
    protected NodoLEG<E> primero;
    
    public LEG(){
       primero=null; 
    }

    public NodoLEG<E> getPrimero() {
        return primero;
    }
    
    public void insertar(E x){
        primero = new NodoLEG<E>(x, primero);
    }
    
    public void insertarEnFin(E x){
        NodoLEG<E> nl = new NodoLEG<E>(x);
        NodoLEG<E> aux = primero;
        if(aux==null)primero=nl;
        else{
            while(aux.siguiente!=null)aux = aux.siguiente;
            //aux referencia al último nodo de la lista
            aux.siguiente=nl;
        }
    }
    
    @Override
    public String toString(){
        String res="";
        for(NodoLEG<E> aux=primero; aux!=null;aux=aux.siguiente){
            res+=aux.dato.toString()+"\n";
        }
        return res;
    }
    
    public boolean eliminar(E x){
        NodoLEG<E> aux=primero; NodoLEG<E> ant=null; boolean res = false;
        while(aux!=null && !aux.dato.equals(x)){
            ant = aux; aux=aux.siguiente;
        }
        if(aux!=null){
            res=true;
            if(ant==null)primero=aux.siguiente;
            else ant.siguiente=aux.siguiente;
        }
        return res;
    }
    
    public E recuperar(int i){
        NodoLEG<E> aux; int j;
        for(aux=primero, j=0; j<i;aux=aux.siguiente, j++){;}
        return aux.dato;
    }
    
    public NodoLEG buscar(int codigo){
        NodoLEG nodoActual = primero;
        
        while (nodoActual != null) {
            Viaje v = (Viaje) nodoActual.dato;
            
            if (v.getCodigo()==codigo ) {
                return nodoActual; // El valor se encuentra en este nodo
            }
            nodoActual = nodoActual.siguiente;
        }
        
       return null; // El valor no se encuentra en la lista
    }
    
    
    public NodoLEG buscarPorOrigen(String origen){
        NodoLEG nodoActual = primero;
        
        while (nodoActual != null) {
            Viaje v = (Viaje) nodoActual.dato;
            
            if (v.getOrigen().equals(origen)) {
                return nodoActual; // El valor se encuentra en este nodo
            }
            nodoActual = nodoActual.siguiente;
        }
        
       return null; // El valor no se encuentra en la lista   
    }
    
    
    public NodoLEG buscarPorDestino(String destino){
        NodoLEG nodoActual = primero;
        
        while (nodoActual != null) {
            Viaje v = (Viaje) nodoActual.dato;
            
            if (v.getDestino().equals(destino)) {
                return nodoActual; // El valor se encuentra en este nodo
            } 
            nodoActual = nodoActual.siguiente;
        }
        
       return null; // El valor no se encuentra en la lista   
    }
    
    public int contarElementos() {
        int contador = 0;
        NodoLEG<E> actual = this.primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
    
    public void mostrarInfoViajes() {
    NodoLEG actual = primero;

    while (actual != null) {
        Viaje v = (Viaje) actual.getDato();
        System.out.printf("%-10s %-10s %-10s %-10s\n", v.getCodigo(), v.getOrigen(), v.getDestino(), v.getHora());
        System.out.println("-----------------------------------------------");

        actual = actual.getSiguiente();
    }
}
    
}