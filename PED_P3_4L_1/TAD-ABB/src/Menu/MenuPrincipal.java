/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import EntradaSalida.MyInput;
import java.util.logging.Level;
import java.util.logging.Logger;
import librerias.estructurasDeDatos.jerarquicos.*;
import librerias.excepciones.ElementoDuplicado;

/**
 * Esta clase contiene los metodos y atributos del menú principal
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class MenuPrincipal extends Menus{
    private ABBEnteros arbolEnteros;
    /**
     * Método constructor sin parametros
     */
    public MenuPrincipal(){
        super();
        arbolEnteros = new ABBEnteros();
    }
    /**
     * Método que ejecuta el menú principal del programa.
     * Realiza un bucle donde se ejecutan las opciones seleccionadas por el usuario hasta que la respuesta sea diferente de "s".
     */
    @Override
    public void ejecutar(){
        String respuesta="";
        
        do{
            respuesta = ejecutarOpciones();
        }while(respuesta.equals("s"));
    }
    /**
     * Método que ejecuta una opción del menú principal.
     * Imprime el menú principal y solicita al usuario que seleccione una opción.
     * Si la opción ingresada es inválida, muestra un mensaje de error.
     * @return La respuesta del usuario ("s" para seguir en el menú, "n" para salir).
     */
    @Override
    public String ejecutarOpciones(){
        System.out.println("");
            System.out.println("Menú Principal");
            System.out.println("seleccione una opción:");
            System.out.println("0. Salir");
            System.out.println("1. Crear ABB de enteros positivos (Equilibrado)");
            System.out.println("2. Listado de claves en orden ascendente");
            System.out.println("3. Listado de claves en orden descendente");
            System.out.println("4. Listado de claves por niveles (converso)");
            System.out.println("5. Transformar árbol ABB de enteros");
            System.out.println("6. Sumar claves menores que un número dado");
            System.out.println("7. Calcular el antecesor de un nodo");
            System.out.println("8. Mostrar hojas (posiciones impares)");
            
        String s=MyInput.readString();
        
        int i=0;
        try{  
            i= Integer.parseInt(s);
        }catch(NumberFormatException ex){
            System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
            return "s";
        } 
        switch(i){
            case 0: {System.out.println("Gracias por utilizar nuestros TAD ABB y ABBEnteros");return "n";}
            case 1: {try {
                crearABBEnterosPos();
            } catch (ElementoDuplicado ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "s";}
            case 2: {listadoClavesOrdenAscendente();return "s";}
            case 3: {listadoClavesOrdenDescendente();return "s";}
            case 4: {listadoClavesPorNivelesInverso();return "s";}
            case 5: {transformarABBEnteros();return "s";}
            case 6: {sumarClavesMinNumDado();return "s";}
            case 7: {calcularAntecesorNodo();return "s";}
            case 8: {mostrarHojasPosImpares();return "s";}
            default: {System.out.println("Opción no válida. Inténtelo de nuevo."); return "s";}
        } 
    }
    /**
     * Método que crea el arból binario de busqueda de enteros
     * @throws ElementoDuplicado si se intenta insertar un elemento duplicado
     */
    public void crearABBEnterosPos() throws ElementoDuplicado{
        Integer v[] = new Integer[50];
        
        String respuesta;
        int clave, contador=0;
        
        System.out.println("Crear un ABB(Árbol Binario de Busqueda) de claves enteras equilibrado (MÁX:50)");
        do{
            System.out.println("Introduzca la clave entera que quiere añadir al árbol");
            clave = MyInput.readInt();
            v[contador] = clave;
            contador++;
            
            System.out.println("¿Quieres añadir mas claves al árbol?(S/N): ");
            respuesta = MyInput.readString().toUpperCase();
        }while(respuesta.equals("S") && contador < 50);
        
        if(contador==50){
            System.out.println("El array ha llegado a su máxima capacidad no se pueden añadir mas claves enteras en el árbol binario de busqueda");
        }
        arbolEnteros.insertarEquilibrado(v);
    }
    /**
     * Método que lista las claves del ABB de enteros de manera ascendente
     */
    public void listadoClavesOrdenAscendente(){
        System.out.println("Opción 2: Listado de claves en orden ascendente");
        System.out.println("Salida en pantalla:");
        System.out.print(arbolEnteros.toStringInOrden());
    }
    /**
     * Método que lista las claves del ABB de enteros de manera descendente
     */
    public void listadoClavesOrdenDescendente(){
        System.out.println("Opción 3: Listado de claves en orden descendente");
        System.out.println("Salida en pantalla:");
        System.out.print(arbolEnteros.toStringInOrdenInverso());
    }
    /**
     * Método que lista las claves del ABB de enteros por niveles inverso
     */
    public void listadoClavesPorNivelesInverso(){
        System.out.println("Opción 4: Listado de claves por niveles (converso)");
        System.out.println("Salida en pantalla:");
        System.out.print(arbolEnteros.toStringPorNivelesInverso());
    }
    /**
     * Método que transforma las claves del ABB de enteros de claves positivas a negativas
     */
    public void transformarABBEnteros(){
        System.out.println("Opción 5: Transformar árbol ABB de enteros");
        arbolEnteros.transformarABBEnteros();
        System.out.println("Árbol transformado!!");
    }
    /**
     * Método que suma las claves del ABB de enteros a partir de un número mínimo dado
     */
    public void sumarClavesMinNumDado(){
        System.out.println("Opción 6: Sumar claves menores que un número dado");
        arbolEnteros.sumarClavesMinNumDado();
    }
    /**
     * Método que calcula el antecesor de una clave del ABB de enteros
     */
    public void calcularAntecesorNodo(){
        System.out.println("Opción 7: Calcular el antecesor de un nodo");
        arbolEnteros.calcularAntecesorNodo();
    }
    /**
     * Método que muestra las hojas en las posiciones impares
     */
    public void mostrarHojasPosImpares(){
        System.out.println("Opción 8: Mostrar hojas (posiciones impares)");
        arbolEnteros.mostrarHojasPosImpares();
    }  
}
