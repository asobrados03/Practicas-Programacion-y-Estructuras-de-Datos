/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_empresa_autobuses;

import EntradaSalida.MyInput;
import Menus.MenuPrincipal;
import librerias.estructurasDeDatos.lineales.*;

/**
 * Esta clase es la clase principal del programa la cual lo ejecuta.
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class GestionEmpresaAutobuses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicación GEST_BUS");
        
        LDEGOrdenada<Autobus> listaBuses= MyInput.deserialize("datos.dat");
        if(listaBuses==null) listaBuses= new LDEGOrdenada<Autobus>();
        
        MenuPrincipal mp = new MenuPrincipal(listaBuses);
        mp.ejecutar();
        
        MyInput.serialize(listaBuses, "datos.dat");
    }
}
