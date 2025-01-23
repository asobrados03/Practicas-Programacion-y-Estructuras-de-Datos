/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import EntradaSalida.MyInput;
import java.util.Scanner;
import librerias.estructurasDeDatos.lineales.*;

/**
 *
 * @author Usuario
 */
public class SubMenuPilaEnteros extends Menus {
    private LEPila<Integer> pila;
    
    public SubMenuPilaEnteros(){
        pila=new LEPila<Integer>();
    }
    
    @Override
    public String ejecutarOpciones() {
       System.out.println("");
        System.out.println("SubMenú Pila de Enteros");
        System.out.println("Seleccione una opción:");
        System.out.println("0. Volver");
        System.out.println("");
        System.out.println("1. Crear Pila de enteros");
        System.out.println("2. Introducir elementos en la Pila");
        System.out.println("3. Duplicar Pila");
        System.out.println("4. Invertir Pila");
        System.out.println("5. Comprobar Base de la Pila");
        String s=MyInput.readString();
        switch(s){
                case "0": {return "n";}
                case "1": {crearPilaEnteros();return "s";}
                case "2": {apilarElemPos();return "s";}
                case "3": {duplicarPila();return "s";}
                case "4": {invertirPilaPC();return "s";} 
                case "5": {comprobarBasePila();return"s";}
                default: {System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
            } 
    }
    
    public void crearPilaEnteros(){
        if(!pila.esVacia()){
            System.out.println("Pila de enteros existe!!");
            vaciarPila();
            System.out.println("Pila de enteros vaciada con exito.");
        }
        else{
            pila = new LEPila<Integer>();
            System.out.println("Pila vacía creada.");
            System.out.println("Pulse <Intro> para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
    
    private void vaciarPila(){
        while(!pila.esVacia()){
            pila.desapilar();
        }
    }
    
    public void apilarElemPos(){
        int num=-1;
        
        System.out.println("Introduzca el entero que quiere almacenar en la Pila (para finalizar pulse 0):");
        while(num!=0){
            num = MyInput.readInt();
            if(num>0){
                pila.apilar(num);
            }  
        }
        
        LEPila<Integer> aux = new LEPila<Integer>();

        System.out.println("PILA:");
        while(!pila.esVacia()) {
            int numero = pila.desapilar();
            System.out.println(numero);
            aux.apilar(numero);
        }
        while(!aux.esVacia()){
            int numero = aux.desapilar();
            pila.apilar(numero);
        }
    }
    
    public void duplicarPila() {
        LEPila<Integer> copia = new LEPila<Integer>();
        duplicarPilaAux(copia);
        System.out.println("Pila Original:");
        while (!pila.esVacia()){
            System.out.println(pila.desapilar());
        }
        
        System.out.println("Pila Copiada:");
        System.out.println("NUEVA_PILA");
        
        while (!copia.esVacia()){
            System.out.println(copia.desapilar());
        }
    }


    private void duplicarPilaAux( LEPila<Integer> copia) {
        if (pila.esVacia()) return;
        Integer elemento = pila.desapilar();
        duplicarPilaAux(copia);
        copia.apilar(elemento);
        pila.apilar(elemento);
    }

    
    public void invertirPilaPC() {
        ArrayCola<Integer> cola = new ArrayCola<Integer>();
        
        System.out.println("Pila Original");
        System.out.println("PILA");
        // Mover los elementos de la pila original a la cola
        while (!pila.esVacia()) {
            int elem = pila.tope();
            cola.encolar(pila.desapilar());
            System.out.println(elem);
        }

        // Mover los elementos de la cola a la pila
        while (!cola.esVacia()) {
            pila.apilar(cola.primero());
            cola.desencolar();
        }

        // Imprimir la pila invertida
        System.out.println("La pila invertida queda...");
        System.out.println("PILA");
        while (!pila.esVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }
    
    public void comprobarBasePila(){
        int num,valor;
        
        LEPila<Integer> copia = new LEPila<Integer>();
        LEPila<Integer> aux = new LEPila<Integer>();
        LEPila<Integer> cp2 = new LEPila<Integer>();
        
        while(!pila.esVacia()){
            aux.apilar(pila.desapilar());
        }
        
        while(!aux.esVacia()){
            int elemento = aux.desapilar();
            pila.apilar(elemento);
            copia.apilar(elemento);
        }
        
        while(!copia.esVacia()){
            cp2.apilar(copia.desapilar());
        }
        
        num = comprobarBasePila(cp2);
        
        if(num==pila.tamaño()){
            valor=0;
        }
        else if(num > pila.tamaño()){
            valor=1;
        }
        else if(num < pila.tamaño() && num!=-1){
            valor=2;
        }
        else{
            valor=-1;
        }

        System.out.println("PILA");
        while (!pila.esVacia()) {
            System.out.println(pila.desapilar());
        }
        
        switch (valor) {
            case 0: {System.out.println("El elemento de la base de la pila es IGUAL que el número de elementos de la misma");}
                break;
            case 1: {System.out.println("El elemento de la base de la pila es MAYOR que el número de elementos de la misma");}
                break;
            case 2: {System.out.println("El elemento de la base de la pila es MENOR que el número de elementos de la misma");}
                break;
            default: {System.out.println("ERROR!!");}
        }    
    }
    
    private static int comprobarBasePila(LEPila<Integer> p){
        int elemento=-1;
        if(!p.esVacia() && p.tamaño()!=1){
            elemento = p.desapilar();
            comprobarBasePila(p);   
        }
        return elemento;
    }
}
