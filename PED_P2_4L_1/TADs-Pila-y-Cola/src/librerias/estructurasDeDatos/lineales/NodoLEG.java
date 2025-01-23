/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class NodoLEG<E> extends LEG{
    protected E dato;
    protected NodoLEG<E> siguiente;
    /**
     * Método constructor parametrizado
     * @param dato 
     */
    public NodoLEG(E dato){
        this(dato, null);
    }
    /**
     * Método constructor parametrizado
     * @param dato
     * @param siguiente 
     */
    public NodoLEG(E dato, NodoLEG<E> siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    public E getDato() {
        return dato;
    }

    public NodoLEG<E> getSiguiente() {
        return siguiente;
    }

     public void setSiguiente(NodoLEG<E> siguiente) {
        this.siguiente = siguiente;
    }
}
