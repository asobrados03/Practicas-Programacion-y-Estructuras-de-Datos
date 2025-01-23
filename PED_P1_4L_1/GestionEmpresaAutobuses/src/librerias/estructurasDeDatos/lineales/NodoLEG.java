/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

/**
 * Esta clase contiene los metodos y atributos de NodoLEG
 * @author Raúl Colindres y Alfredo Sobrados
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
    
    public Object getDato() {
        return this.dato;
    }

    public NodoLEG<E> getSiguiente() {
        return siguiente;
    }

}
