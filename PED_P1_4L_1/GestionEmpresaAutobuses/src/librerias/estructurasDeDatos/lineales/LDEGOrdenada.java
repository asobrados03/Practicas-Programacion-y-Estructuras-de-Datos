/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import gestion_empresa_autobuses.Autobus;
import java.io.Serializable;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class LDEGOrdenada<E extends Comparable<E>> implements Serializable{
    private NodoLDEG<E> primero;
    private NodoLDEG<E> ultimo;

    public LDEGOrdenada() {
        primero = null;
        ultimo = null;
    }

    public NodoLDEG<E> getPrimero() {
        return primero;
    }
    
    
    
    public void insertar(E x){
        NodoLDEG<E> nuevo = new NodoLDEG<E>(x);
    
        // Caso base: lista vacía
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        // Caso concreto con último: elemento a insertar mayor o igual al ultimo de la lista
        } else if(x.compareTo(ultimo.dato)>=0){
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }else{   
            NodoLDEG<E> actual = primero;
            //Caso general: recorremos la lista hasta encontrar un nodo adecuado
            while (actual != null && x.compareTo(actual.dato) > 0) {
                actual = actual.siguiente;
            }
            //Si no encontramos un nodo adecuado lo insertamos al final de la lista
            if (actual == null) {
                ultimo.siguiente = nuevo;
                nuevo.anterior = ultimo;
                ultimo = nuevo;
            //Si lo encontramos insertamos el nuevo nodo antes del nodo actual que es el adecuado
            } else {
                NodoLDEG<E> anterior = actual.anterior;
                if(anterior != null){
                    anterior.siguiente = nuevo;
                    nuevo.anterior = anterior;
                    nuevo.siguiente = actual;
                    actual.anterior = nuevo;
                }else{
                    nuevo.anterior = null;
                    nuevo.siguiente = actual;
                    actual.anterior = nuevo;
                    primero = nuevo;
                }
            }
        }
    }
    
    public NodoLDEG buscarPorMatricula(String matriculaBuscada) {
        NodoLDEG nodoActual = primero;
        
        while (nodoActual != null) {
            Autobus a = (Autobus) nodoActual.dato;
            
            if (a.getMatricula().equals(matriculaBuscada) ) {
                return nodoActual; // El valor se encuentra en este nodo
            }
            nodoActual = nodoActual.siguiente;
        }
        
        return null; // El valor no se encuentra en la lista
    }
    
    public boolean eliminar(E x){
        NodoLDEG<E> aux=primero;
        while(aux!=null && !aux.dato.equals(x))aux=aux.siguiente;
        if(aux==null)return false;
        else aux.anterior.siguiente=aux.siguiente;
        if(aux.siguiente!=null)aux.siguiente.anterior = aux.anterior;
        else{
            aux.anterior.siguiente =  null;
            aux.anterior = ultimo;
        }
        return true;
    }
    
    @Override
    public String toString(){
        String res="";
        for(NodoLDEG<E> aux=primero; aux!=null;aux=aux.siguiente){
            res+=aux.dato.toString()+"\n";
        }
        return res;
    }
    
    public void mostrarInfoAscendente(){
        NodoLDEG nodoActual = primero;
        
        while (nodoActual != null) {
            Autobus a = (Autobus) nodoActual.dato;
            
            System.out.println("\t"+a.getMatricula()+"\t\t"+a.getAnioCompra()+"\t\t"+a.getNumPlazas());
            
            nodoActual = nodoActual.siguiente;
        }
    }
    
    public void mostrarInfoDescendente(){
        NodoLDEG nodoActual = ultimo;
        
        while (nodoActual != null) {
            Autobus a = (Autobus) nodoActual.dato;
            
            System.out.println("\t"+a.getMatricula()+"\t\t"+a.getAnioCompra()+"\t\t"+a.getNumPlazas());
            
            nodoActual = nodoActual.anterior;
        }
    }
    
    private NodoLDEG buscarPorCapacidad(int capacidadBuscada){
        NodoLDEG nodoActual = primero;
        
        while (nodoActual != null) {
            Autobus a = (Autobus) nodoActual.dato;
            
            if (a.getNumPlazas()==capacidadBuscada) {
                return nodoActual; // El valor se encuentra en este nodo
            }
            nodoActual = nodoActual.siguiente;
        }
        return null; // El valor no se encuentra en la lista
    }
    
    public void mostrarInfoApartirDeValor(int capacidadMin){
        NodoLDEG nodoEncontrado = buscarPorCapacidad(capacidadMin);
        
        while(nodoEncontrado != null){
            Autobus a = (Autobus) nodoEncontrado.dato;
            
            System.out.println("\t"+a.getMatricula()+"\t\t"+a.getAnioCompra()+"\t\t"+a.getNumPlazas());
            
            nodoEncontrado = nodoEncontrado.siguiente;
        }
    }
    
    
    public int contarElementos() {
        int contador = 0;
        NodoLDEG<E> actual = this.primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

}