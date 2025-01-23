/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import java.util.NoSuchElementException;
import librerias.estructurasDeDatos.modelos.Pila;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class LEPila<E> implements Pila<E>{
    private NodoLEG<E> cima; // puntero al nodo que está en la cima de la pila
    private int tamaño; // tamaño de la pila
    
    public LEPila() {
        cima = null; // la pila está vacía al inicio
        tamaño = 0;
    }

    @Override
    public void apilar(E x) {
        NodoLEG<E> nuevo = new NodoLEG<E>(x); // creamos un nuevo nodo con el dato a apilar
        nuevo.setSiguiente(cima); // el siguiente del nuevo nodo es el nodo que estaba en la cima
        cima = nuevo; // actualizamos la cima de la pila
        tamaño++; // aumentamos el tamaño de la pila
    }

    @Override
    public E desapilar() {
       if (esVacia()) {
            throw new NoSuchElementException("La pila está vacía"); // lanzamos una excepción si la pila está vacía
        }
        E dato = cima.getDato(); // obtenemos el dato del nodo que está en la cima
        cima = cima.getSiguiente(); // actualizamos la cima de la pila
        tamaño--; // disminuimos el tamaño de la pila
        return dato; 
    }

    @Override
    public E tope() {
        if (esVacia()) {
            throw new NoSuchElementException("La pila está vacía"); // lanzamos una excepción si la pila está vacía
        }
        return cima.getDato(); // obtenemos el dato del nodo que está en la cima
    }
    
    public NodoLEG getCima(){
        return this.cima;
    }

    @Override
    public boolean esVacia() {
        return cima == null; // la pila está vacía si la cima es null
    }
    
    public int tamaño() {
        return tamaño;
    }
}
