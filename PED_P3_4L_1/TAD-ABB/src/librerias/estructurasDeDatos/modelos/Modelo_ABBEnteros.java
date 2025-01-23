/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package librerias.estructurasDeDatos.modelos;

import librerias.excepciones.*;

/**
 * Esta interfaz contiene los metodos del árbol binario de busqueda de enteros
 * @author Raúl Colindres y Alfredo Sobrados
 * @param <Integer>
 */
public interface Modelo_ABBEnteros<Integer> extends Modelo_ABB<Integer>{
    @Override
    public Integer recuperar(Integer x) throws ElementoNoEncontrado;
    @Override
    public Integer recuperarMin();
    @Override
    public Integer recuperarMax();
    @Override
    public void insertarSinDuplicados(Integer x) throws ElementoDuplicado;
    @Override
    public void insertarConDuplicados(Integer x);
    @Override
    public void eliminar(Integer x) throws ElementoNoEncontrado;
    @Override
    public Integer eliminarMin();
    @Override
    public int tamanyo();
    @Override
    public int altura();
    @Override
    public boolean esVacio();
    @Override
    public String toStringPreOrden();
    @Override
    public String toStringPostOrden();
    @Override
    public String toStringInOrden();
    public String toStringInOrdenInverso();
    @Override
    public String toStringPorNiveles();
    public String toStringPorNivelesInverso();
    public void transformarABBEnteros();
    public void sumarClavesMinNumDado();
    public void calcularAntecesorNodo();
}
