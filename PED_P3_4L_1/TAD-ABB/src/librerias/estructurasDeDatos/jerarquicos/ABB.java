/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.jerarquicos;

import java.lang.reflect.Array;
import librerias.estructurasDeDatos.lineales.ArrayCola;
import librerias.estructurasDeDatos.modelos.*;
import librerias.excepciones.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Esta clase contiene los metodos y atributos del árbol binario de busqueda
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <E> tipo génerico que hereda de la interfaz Comparable
 */
public class ABB<E extends Comparable<E>> implements Modelo_ABB<E>{
    protected NodoABB<E> raiz;
    /**
     * Método constructor 
     */
    public ABB(){
        raiz=null;
    }
    /**
     * Método constructor parametrizado
     * @param x la raíz del arbol binario de busqueda de enteros
     */
    public ABB(E x){
        raiz = new NodoABB<E>(x);
    }
    /**
     * Método lanzadera que recupera un elemento del ABB
     * @param x elemento a recuperar del ABB
     * @return devuelve el elemento recuperado del ABB (si lo recupera)
     * @throws ElementoNoEncontrado si se intenta recuperar un elemento que no esta en el árbol binario de busqueda
     */
    @Override
    public E recuperar(E x) throws ElementoNoEncontrado {
        NodoABB<E> res = recuperar(x, this.raiz);
        if(res == null)
            throw new ElementoNoEncontrado("El dato "+x+" no está");
        return res.dato;
    }
    /**
     * Método privado recursivo que recupera un elemento del ABB
     * @param x elemento a recuperar del ABB
     * @param n raíz del ABB
     * @return devuelve el NodoABB que contiene el elemento a recuperar
     */
    private NodoABB<E> recuperar(E x, NodoABB<E> n){
        NodoABB<E> res = n;
        if(n != null){
            int resC = n.dato.compareTo(x);
            if( resC < 0) res = recuperar(x, n.der);
            else if(resC > 0) res = recuperar(x, n.izq);
        }
        return res;
    }
    /**
     * Método que recupera el valor mínimo almacenado en el árbol binario de busqueda
     * @return el valor mínimo del árbol binario de busqueda 
     */
    @Override
    public E recuperarMin() {
        return recuperarMin(this.raiz).dato; 
    }
    /**
     * Método que recupera el nodo que contiene el valor mínimo a partir del nodo actual.
     * @param actual el nodo actual desde donde comenzar la búsqueda
     * @return el nodo que contiene el valor mínimo
     */
    private NodoABB<E> recuperarMin(NodoABB<E> actual){
        if(actual.izq == null)
            return actual;
        else
            return(recuperarMin(actual.izq));
    }
    /**
     * Método que recupera el valor máximo almacenado en el árbol binario de busqueda.
     * @return el valor máximo del árbol binario de busqueda
     */
    @Override
    public E recuperarMax(){
        return recuperarMax(this.raiz).dato;
    }
    /**
     * Método que recupera el nodo que contiene el valor máximo a partir del nodo actual.
     * @param actual el nodo actual desde donde comenzar la búsqueda
     * @return el nodo que contiene el valor máximo
     */
    public NodoABB<E> recuperarMax(NodoABB<E> actual){
        return(actual.der == null)?actual:recuperarMax(actual.der);
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda sin permitir duplicados.
     * @param x el elemento a insertar
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    @Override
    public void insertarSinDuplicados(E x) throws ElementoDuplicado {
        if (x != null) { // Ignorar elementos nulos
            this.raiz = insertarSinDuplicados(x, raiz);
        }
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda sin permitir duplicados, comenzando desde el nodo actual.
     * @param x el elemento a insertar
     * @param actual el nodo actual desde donde comenzar la inserción
     * @return el nodo actualizado después de la inserción
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    private NodoABB<E> insertarSinDuplicados(E x, NodoABB<E> actual) throws ElementoDuplicado {
        NodoABB<E> res = actual;
        if(actual == null){
            res = new NodoABB<E>(x);
        }else{
            if(actual.dato != null){
                int resC = actual.dato.compareTo(x);
                if(resC == 0) throw new ElementoDuplicado(x+" está duplicado");
                if(resC < 0) res.der = insertarSinDuplicados(x, actual.der);
                else res.izq = insertarSinDuplicados(x, actual.izq);
                actual.tamanyo++;
            }
        }
        return res;
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda permitiendo duplicados.
     * @param x el elemento a insertar
     */
    @Override
    public void insertarConDuplicados(E x) {
        this.raiz = insertarConDuplicados(x, raiz);
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda permitiendo duplicados, comenzando desde el nodo actual.
     * @param x el elemento a insertar
     * @param actual el nodo actual desde donde comenzar la inserción
     * @return el nodo actualizado después de la inserción
     */
    private NodoABB<E> insertarConDuplicados(E x, NodoABB<E> actual){
        NodoABB<E> res = actual;
        if(actual == null){
            res = new NodoABB<E>(x);
        }else{
            int resC = actual.dato.compareTo(x);
            
            actual.tamanyo++;
            if(resC < 0) res.der=insertarConDuplicados(x, actual.der);
            else res.izq = insertarConDuplicados(x, actual.izq);
        }
        return res;
    }
    /**
     * Método que inserta un array de elementos en el árbol binario de busqueda de forma equilibrada.
     * @param v el array de elementos a insertar
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    public void insertarEquilibrado(E v[]) throws ElementoDuplicado{
        E[] resultado = Arrays.stream(v)
            .filter(Objects::nonNull)
            .toArray(size -> (E[]) Array.newInstance(v.getClass().getComponentType(), size));
        
        Arrays.sort(resultado);
        insertarEquilibrado(resultado, 0, resultado.length - 1);
    }
    /**
     * Método que inserta un array de elementos en el árbol binario de busqueda de forma equilibrada, dentro del rango especificado.
     * @param v el array de elementos a insertar
     * @param izq el índice izquierdo del rango
     * @param der el índice derecho del rango
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    private void insertarEquilibrado(E v[], int izq, int der) throws ElementoDuplicado{
        if(izq <= der){
            int med = (izq + der) / 2;
            raiz = insertarSinDuplicados(v[med], raiz);
            insertarEquilibrado(v, izq, med - 1);
            insertarEquilibrado(v, med + 1, der);
        }
    }
    /**
     * Método que elimina un elemento del árbol binario de busqueda.
     * @param x el elemento a eliminar
     * @throws ElementoNoEncontrado si el elemento no se encuentra en el árbol binario de busqueda de enteros 
     */
    @Override
    public void eliminar(E x) throws ElementoNoEncontrado {
        this.raiz = eliminar(x, this.raiz);
    }
    /**
     * Método que elimina un elemento del árbol binario de busqueda  comenzando desde el nodo actual.
     * @param x el elemento a eliminar
     * @param actual el nodo actual desde donde comenzar la eliminación
     * @return el nodo actualizado después de la eliminación
     * @throws ElementoNoEncontrado si el elemento no se encuentra en el árbol binario de busqueda de enteros
     */
    private NodoABB<E> eliminar(E x, NodoABB<E> actual) throws ElementoNoEncontrado {
        NodoABB<E> res = actual;
        if(actual == null) throw new ElementoNoEncontrado("El dato "+x+" no está");
        int resC = actual.dato.compareTo(x);
        if(resC < 0) res.der = eliminar(x, actual.der);
        else if (resC > 0) res.izq = eliminar(x, actual.izq);
        else{
            if(actual.izq != null && actual.der != null){
                res.dato = recuperarMin(actual.der).dato;
                res.der = eliminarMin(actual.der);
            }
            else res = (actual.izq != null)?actual.izq:actual.der;
        }
        actual.tamanyo--;
        return res;
    }
    /**
     * Método que elimina el elemento mínimo del árbol binario de busqueda y lo devuelve.
     * @return el elemento mínimo del árbol binario de busqueda de enteros
     */
    @Override
    public E eliminarMin() {
        E min = recuperarMin();
        this.raiz = eliminarMin(this.raiz);
        return min;
    }
    /**
     * Método que elimina el elemento mínimo del árbol binario de busqueda comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar la eliminación
     * @return el nodo actualizado después de la eliminación
     */
    private NodoABB<E> eliminarMin(NodoABB<E> actual){
        if(actual.izq != null){
            actual.tamanyo--; actual.izq = eliminarMin(actual.izq);
        }else{
            actual = actual.der;
        }
        return actual;
    }
     /**
     * Método que devuelve el tamaño (cantidad de elementos) del árbol binario de busqueda.
     * @return el tamaño del árbol binario de busqueda
     */
    @Override
    public int tamanyo() {
        return tamanyo(this.raiz); 
    }
    /**
     * Método que calcula el tamaño (cantidad de elementos) del árbol binario de busqueda comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el cálculo
     * @return el tamaño del árbol binario de busqueda
     */
    private int tamanyo(NodoABB<E> actual){
        return(actual!=null)?actual.tamanyo:0;
    }
    /**
     * Método que devuelve la altura del árbol binario de busqueda.
     * @return la altura del árbol binario de busqueda
     */
    @Override
    public int altura() {
        return altura(this.raiz);
    }
    /**
     * Método que calcula la altura del árbol binario de busqueda comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el cálculo
     * @return la altura del árbol binario de busqueda
     */
    private int altura(NodoABB<E> actual){
        if(actual == null)
            return -1;
        else
            return (1 + Math.max(altura(actual.izq), altura(actual.der)));
    }
    /**
     * Método que verifica si el árbol binario de busqueda está vacío.
     * @return true si el árbol binario de busqueda está vacío, false en caso contrario
     */
    @Override
    public boolean esVacio() {
        return raiz == null; 
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido PreOrden.
     * @return representación del árbol binario de busqueda en recorrido PreOrden
     */
    @Override
    public String toStringPreOrden() {
        if(this.raiz != null) return toStringPreOrden(this.raiz); else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido PreOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido PreOrden
     * @return representación del árbol binario de busqueda en recorrido PreOrden
     */
    private String toStringPreOrden(NodoABB<E> actual){
        String res="";
        if(actual != null){
            if(actual.dato != null){
                res += actual.dato.toString()+"\n";
            }
            if(actual.izq != null) res += toStringPreOrden(actual.izq);
            if(actual.der != null) res += toStringPreOrden(actual.der);
        }
        
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido PostOrden.
     * @return representación del árbol binario de busqueda en recorrido PostOrden
     */
    @Override
    public String toStringPostOrden() {
        if(this.raiz != null) return toStringPostOrden(this.raiz);
        else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido PostOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido PostOrden
     * @return representación del árbol binario de busqueda en recorrido PostOrden
     */
    private String toStringPostOrden(NodoABB<E> actual){
        String res = "";
        if(actual.izq != null) res += toStringPostOrden(actual.izq);
        if(actual.der != null) res += toStringPostOrden(actual.der);
        res += actual.dato.toString()+"\n";
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido InOrden.
     * @return representación del árbol en recorrido InOrden
     */
    @Override
    public String toStringInOrden() {
        if(this.raiz != null) return toStringInOrden(this.raiz); else return "*"; 
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido InOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido InOrden
     * @return representación del árbol binario de busqueda en recorrido InOrden
     */
    private String toStringInOrden(NodoABB<E> actual){
        String res = "";
        if(actual.izq != null) res+= toStringInOrden(actual.izq);
        res+= actual.dato.toString()+"\n";
        if(actual.der != null) res += toStringInOrden(actual.der);
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido por niveles.
     * @return representación del árbol binario de busqueda en recorrido por niveles
     */
    @Override
    public String toStringPorNiveles() {
        if(this.raiz != null) return toStringPorNiveles(this.raiz);
        else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda en recorrido por niveles, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido por niveles
     * @return representación del árbol binario de busqueda en recorrido por niveles
     */
    private String toStringPorNiveles(NodoABB<E> actual){
        Cola<NodoABB<E>> q = new ArrayCola<NodoABB<E>>();
        q.encolar(actual); String res = "";
        while(!q.esVacia()){
            NodoABB<E> nodoActual = q.desencolar();
            res += nodoActual.dato.toString()+"\n";
            if(nodoActual.izq != null) q.encolar(nodoActual.izq);
            if(nodoActual.der != null) q.encolar(nodoActual.der);
        }
        return res;
    }
}