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
public class LEG <E> {
    protected NodoLEG<E> primero;
    
    public LEG(){
       primero=null; 
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
    
}
