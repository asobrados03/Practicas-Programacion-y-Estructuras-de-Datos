/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import EntradaSalida.MyInput;
import gestion_empresa_autobuses.Autobus;
import gestion_empresa_autobuses.Viaje;
import librerias.estructurasDeDatos.lineales.LDEGOrdenada;
import librerias.estructurasDeDatos.lineales.NodoLDEG;
import librerias.estructurasDeDatos.lineales.LEG;
import librerias.estructurasDeDatos.lineales.NodoLEG;

/**
 * Esta clase contiene los métodos y atributos del menú listados
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class MenuListados extends Menus{
    private LDEGOrdenada listaBuses;

    
    public MenuListados(LDEGOrdenada listaBuses){
        this.listaBuses = listaBuses;

    }
    
    
    @Override
    public String ejecutarOpciones() {
       System.out.println("");
        System.out.println("Menú Listados");
        System.out.println("Seleccione una opción:");
        System.out.println("0. Volver al menú principal");
        System.out.println("");
        System.out.println("1. Listado general de autobuses ordenador por número de plazas (orden ascendente)");
        System.out.println("2. Listado general de autobuses ordenador por número de plazas (orden descendente)");
        System.out.println("3. Listado general de viajes");
        System.out.println("4. Listado de viajes que parten de una ciudad determinada");
        System.out.println("5. Listado de viajes que llegan a una ciudad determinada");
        System.out.println("6. Listado de autobuses que tienen una capacidad mayor o igual a la indicada por el usuario");
        System.out.println("7. Listado del autobús o autobuses que realizan la mayor cantidad de viajes");
        System.out.println("8. Cantidad total de viajes que realizan los autobuses de la empresa");
        System.out.println("9. Cantidad total de pasajeros que viajan de una ciudad a otra");
        String s=MyInput.readString();
        switch(s){
                case "0": {return "n";}
                case "1": {listadoGeneralAutobusesAscendente();return "s";}
                case "2": {listadoGeneralAutobusesDescendente();return "s";}
                case "3": {listadoGeneralViajes();return "s";}
                case "4": {listadoViajesPartenCiudad();return "s";} 
                case "5": {listadoViajesLleganCiudad();return"s";}
                case "6": {listBusesMayorIgualAlValorIndicado();return "s";}
                case "7": {mayorViajes();return "s";}
                case "8": {totalViajes();return "s";}
                case "9": {totalPasajeros();return "s";}
                default: {System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
            } 
    }
    
    public void listadoGeneralAutobusesAscendente(){
        System.out.println("LISTADO GENERAL DE AUTOBUSES POR NÚMERO DE PLAZAS (Orden Ascendente)");
        System.out.println("\tMatrícula\tAño Compra\tPlazas");
        this.listaBuses.mostrarInfoAscendente();
    }
    
    public void listadoGeneralAutobusesDescendente(){
        System.out.println("LISTADO GENERAL DE AUTOBUSES POR NÚMERO DE PLAZAS (Orden Descendente)");
        System.out.println("\tMatrícula\tAño Compra\tPlazas");
        this.listaBuses.mostrarInfoDescendente();
    }
    
    public void listadoGeneralViajes(){
        System.out.println("LISTADO GENERAL DE VIAJES");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Bus", "Codigo", "Origen", "Destino", "Hora");
        System.out.println("--------------------------------------------------");

        NodoLDEG actualBus = listaBuses.getPrimero();

        while(actualBus != null) {
            Autobus a = (Autobus) actualBus.getDato();
            LEG actualViaje = actualBus.getListaSecundaria();
            
            if(actualViaje==null){
                actualBus = actualBus.getSiguiente();
            }
            else{
                NodoLEG nodoActual = actualViaje.getPrimero();
            
                while(nodoActual != null) {
                    Viaje v = (Viaje) nodoActual.getDato();
                    System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",a.getMatricula(), v.getCodigo(), v.getOrigen(), v.getDestino(), v.getHora());
                    nodoActual = nodoActual.getSiguiente();
                }

                actualBus = actualBus.getSiguiente();
            }

            
        }
    }
    
    public void listBusesMayorIgualAlValorIndicado(){
        System.out.println("LISTADO DE AUTOBUSES QUE TIENEN UNA CAPACIDAD MAYOR O IGUAL A LA INDICADA POR EL USUARIO");
        System.out.println("Introduzca la capacidad mínima que considere: ");
        int capacidadMin = MyInput.readInt();
        
        System.out.println("\tMatrícula\tAño Compra\tPlazas");
        this.listaBuses.mostrarInfoApartirDeValor(capacidadMin);
    }
    
    public void listadoViajesPartenCiudad(){
        System.out.println("LISTADO DE VIAJES QUE PARTEN DE UNA CIUDAD DETERMINADA");
        System.out.println("Introduzca la ciudad que considere: ");
        String ciudad = MyInput.readString();

        System.out.printf("%-10s %-10s %-10s %-10s\n", "Codigo", "Origen", "Destino", "Hora");
        System.out.println("--------------------------------------------------");

        NodoLDEG actualBus = listaBuses.getPrimero();
        while(actualBus != null){
            LEG actualViaje = actualBus.getListaSecundaria();
            if(actualViaje != null) {
                NodoLEG nodoEncontrado = actualViaje.buscarPorOrigen(ciudad);
                while(nodoEncontrado != null){
                    Viaje v = (Viaje) nodoEncontrado.getDato();
                    System.out.printf("%-10s %-10s %-10s %-10s\n", v.getCodigo(), v.getOrigen(), v.getDestino(), v.getHora());
                    nodoEncontrado = nodoEncontrado.getSiguiente();
                }
            } 
            else {
                System.out.println("No se encontraron más viajes que partan de la ciudad " + ciudad);
            }
            actualBus = actualBus.getSiguiente();
        }

    }
    
    public void listadoViajesLleganCiudad(){
        System.out.println("LISTADO DE VIAJES QUE LLEGAN DE UNA CIUDAD DETERMINADA");
        System.out.println("Introduzca la ciudad que considere: ");
        String ciudad = MyInput.readString();
        
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Codigo", "Origen", "Destino", "Hora");
        System.out.println("-------------------------------------------------------------");

        NodoLDEG actualBus = listaBuses.getPrimero();
        while(actualBus != null){
            LEG actualViaje = actualBus.getListaSecundaria();
            if(actualViaje != null) {
                NodoLEG nodoEncontrado = actualViaje.buscarPorDestino(ciudad);
                while(nodoEncontrado != null){
                    Viaje v = (Viaje) nodoEncontrado.getDato();
                    System.out.printf("%-10s %-10s %-10s %-10s\n", v.getCodigo(), v.getOrigen(), v.getDestino(), v.getHora());
                    nodoEncontrado = nodoEncontrado.getSiguiente();
                }
            } else {
                System.out.println("No se encontraron más viajes que lleguen de la ciudad " + ciudad);
            }
            actualBus = actualBus.getSiguiente();
        }

    }
    
    public void mayorViajes() {
        int maxViajes = 0;

        // Primero encontramos el número máximo de viajes realizados por un autobús
        for (NodoLDEG autobusActual = listaBuses.getPrimero(); autobusActual != null; autobusActual = autobusActual.getSiguiente()) {
            if(autobusActual.getListaSecundaria()!=null){
                int numViajes = autobusActual.getListaSecundaria().contarElementos();
                if (numViajes > maxViajes) {
                    maxViajes = numViajes;
                }
            }
            
        }

        // Luego recorremos la lista de autobuses para imprimir la información de los autobuses que realizan el número máximo de viajes
        System.out.println("LISTADO DEL AUTOBÚS O AUTOBUSES QUE REALIZAN MÁS VIAJES");
        System.out.println("--------------------------------------------------------");
        System.out.println("Autobus/es con mayor cantidad de viajes:");
        for (NodoLDEG autobusActual = listaBuses.getPrimero(); autobusActual != null; autobusActual = autobusActual.getSiguiente()) {
            if(autobusActual.getListaSecundaria()!=null){
                Autobus autobus = (Autobus) autobusActual.getDato();
                int numViajes = autobusActual.getListaSecundaria().contarElementos();
                if (numViajes == maxViajes) {
                    System.out.println("Autobús " + autobus.getMatricula() + " realiza " + numViajes + " viajes.");
                }
            }
            
            
        }
    }
    
    public void totalViajes() {
        int total = 0;
        NodoLDEG autobusActual = listaBuses.getPrimero();
        while (autobusActual != null) {
            if(autobusActual.getListaSecundaria()!=null){
                NodoLEG viajeActual = autobusActual.getListaSecundaria().getPrimero();
                while (viajeActual != null) {
                    total++;
                    viajeActual = viajeActual.getSiguiente();
                }
                
            }
            autobusActual = autobusActual.getSiguiente();
        }
        System.out.println("CANTIDAD TOTAL DE VIAJES QUE REALIZAN LOS AUTOBUSES DE LA EMPRESA");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("La cantidad total de viajes realizados es: " + total);
    }

    public void totalPasajeros() {
        int totalPasajeros = 0;
        
        System.out.println("CANTIDAD TOTAL DE PASAJEROS QUE VIAJAN DE UNA CIUDAD A OTRA");
        System.out.println("-----------------------------------------------------------------");
        
        System.out.println("Introduzca la ciudad de origen que considere: ");
        String origen = MyInput.readString();

        System.out.println("Introduzca la ciudad de destino que considere: ");
        String destino = MyInput.readString();

        NodoLDEG autobusActual = listaBuses.getPrimero();

        while(autobusActual != null) {
            Autobus autobus = (Autobus) autobusActual.getDato();
            if(autobusActual.getListaSecundaria()!=null){
                NodoLEG viajeActual = autobusActual.getListaSecundaria().getPrimero();

                while(viajeActual != null) {
                    Viaje v = (Viaje) viajeActual.getDato();

                    if(v.getOrigen().equals(origen) && v.getDestino().equals(destino)) {
                        totalPasajeros += autobus.getNumPlazas();
                    }

                    viajeActual = viajeActual.getSiguiente();
                }
            }
            
            autobusActual = autobusActual.getSiguiente();
        }

        System.out.println("La cantidad total de pasajeros que viajan de " + origen + " a " + destino + " es de: " + totalPasajeros);
    }
}