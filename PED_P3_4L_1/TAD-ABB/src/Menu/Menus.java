/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 * Esta clase contiene los metodos y atributos de los menus
 * @author Raúl Colindres y Alfredo Sobrados
 */
public abstract class Menus {
    /**
     * Método que ejecuta el menú principal del programa.
     * Realiza un bucle donde se ejecutan las opciones seleccionadas por el usuario hasta que la respuesta sea diferente de "s".
     */
    public void ejecutar(){
        String respuesta="";
        
        do{
            respuesta = ejecutarOpciones();
        }while(respuesta.equals("s"));
    }
    /**
     * Ejecuta las opciones disponibles y devuelve un resultado en forma de cadena.
     * La implementación de este método depende de las funcionalidades específicas
     * de la clase MenuPrincipal que es la que lo implementa.
     * @return el resultado de la ejecución de las opciones en forma de cadena
     */
    public abstract String ejecutarOpciones();
}