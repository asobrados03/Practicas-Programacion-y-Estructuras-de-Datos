/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.estructurasDeDatos.lineales;

import gestion_empresa_autobuses.Viaje;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class NodoLDEG<E> extends LDEGOrdenada{
    protected E dato;
    protected NodoLDEG<E> siguiente, anterior;
    protected LEG<E> listaSecundaria;
    
    public NodoLDEG(E dato){
        this.dato = dato;
    }

    public NodoLDEG<E> getSiguiente() {
        return siguiente;
    }

    public E getDato(){
        return this.dato;
    }
    
    public LEG getListaSecundaria(){
        return this.listaSecundaria;
    }
    
    public void setListaSecundaria(LEG listaSecundaria){
        this.listaSecundaria = listaSecundaria;
    }
    
    public boolean existeNodoSecundarioIgual(Viaje nuevoViaje) {
        boolean encontrado = false;
        NodoLEG actual = listaSecundaria.primero;
        
        while (actual != null && !encontrado) {
            Viaje v = (Viaje) actual.dato;
            if (v.getDestino().equals(nuevoViaje.getDestino()) && v.getOrigen().equals(nuevoViaje.getOrigen()) && v.getHora().equals(nuevoViaje.getHora())){
                encontrado = true;
            } else {
                actual = actual.siguiente;
            }
        }
        return encontrado;
    }

}
