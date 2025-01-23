/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librerias.excepciones;

/**
 * Esta clase contiene la excepción de usuario ElementoDuplicado
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class ElementoDuplicado extends Exception{
    /**
     * Método constructor parametrizado
     * @param dme mensaje que aparece en la excepción de usuario
     */
    public ElementoDuplicado(String dme){
        super(dme);
    }
}
