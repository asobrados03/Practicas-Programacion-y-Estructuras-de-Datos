/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.excepciones;

/**
 * Esta clase contiene la excepción de usuario ABBVacio
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class ABBVacio extends Exception{
    /**
     * Método constructor parametrizado
     * @param dme mensaje que aparece en la excepción de usuario
     */
    public ABBVacio(String dme){
        super(dme);
    }
}
