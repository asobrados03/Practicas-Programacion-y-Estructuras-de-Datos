/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import EntradaSalida.MyInput;
import librerias.estructurasDeDatos.lineales.ArrayCola;
import librerias.estructurasDeDatos.lineales.LEPila;

/**
 *
 * @author Usuario
 */
public class comprobarFrasePalindroma extends Menus {


    @Override
    public String ejecutarOpciones() {
        System.out.println("Opción 3: Comprobar Frase Palíndroma");
        System.out.println("seleccione una opción:");
        System.out.println("0. Salir de la opción 3 del Menú Principal");
        System.out.println("1. Comprobar Frase Palíndroma");
        
        String s= MyInput.readString();
        
        switch(s){
            case "0": {return "n";}
            case "1": {
                boolean cmp = comprobarFrasePalindroma();
                if(cmp){
                    System.out.println("La frase es palíndroma.");
                }
                else{
                    System.out.println("La frase no es palíndroma.");
                }
                
                return "s";
            }
            default: {System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
        }
    }
    
    public static boolean comprobarFrasePalindroma(){
        System.out.println("Introduzca la frase:");
        String frase = MyInput.readString();
        frase = frase.replaceAll("[^a-zA-Z0-9]", "");
        char[] ch = frase.toCharArray();
        
        LEPila<Character> p = new LEPila<Character>();
        ArrayCola<Character> c = new ArrayCola<Character>();

        for(int i = 0; i<frase.length(); i++){
            p.apilar(ch[i]);
            c.encolar(ch[i]);
        }

        while(!p.esVacia() && !c.esVacia()){
            char pilaTop = p.desapilar();
            char colaFront = c.desencolar();

            if(Character.toLowerCase(pilaTop) != Character.toLowerCase(colaFront)){ 
                return false;
            }
        }

        return true;
    }
}
