/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.excepciones;

/**
 * Esta clase contiene la excepción de usuario ElementoNoEncontrado
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class ElementoNoEncontrado extends Exception{
    /**
     * Método constructor parametrizado
     * @param dme mensaje que aparece en la excepción de usuario
     */
    public ElementoNoEncontrado(String dme){
        super(dme);
    }   
}
