/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import EntradaSalida.MyInput;
import java.util.Scanner;
import librerias.estructurasDeDatos.lineales.ArrayCola;

/**
 *
 * @author Usuario
 */
public class SubMenuColaEnteros extends Menus {
    private ArrayCola<Integer> nuevaCola;
    
    public SubMenuColaEnteros() {
        nuevaCola=new ArrayCola<Integer>();
    }
    
    @Override
    public String ejecutarOpciones() {
       System.out.println("");
        System.out.println("SubMenú Cola de Enteros");
        System.out.println("Seleccione una opción:");
        System.out.println("0. Volver");
        System.out.println("");
        System.out.println("1. Crear Cola de enteros");
        System.out.println("2. Introducir elementos en la Cola");
        System.out.println("3. Duplicar Cola");
        System.out.println("4. Repetir n-ésimo");
        String s=MyInput.readString();
        switch(s){
            case "0": {return "n";}
            case "1": {crearColaEnteros();return "s";}
            case "2": {encolarElemPos();return "s";}
            case "3": {copiarCola();return "s";}
            case "4": {repetirNesimo();return "s";} 
            default: {System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
        } 
    }
    
    public void crearColaEnteros(){
        if(!nuevaCola.esVacia()){
            System.out.println("Cola de enteros existe!!");
            vaciarCola();
            System.out.println("Cola de enteros vaciada con exito.");
        }
        else{
            nuevaCola = new ArrayCola<Integer>();
            System.out.println("Cola vacía creada.");
            System.out.println("Pulse <Intro> para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
    
    private void vaciarCola(){
        while(!nuevaCola.esVacia()){
            nuevaCola.desencolar();
        }
    }
    
    public void encolarElemPos(){
        int num=-1;
        
        System.out.println("Introduzca el entero que quiere almacenar en la Cola (para finalizar pulse 0):");
        while(num!=0){
            num = MyInput.readInt();
            if(num>0){
                nuevaCola.encolar(num);
            }  
        }
        
        ArrayCola<Integer> aux = new ArrayCola<Integer>();

        System.out.println("COLA:");
        while(!nuevaCola.esVacia()) {
            int numero = nuevaCola.desencolar();
            System.out.println(numero);
            aux.encolar(numero);
        }
        while(!aux.esVacia()){
            int numero = aux.desencolar();
            nuevaCola.encolar(numero);
        }
    }
    
    public void copiarCola() {
        ArrayCola<Integer> aux = new ArrayCola<Integer>();
        copiarColaAux(aux);
        System.out.println("Cola Original:");
        
        while(!nuevaCola.esVacia()){
            System.out.println(nuevaCola.desencolar());
        }
        
        System.out.println("Cola Copiada:");
        System.out.println("NUEVA_COLA");
        
        while(!aux.esVacia()){
            System.out.println(aux.desencolar());
        }
    }

    private void copiarColaAux(ArrayCola<Integer> aux) {
        if (nuevaCola.esVacia()) return;
        Integer elemento = nuevaCola.desencolar();
        copiarColaAux(aux);
        aux.encolar(elemento);
        nuevaCola.encolar(elemento);
    }
    
    public void repetirNesimo() {        
        System.out.println("Introduce el valor de n:");
        int n = MyInput.readInt();
        
        if (n > 0 && n <= this.nuevaCola.tallaActual()) {
            int elemNesimo = repetirNesimoAux(n);
            int repeticiones = (int) elemNesimo;
            for (int i = 1; i <= repeticiones; i++) {
                this.nuevaCola.encolar(elemNesimo);
            }
            System.out.println("COLA REPLICADA");
            
            while(!this.nuevaCola.esVacia()){
                System.out.println(this.nuevaCola.desencolar());
            }
        } else {
            System.out.println("La posición n no es válida.");
        }
    }

    private int repetirNesimoAux(int n) {
        int elem;
        if (n == 1) {
            elem = this.nuevaCola.desencolar();
        } else {
            int elemAnterior = repetirNesimoAux(n-1);
            elem = this.nuevaCola.desencolar();
            this.nuevaCola.encolar(elemAnterior);
        }
        return elem;
    }
}
