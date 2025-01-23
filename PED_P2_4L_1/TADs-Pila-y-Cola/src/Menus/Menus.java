/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

/**
 *
 * @author Usuario
 */
public abstract class Menus {
    
    
    public void ejecutar(){
        String respuesta="";
        
        do{
            respuesta = ejecutarOpciones();
        }while(respuesta.equals("s"));
    }
    
    public abstract String ejecutarOpciones();
}
