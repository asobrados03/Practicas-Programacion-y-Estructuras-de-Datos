/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package librerias.estructurasDeDatos.modelos;

import librerias.excepciones.*;

/**
 * Esta interfaz contiene los metodos del árbol binario de busqueda
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <E>
 */
public interface Modelo_ABB<E> {
    public E recuperar(E x) throws ElementoNoEncontrado;
    public E recuperarMin();
    public E recuperarMax();
    public void insertarSinDuplicados(E x) throws ElementoDuplicado;
    public void insertarConDuplicados(E x);
    public void eliminar(E x) throws ElementoNoEncontrado;
    public E eliminarMin();
    public int tamanyo();
    public int altura();
    public boolean esVacio();
    public String toStringPreOrden();
    public String toStringPostOrden();
    public String toStringInOrden();
    public String toStringPorNiveles();
}