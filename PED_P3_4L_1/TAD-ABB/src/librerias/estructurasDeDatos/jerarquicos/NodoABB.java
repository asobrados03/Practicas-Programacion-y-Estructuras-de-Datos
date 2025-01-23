/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.jerarquicos;

/**
 * Esta clase contiene los metodos y atributos del NodoABB
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <E>
 */
public class NodoABB<E> {
    protected E dato;
    protected NodoABB<E> izq, der;
    protected int tamanyo;
    /**
     * Método constructor parametrizado
     * @param dato el dato que se va a almacenar en el nodo
     * @param izquierdo el hijo izquierdo del nodo
     * @param derecho el hijo derecho del nodo
     */
    public NodoABB(E dato, NodoABB<E> izquierdo, NodoABB<E> derecho){
        this.dato = dato; izq = izquierdo; der = derecho;
        this.tamanyo = 1;
        if(izq!=null)tamanyo+=izq.tamanyo;if(der!=null) tamanyo+=der.tamanyo;
    }
    /**
     * Método constructor parametrizado
     * @param dato el dato que se va a almacenar en el nodo
     */
    public NodoABB(E dato){
        this(dato, null, null);
    }
}
