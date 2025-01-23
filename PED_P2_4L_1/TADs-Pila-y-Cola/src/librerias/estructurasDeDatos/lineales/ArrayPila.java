/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class ArrayPila<E> implements Pila<E>{
    protected E elArray[];
    protected int tope;
    protected static final int CAPACIDAD_POR_DEFECTO = 200;
    
    public ArrayPila(){
        elArray= (E[]) new Object[CAPACIDAD_POR_DEFECTO];
        tope=-1;
    }
    
    @Override
    public void apilar(E x) {
        if(tope +1 == elArray.length) duplicarArray();
        tope++; elArray[tope]=x;
    }

    @Override
    public E desapilar() {
        E elUltimo = elArray[tope];
        tope--;
        return elUltimo;
    }

    @Override
    public E tope() {
        return elArray[tope];
    }

    @Override
    public boolean esVacia() {
        return ( tope==-1 );
    }
    
    @Override
    public String toString(){
        String res="";
        for(int i=tope;i>0;i--) res+=elArray[i]+"\n";
        return res;
    }

    private void duplicarArray() {
        E nuevoArray[]=(E[]) new Object[elArray.length*2];
        for(int i=0;i<=tope;i++) nuevoArray[i]=elArray[i];
        elArray = nuevoArray;
    }
    
}
