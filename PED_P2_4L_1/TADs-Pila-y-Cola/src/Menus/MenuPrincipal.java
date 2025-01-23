/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import java.util.ArrayList;
import EntradaSalida.MyInput;

/**
 *
 * @author Usuario
 */
public class MenuPrincipal extends Menus{
    private ArrayList<Menus> menus = new ArrayList<Menus>();
            
    public MenuPrincipal(){
        super();
        menus.add(new SubMenuPilaEnteros());
        menus.add(new SubMenuColaEnteros());
        menus.add(new comprobarFrasePalindroma());
    }
    
    @Override
    public void ejecutar(){
        String respuesta="";
        
        do{
            respuesta = ejecutarOpciones();
        }while(respuesta.equals("s"));
    }
    
    @Override
    public String ejecutarOpciones(){
        System.out.println("");
            System.out.println("Menú Principal");
            System.out.println("seleccione una opción:");
            System.out.println("0. Salir");
            System.out.println("1. Submenú Pila de Enteros");
            System.out.println("2. Submenú Cola de Enteros");
            System.out.println("3. Comprobar frase palíndroma");
            
        String s=MyInput.readString();
        
        int i=0;
        try{  
               i= Integer.parseInt(s);
        }catch(NumberFormatException ex){
                  System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                  return "s";
               } 
        if((i>0)&&(i<=menus.size())){
                menus.get(i-1).ejecutar();
                return "s";}
        else if ((i<0)||(i>menus.size())){
                System.out.println("opción no válida. Inténtelo de nuevo");
                return "s";}
        else                  
                System.out.println("Gracias por utilizar nuestros TADs Pila y Cola");
                return "n";      
    }
}
