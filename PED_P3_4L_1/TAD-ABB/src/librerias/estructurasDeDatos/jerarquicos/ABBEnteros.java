/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.jerarquicos;

import EntradaSalida.MyInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import librerias.estructurasDeDatos.lineales.ArrayCola;
import librerias.estructurasDeDatos.modelos.*;
import librerias.excepciones.*;

/**
 * Esta clase contiene los metodos y atributos del árbol binario de busqueda de enteros
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class ABBEnteros implements Modelo_ABBEnteros<Integer>{
    protected NodoABB raiz;
    /**
     * Método constructor 
     */
    public ABBEnteros(){
        raiz=null;
    }
    /**
     * Método constructor parametrizado
     * @param x la raíz del arbol binario de busqueda de enteros
     */
    public ABBEnteros(Integer x){
        raiz = new NodoABB(x);
    }
    /**
     * Método lanzadera que recupera un entero del ABB
     * @param x entero a recuperar del ABB
     * @return devuelve el entero recuperado del ABB (si lo recupera)
     * @throws ElementoNoEncontrado si se intenta recuperar un elemento que no esta en el árbol binario de busqueda de enteros
     */
    @Override
    public Integer recuperar(Integer x) throws ElementoNoEncontrado {
        NodoABB res = recuperar(x, this.raiz);
        if(res == null)
            throw new ElementoNoEncontrado("El dato "+x+" no está");
        return (Integer) res.dato;
    }
    /**
     * Método privado recursivo que recupera un entero del ABB
     * @param x entero a recuperar del ABB
     * @param n raíz del ABB
     * @return devuelve el NodoABB que contiene el entero a recuperar
     */
    private NodoABB recuperar(Integer x, NodoABB<Integer> n){
        NodoABB res = n;
        if(n != null){
            int resC = n.dato.compareTo(x);
            if( resC < 0) res = recuperar(x, n.der);
            else if(resC > 0) res = recuperar(x, n.izq);
        }
        return res;
    }
    /**
     * Método que recupera el valor mínimo almacenado en el árbol binario de busqueda de enteros
     * @return el valor mínimo del árbol binario de busqueda de enteros
     */
    @Override
    public Integer recuperarMin() {
        return (Integer) recuperarMin(this.raiz).dato; 
    }
    /**
     * Método que recupera el nodo que contiene el valor mínimo a partir del nodo actual.
     * @param actual el nodo actual desde donde comenzar la búsqueda
     * @return el nodo que contiene el valor mínimo
     */
    private NodoABB<Integer> recuperarMin(NodoABB<Integer> actual){
        if(actual.izq == null)
            return actual;
        else
            return(recuperarMin(actual.izq));
    }
    /**
     * Método que recupera el valor máximo almacenado en el árbol binario de busqueda de enteros.
     * @return el valor máximo del árbol binario de busqueda de enteros
     */
    @Override
    public Integer recuperarMax(){
        return (Integer) recuperarMax(this.raiz).dato;
    }
    /**
     * Método que recupera el nodo que contiene el valor máximo a partir del nodo actual.
     * @param actual el nodo actual desde donde comenzar la búsqueda
     * @return el nodo que contiene el valor máximo
     */
    public NodoABB recuperarMax(NodoABB<Integer> actual){
        return(actual.der == null)?actual:recuperarMax(actual.der);
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda de enteros sin permitir duplicados.
     * @param x el entero a insertar
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    @Override
    public void insertarSinDuplicados(Integer x) throws ElementoDuplicado {
        if (x != null) { // Ignorar elementos nulos
            this.raiz = insertarSinDuplicados(x, raiz);
        }
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda de enteros sin permitir duplicados, comenzando desde el nodo actual.
     * @param x el entero a insertar
     * @param actual el nodo actual desde donde comenzar la inserción
     * @return el nodo actualizado después de la inserción
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    private NodoABB insertarSinDuplicados(Integer x, NodoABB<Integer> actual) throws ElementoDuplicado {
        NodoABB res = actual;
        if(actual == null){
            res = new NodoABB(x);
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
     * Método que inserta un elemento en el árbol binario de busqueda de enteros permitiendo duplicados.
     * @param x el elemento a insertar
     */
    @Override
    public void insertarConDuplicados(Integer x) {
        this.raiz = insertarConDuplicados(x, raiz);
    }
    /**
     * Método que inserta un elemento en el árbol binario de busqueda de enteros permitiendo duplicados, comenzando desde el nodo actual.
     * @param x el elemento a insertar
     * @param actual el nodo actual desde donde comenzar la inserción
     * @return el nodo actualizado después de la inserción
     */
    private NodoABB insertarConDuplicados(Integer x, NodoABB actual){
        NodoABB res = actual;
        if(actual == null){
            res = new NodoABB(x);
        }else{
            int resC = (int) actual.dato -  x;

        actual.tamanyo++;
        if (resC < 0) {
            res.der = insertarConDuplicados(x, actual.der);
        } else {
            res.izq = insertarConDuplicados(x, actual.izq);
        }
        }
        return res;
    }
    /**
     * Método que inserta un array de elementos en el árbol binario de busqueda de enteros de forma equilibrada.
     * @param v el array de elementos a insertar
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    public void insertarEquilibrado(Integer v[]) throws ElementoDuplicado{
        ArrayList<Integer> lista = new ArrayList<>();
        
        for (Integer v1 : v) {
            if (v1 != null) {
                lista.add(v1);
            }
        }

        int a[] = new int[lista.size()];
       
        for(int i = 0; i< lista.size(); i++){
            a[i] = lista.get(i);
        }
        
        Arrays.sort(a);
        
        Integer[] r = new Integer[a.length];
        
        for(int i = 0; i < a.length; i++){
            r[i] = a[i];
        }
        
        insertarEquilibrado(r, 0, r.length - 1);
    }
    /**
     * Método que inserta un array de elementos en el árbol binario de busqueda de enteros de forma equilibrada, dentro del rango especificado.
     * @param v el array de elementos a insertar
     * @param izq el índice izquierdo del rango
     * @param der el índice derecho del rango
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    private void insertarEquilibrado(Integer v[], int izq, int der) throws ElementoDuplicado{
        if(izq <= der){
            int med = (izq + der) / 2;
            raiz = insertarSinDuplicados(v[med], raiz);
            insertarEquilibrado(v, izq, med - 1);
            insertarEquilibrado(v, med + 1, der);
        }
    }
    /**
     * Método que elimina un elemento del árbol binario de busqueda de enteros.
     * @param x el elemento a eliminar
     * @throws ElementoNoEncontrado si el elemento no se encuentra en el árbol binario de busqueda de enteros 
     */
    @Override
    public void eliminar(Integer x) throws ElementoNoEncontrado {
        this.raiz = eliminar(x, this.raiz);
    }
    /**
     * Método que elimina un elemento del árbol binario de busqueda de enteros comenzando desde el nodo actual.
     * @param x el elemento a eliminar
     * @param actual el nodo actual desde donde comenzar la eliminación
     * @return el nodo actualizado después de la eliminación
     * @throws ElementoNoEncontrado si el elemento no se encuentra en el árbol binario de busqueda de enteros
     */
    public NodoABB eliminar(Integer x, NodoABB<Integer> actual) throws ElementoNoEncontrado {
        NodoABB res = actual;
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
     * Método que elimina el elemento mínimo del árbol binario de busqueda de enteros y lo devuelve.
     * @return el elemento mínimo del árbol binario de busqueda de enteros
     */
    @Override
    public Integer eliminarMin() {
        Integer min = recuperarMin();
        this.raiz = eliminarMin(this.raiz);
        return min;
    }
    /**
     * Método que elimina el elemento mínimo del árbol binario de busqueda de enteros comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar la eliminación
     * @return el nodo actualizado después de la eliminación
     */
    private NodoABB eliminarMin(NodoABB actual){
        if(actual.izq != null){
            actual.tamanyo--; actual.izq = eliminarMin(actual.izq);
        }else{
            actual = actual.der;
        }
        return actual;
    }
    /**
     * Método que devuelve el tamaño (cantidad de elementos) del árbol binario de busqueda de enteros.
     * @return el tamaño del árbol binario de busqueda de enteros
     */
    @Override
    public int tamanyo() {
        return tamanyo(this.raiz); 
    }
    /**
     * Método que calcula el tamaño (cantidad de elementos) del árbol binario de busqueda de enteros comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el cálculo
     * @return el tamaño del árbol binario de busqueda de enteros
     */
    private int tamanyo(NodoABB actual){
        return(actual!=null)?actual.tamanyo:0;
    }
    /**
     * Método que devuelve la altura del árbol binario de busqueda de enteros.
     * @return la altura del árbol binario de busqueda de enteros
     */
    @Override
    public int altura() {
        return altura(this.raiz);
    }
    /**
     * Método que calcula la altura del árbol binario de busqueda de enteros comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el cálculo
     * @return la altura del árbol binario de busqueda de enteros
     */
    private int altura(NodoABB actual){
        if(actual == null)
            return -1;
        else
            return (1 + Math.max(altura(actual.izq), altura(actual.der)));
    }
    /**
     * Método que verifica si el árbol binario de busqueda de enteros está vacío.
     * @return true si el árbol binario de busqueda de enteros está vacío, false en caso contrario
     */
    @Override
    public boolean esVacio() {
        return raiz == null; 
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido PreOrden.
     * @return representación del árbol binario de busqueda de enteros en recorrido PreOrden
     */
    @Override
    public String toStringPreOrden() {
        if(this.raiz != null) return toStringPreOrden(this.raiz); else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido PreOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido PreOrden
     * @return representación del árbol binario de busqueda de enteros en recorrido PreOrden
     */
    private String toStringPreOrden(NodoABB actual){
        String res="";
        if(actual != null){
            res = actual.dato.toString()+"\n";
        }
        if(actual.izq != null) res += toStringPreOrden(actual.izq);
        if(actual.der != null) res += toStringPreOrden(actual.der);
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido PostOrden.
     * @return representación del árbol binario de busqueda de enteros en recorrido PostOrden
     */
    @Override
    public String toStringPostOrden() {
        if(this.raiz != null) return toStringPostOrden(this.raiz);
        else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido PostOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido PostOrden
     * @return representación del árbol binario de busqueda de enteros en recorrido PostOrden
     */
    private String toStringPostOrden(NodoABB actual){
        String res = "";
        if(actual.izq != null) res += toStringPostOrden(actual.izq);
        if(actual.der != null) res += toStringPostOrden(actual.der);
        if(actual != null){
           res+= actual.dato.toString()+"\n";
        }
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido InOrden.
     * @return representación del árbol en recorrido InOrden
     */
    @Override
    public String toStringInOrden() {
        if(this.raiz != null) return toStringInOrden(this.raiz); else return "*"; 
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido InOrden, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido InOrden
     * @return representación del árbol binario de busqueda de enteros en recorrido InOrden
     */
    private String toStringInOrden(NodoABB actual){
        String res = "";
        if(actual.izq != null) res+= toStringInOrden(actual.izq);
        if(actual != null){
            res+= actual.dato.toString()+"\n";
        }
        if(actual.der != null) res += toStringInOrden(actual.der);
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido InOrden inverso.
     * @return representación del árbol binario de busqueda de enteros en recorrido InOrden inverso 
     */
    @Override
    public String toStringInOrdenInverso() {
        if(this.raiz != null) return toStringInOrdenInverso(this.raiz); else return "*"; 
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido InOrden inverso, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido InOrden inverso
     * @return representación del árbol binario de busqueda de enteros en recorrido InOrden inverso
     */
    private String toStringInOrdenInverso(NodoABB actual){
        String res="";
        if(actual != null){
            if(actual.der != null) res+= toStringInOrdenInverso(actual.der);
            if(actual.dato != null){
                res+= actual.dato.toString()+"\n";
            }
            if(actual.izq != null) res += toStringInOrdenInverso(actual.izq);
        }
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido por niveles.
     * @return representación del árbol binario de busqueda de enteros en recorrido por niveles
     */
    @Override
    public String toStringPorNiveles() {
         if(this.raiz != null) return toStringPorNiveles(this.raiz);
         else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido por niveles, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido por niveles
     * @return representación del árbol binario de busqueda de enteros en recorrido por niveles
     */
    private String toStringPorNiveles(NodoABB actual){
        ArrayCola<NodoABB> q = new ArrayCola<NodoABB>();
        q.encolar(actual); String res = "";
        while(!q.esVacia()){
            NodoABB nodoActual = q.desencolar();
            res += nodoActual.dato.toString()+"\n";
            if(nodoActual.izq != null) q.encolar(nodoActual.izq);
            if(nodoActual.der != null) q.encolar(nodoActual.der);
        }
        return res;
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido por niveles inverso.
     * @return representación del árbol binario de busqueda de enteros en recorrido por niveles inverso
     */
    @Override
    public String toStringPorNivelesInverso() {
        if(this.raiz != null) return toStringPorNivelesInverso(this.raiz);
        else return "*";
    }
    /**
     * Método que devuelve un String que representa el árbol binario de busqueda de enteros en recorrido por niveles inverso, comenzando desde el nodo actual.
     * @param actual el nodo actual desde donde comenzar el recorrido por niveles inverso
     * @return representación del árbol binario de busqueda de enteros en recorrido por niveles inverso
     */
    private String toStringPorNivelesInverso(NodoABB actual){
        ArrayCola<NodoABB> q = new ArrayCola<NodoABB>();
        q.encolar(actual); String res = "";
        while(!q.esVacia()){
            NodoABB nodoActual = q.desencolar();
            res += nodoActual.dato.toString()+"\n";
            if(nodoActual.der != null) q.encolar(nodoActual.der);
            if(nodoActual.izq != null) q.encolar(nodoActual.izq);
        }
        return res;
    }
    /**
     * Método que transforma todos los elementos del árbol binario de busqueda de enteros a sus correspondientes valores negativos. 
     * Si el árbol binario de busqueda de enteros está vacío, se lanza una excepción ABBVacio.
     */
    @Override
    public void transformarABBEnteros() {
        if(this.raiz != null) transformarABBEnteros(this.raiz);
        else try {
            throw new ABBVacio("El árbol esta vacío.");
        } catch (ABBVacio ex) {
            Logger.getLogger(ABBEnteros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Método que transforma el elemento del nodo actual a su correspondiente valor negativo, 
     * y se realiza la transformación recursivamente en los nodos hijos.
     * @param actual el nodo actual a transformar
     */
    private void transformarABBEnteros(NodoABB actual){
        if(actual != null){
            actual.dato = (int) actual.dato * -1;
        }
        
        if(actual.izq != null) transformarABBEnteros(actual.izq);
        if(actual.der != null) transformarABBEnteros(actual.der);
    }
    /**
     * Método que realiza la suma de las claves menores que un número dado en un árbol binario de búsqueda.
     * Solicita al usuario que introduzca una clave y realiza la suma utilizando un método auxiliar.
     * Imprime el resultado de la suma por pantalla.
     */
    @Override
    public void sumarClavesMinNumDado() {
        System.out.println("Introduzca una clave: "); 
        int clave = MyInput.readInt();
        
        int suma = sumarClavesMinNumDado(raiz, clave);
        System.out.println("La suma de las claves menores que " + clave +" es: " + suma);
    }
    /**
     * Método auxiliar recursivo que realiza la suma de las claves menores que un número dado en un subárbol.
     * @param raiz la raíz del subárbol
     * @param num el número dado
     * @return la suma de las claves menores que el número dado en el subárbol
     */
    private int sumarClavesMinNumDado(NodoABB raiz, int num){
        if(raiz == null){
            return 0;
        }
        else{
            if((int) raiz.dato > num){
                return sumarClavesMinNumDado(raiz.izq, num);
            }
            else{
                return sumarClavesMinNumDado(raiz.izq, num) + sumarClavesMinNumDado(raiz.der, num) + (int) raiz.dato;
            }
        }
    }
    /**
     * Método que calcula el antecesor de un nodo en el árbol binario de busqueda de enteros. Se solicita al usuario que ingrese la clave del nodo.
     */
    @Override
    public void calcularAntecesorNodo() {
        System.out.print("Introduce la clave del nodo: ");
        int clave = MyInput.readInt();

        NodoABB nodo = buscarNodo(raiz, clave);
        if (nodo == null) {
            System.out.println("Esta clave no existe en el árbol.");
        } else {
            NodoABB antecesor = encontrarAntecesor(raiz, nodo);
            if (antecesor == null) {
                System.out.println("El nodo " + clave + " es la raíz del árbol.");
            } else {
                System.out.println("El antecesor del nodo " + clave + " es el " + antecesor.dato);
            }
        }
    }
    /**
     * Método que busca un nodo con una clave dada en el árbol binario de busqueda de enteros a partir del nodo raíz.
     * @param raiz  el nodo raíz del árbol binario de busqueda de enteros
     * @param clave la clave del nodo a buscar
     * @return el nodo con la clave dada, o null si no se encuentra
     */
    private NodoABB buscarNodo(NodoABB raiz, int clave) {
        if (raiz == null || (int) raiz.dato == clave) {
            return raiz;
        }

        if (clave < (int) raiz.dato) {
            return buscarNodo(raiz.izq, clave);
        } else {
            return buscarNodo(raiz.der, clave);
        }
    }
    /**
     * Método que encuentra el antecesor de un nodo en el árbol a partir del nodo raíz. 
     * @param raiz el nodo raíz del árbol binario de busqueda de enteros
     * @param nodo el nodo para el cual se busca el antecesor
     * @return el antecesor del nodo, o null si no se encuentra
     */
    private NodoABB encontrarAntecesor(NodoABB raiz, NodoABB nodo) {
        if (raiz == null || nodo == null) {
            return null;
        }

        if (raiz.izq == nodo || raiz.der == nodo) {
            return raiz;
        }

        if ((int) nodo.dato < (int) raiz.dato) {
            return encontrarAntecesor(raiz.izq, nodo);
        } else {
            return encontrarAntecesor(raiz.der, nodo);
        }
    }
    /**
     * Método que muestra las hojas de un árbol binario de búsqueda en posiciones impares. 
     * Comienza el recorrido desde la raíz del árbol y llama a un método auxiliar para realizar la tarea.
     */
    public void mostrarHojasPosImpares() {
        mostrarHojasPosImpares(raiz, 1);
    }
    /**
     * Método auxiliar recursivo que muestra las hojas de un subárbol en posiciones impares. 
     * @param raiz la raíz del subárbol
     * @param posicion la posición actual del nodo en el árbol
     */
    private void mostrarHojasPosImpares(NodoABB actual, int posicion) {
        if (actual == null) {
            return;
        }

        // Si es una hoja y la posición es impar, muestra la clave
        if (actual.izq == null && actual.der == null && posicion % 2 != 0) {
            System.out.println("Hoja " + (posicion / 2 + 1) + " - Clave " + actual.dato);
        }

        // Recorre los hijos en orden izquierdo y derecho
        mostrarHojasPosImpares(actual.izq, 2 * posicion);
        mostrarHojasPosImpares(actual.der, 2 * posicion + 1);
    }
}
