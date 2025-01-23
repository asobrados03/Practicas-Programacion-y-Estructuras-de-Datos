/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package librerias.estructurasDeDatos.modelos;

/**
 *
 * @author Usuario
 * @param <E>
 */
public interface Pila<E> {
    public void apilar(E x);
    public E desapilar();
    public E tope();
    public boolean esVacia();
}
