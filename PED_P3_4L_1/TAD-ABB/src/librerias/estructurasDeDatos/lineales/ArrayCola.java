/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

/**
 * Esta clase contiene los metodos y atributos del ArrayCola
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <E>
 */
public class ArrayCola<E> implements Cola<E>{
    protected E elArray[];
    protected int fin, primero, tallaActual;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;
    /**
     * Método constructor sin parametros
     */
    public ArrayCola(){
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];
        tallaActual=0;
        primero=0;
        fin = -1;
    }
    /**
     * Método que encola elementos en la cola
     * @param x elemento a encolar en la cola
     */
    @Override
    public void encolar(E x) {
        if( tallaActual==elArray.length) duplicarArray();
        fin=incrementa(fin);
        elArray[fin]=x;
        tallaActual++;
    }
    /**
     * Método que desencola elementos en la cola
     * @return elemento desencolado de la cola
     */
    @Override
    public E desencolar() {
        E elPrimero = elArray[primero];
        primero = incrementa(primero);
        tallaActual--;
        return elPrimero;
    }
    /**
     * Metodo que devuelve el primero de la cola
     * @return el elemento primero de la cola
     */
    @Override
    public E primero() {
        return elArray[primero];
    }
    /**
     * Método que comprueba si la cola esta vacía
     * @return si la cola esta vacía true y si esta llena false
     */
    @Override
    public boolean esVacia() {
        return(tallaActual==0);
    }
    /**
     * Método que incrementa el valor del índice y lo devuelve. Si el índice incrementado alcanza el tamaño del arreglo, se reinicia a cero.
     * @param indice el índice actual a incrementar
     * @return el nuevo valor del índice después de incrementarlo
     */
    private int incrementa(int indice) {
        if(++indice==elArray.length)indice=0;
        return indice;
    }
    /**
     * Método que devuelve una representación en forma de cadena de caracteres del array circular
     * @return una cadena de caracteres que representa el array circular
     */
    @Override
    public String toString(){
        String res="";
        int aux=primero;
        for(int i =0;i<tallaActual;i++, aux=incrementa(aux))
            res += elArray[aux]+"";
        return res;
    }
    /**
     * Método que Duplica el tamaño del array interno utilizado por el array circular.
     * Se crea un nuevo array con el doble de capacidad y se copian los elementos existentes en él.
     * El array original se reemplaza por el nuevo array duplicado.
     * El primer y último índice se actualizan acorde a la nueva talla.
     */
    private void duplicarArray() {
        E nuevo[]=(E[]) new Object[elArray.length*2];
        for(int i =0;i<tallaActual;i++, primero=incrementa(primero))
            nuevo[i]=elArray[primero];
        elArray=nuevo;
        primero=0;
        fin=tallaActual - 1;
    }
    /**
     * Método que devuelve la cantidad actual de elementos almacenados en el array circular.
     * @return la talla actual del array circular
     */
    public int tallaActual() {
        return tallaActual;
    } 
}
