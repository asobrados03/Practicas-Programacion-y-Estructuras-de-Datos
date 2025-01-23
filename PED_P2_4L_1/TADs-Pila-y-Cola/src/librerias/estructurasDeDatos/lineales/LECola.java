/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import java.util.NoSuchElementException;
import librerias.estructurasDeDatos.modelos.Cola;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class LECola<E> implements Cola<E>{
    private NodoLEG<E> primero, ultimo; // puntero al nodo que está el primero y el último de la cola
    private int tamaño; //tamaño de la cola
    
    public LECola(){
        primero = null; // la cola está vacía al inicio
        ultimo = null;
        tamaño = 0;
    }
    
    @Override
    public void encolar(E x) {
        NodoLEG<E> nuevo = new NodoLEG<E>(x);
        if(esVacia()){
            nuevo = primero;
            nuevo = ultimo;
        }
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
        tamaño++;
    }

    @Override
    public E desencolar() {
        if(esVacia()){
            throw new NoSuchElementException("La cola está vacía"); // lanzamos una excepción si la cola está vacía
        }
        E dato = primero.getDato(); //obtengo el dato que quiero desencolar
        primero = primero.getSiguiente(); //asigno la referencia del primero al siguiente en la cola
        tamaño--; //disminuyo el tamaño de la cola
        return dato; //devuelvo el dato que he desencolado
    }

    @Override
    public E primero() {
        if (esVacia()) {
            throw new NoSuchElementException("La cola está vacía"); // lanzamos una excepción si la cola está vacía
        }
        return primero.getDato(); // obtenemos el dato del nodo que está el primero o en el frente de la cola
    }

    @Override
    public boolean esVacia() {
        return primero == null; // la cola está vacía si el primero es null
    }
    
    public int tamaño(){
        return tamaño;
    }
    
}
