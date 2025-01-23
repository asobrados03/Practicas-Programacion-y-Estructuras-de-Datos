/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package librerias.estructurasDeDatos.modelos;

/**
 * Esta interfaz contiene los metodos de la cola
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <E>
 */
public interface Cola<E> {
    public void encolar(E x);
    public E desencolar();
    public E primero();
    public boolean esVacia();
}