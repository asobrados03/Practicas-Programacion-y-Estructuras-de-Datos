/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import EntradaSalida.MyInput;
import gestion_empresa_autobuses.Autobus;
import gestion_empresa_autobuses.Viaje;
import librerias.estructurasDeDatos.lineales.LDEGOrdenada;
import librerias.estructurasDeDatos.lineales.LEG;
import librerias.estructurasDeDatos.lineales.NodoLDEG;
import librerias.estructurasDeDatos.lineales.NodoLEG;

/**
 * Esta clase contiene los métodos y atributos del menú mantenimiento
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class MenuMantenimiento extends Menus {
    private LDEGOrdenada listaBuses;
    
    public MenuMantenimiento(LDEGOrdenada listaBuses){
        this.listaBuses = listaBuses;
    }
    
    @Override
    public String ejecutarOpciones() {
        System.out.println("");
        System.out.println("Menú Mantenimiento");
        System.out.println("Seleccione una opción:");
        System.out.println("0. Volver al menú principal");
        System.out.println("");
        System.out.println("1. Alta de autobús");
        System.out.println("2. Baja de autobús");
        System.out.println("3. Modificación de autobús");
        System.out.println("");
        System.out.println("4. Registrar viaje");
        System.out.println("5. Borrar viaje");
        System.out.println("6. Modificar viaje");
        String s=MyInput.readString();
        switch(s){
                case "0": {return "n";}
                case "1": {altaAutobus();return "s";}
                case "2": {bajaAutobus();return "s";}
                case "3": {modificacionAutobus();return "s";}
                case "4": {altaViaje();return "s";} 
                case "5": {bajaViaje();return"s";}
                case "6": {modificacionViaje();return "s";}
                default: {System.out.println("Opción no válida. Vuelva a intentarlo."); return "s";}
            }
    }
    
    public void altaAutobus(){
        String respuesta;
        NodoLDEG nodoEncontrado;
        
        do{
            System.out.println("Alta de Autobuses");
            System.out.println("");
            do{
                System.out.println("Introduzca la matricula del autobus que quiere dar de alta: ");
                String matricula = MyInput.readString();
        
                //comprobamos si la matricula esta o no esta en el sistema y si esta mostramos un mensaje de error y si no esta seguimos con el alta
                nodoEncontrado = listaBuses.buscarPorMatricula(matricula);
        
                if(nodoEncontrado==null){
                    System.out.println("Introduzca el año de compra del autobus: ");
                    int anioCompra = MyInput.readInt();
                
                    System.out.println("Introduzca el número de plazas o asientos que tiene el autobus: ");
                    int nPlazas = MyInput.readInt();
        
                    Autobus autobus = new Autobus(matricula, anioCompra, nPlazas);

                    listaBuses.insertar(autobus);
                }
                else{
                    System.out.println("ERROR: ya existe un autobús registrado con esa matrícula.");
                    System.out.println("Intentelo de nuevo.");
                }
            }while(nodoEncontrado!=null);
            
            System.out.println("¿Desea añadir un nuevo autobus?(S/N):");
            respuesta = MyInput.readString().toUpperCase();
        }while(respuesta.equals("S"));
    }
    
    public void bajaAutobus(){
        String respuesta;
        NodoLDEG nodoEncontrado;
        
        do{
            System.out.println("Baja de Autobuses");
            System.out.println("");
            do{
                System.out.println("Introduzca la matricula del autobus que quiere dar de baja: ");
                String matricula = MyInput.readString();

                nodoEncontrado = listaBuses.buscarPorMatricula(matricula);

                if(nodoEncontrado!=null){
                    Autobus autobus = (Autobus) nodoEncontrado.getDato();

                    System.out.println("DATOS DEL AUTOBUS QUE QUIERE DAR DE BAJA");
                    System.out.println("");
                    System.out.println("Matrícula: "+autobus.getMatricula());
                    System.out.println("Año de compra: "+autobus.getAnioCompra());
                    System.out.println("Número de plazas: "+autobus.getNumPlazas());

                    System.out.println("¿Desea dar de baja este autobus?(S/N): ");
                    respuesta = MyInput.readString().toUpperCase();

                    if(respuesta.equals("S")){
                        listaBuses.eliminar(autobus);
                        System.out.println("Baja registrada");
                    }
                    else{
                        System.out.println("Proceso de baja abortado");
                    }
                }
                else{
                    System.out.println("ERROR: esta matrícula no está registrada en la aplicación.");
                    System.out.println("Intentelo de nuevo.");
                }
            }while(nodoEncontrado==null);
            
            
            System.out.println("¿Desea dar de baja otro autobus?(S/N): ");

            respuesta = MyInput.readString().toUpperCase();
        }while(respuesta.equals("S"));
    }
    
    public void modificacionAutobus(){
        String respuesta;
        NodoLDEG nodoEncontrado;
        
        do{
            System.out.println("Modificación de Autobuses");
            System.out.println("");
            do{
                System.out.println("Introduzca la matricula del autobus que quiere modificar: ");
                String matricula = MyInput.readString();

                nodoEncontrado = listaBuses.buscarPorMatricula(matricula);

                if(nodoEncontrado!=null){
                    Autobus autobus = (Autobus) nodoEncontrado.getDato();

                    System.out.println("Introduzca el número de plazas del autobus: ");
                    int nPlazas = MyInput.readInt();
                    autobus.setNumPlazas(nPlazas);

                    System.out.println("Introduzca el año de compra del autobus: ");
                    int aCompra = MyInput.readInt();
                    autobus.setAnioCompra(aCompra);
                }
                else{
                    System.out.println("ERROR: está matrícula no está registrada en la aplicación");
                }
            }while(nodoEncontrado==null);
            
            System.out.println("¿Desea modificar los datos de otro autobus?(S/N): ");

            respuesta = MyInput.readString().toUpperCase();
        }while(respuesta.equals("S"));
    }
    
    public void altaViaje(){
        boolean existe=false;
        System.out.println("Registrar viaje");
        
        System.out.println("Introduzca la matrícula del autobus al que quiere registrar este viaje:");
        String matricula=MyInput.readString();
        System.out.println("Introduzca el código númerico del viaje:");
        int codigo=MyInput.readInt();
        System.out.println("Introduzca la ciudad de origen del viaje:");
        String origen=MyInput.readString();
        System.out.println("Introduzca la ciudad de destino del viaje:");
        String destino=MyInput.readString();
        System.out.println("Introduzca la hora a la que sale el viaje:");
        String hora=MyInput.readString();
        
        // Buscar el autobús con la matrícula indicada
        NodoLDEG nodoEncontrado = listaBuses.buscarPorMatricula(matricula);
        
        if (nodoEncontrado == null) {
            System.out.println("El autobús con matrícula " + matricula + " no está registrado en la aplicación.");
            return;
        }
        
        // Crear el nuevo viaje
        Viaje nuevoViaje = new Viaje(codigo, origen, destino, hora);
        
        if(nodoEncontrado.getListaSecundaria() != null){
            // Comprobar si el autobús ya tiene un viaje con los mismos datos
            existe = nodoEncontrado.existeNodoSecundarioIgual(nuevoViaje);
        }
        
        if(existe){
            System.out.println("Ya existe un viaje similar registrado en este autobus");
        }
        else{
            // Añadir el nuevo viaje al autobús correspondiente
            if (nodoEncontrado.getListaSecundaria() == null) {
                nodoEncontrado.setListaSecundaria(new LEG());
                nodoEncontrado.getListaSecundaria().insertar(nuevoViaje);
            }
            else{
                nodoEncontrado.getListaSecundaria().insertar(nuevoViaje);
            }
            
            System.out.println("Viaje registrado correctamente.");
        }
    }
    
    public void bajaViaje(){
        String respuesta;
        
        do{
            System.out.println("Baja de Viajes");
            System.out.println("");
            System.out.println("Introduzca la matrícula del autobus que realiza el viaje que quiere borrar: ");
            String matricula = MyInput.readString();
            System.out.println("Introduzca el codigo del viaje que quiere dar de baja o borrar: ");
            int codigo = MyInput.readInt();
        
            NodoLDEG nodoEncontrado = listaBuses.buscarPorMatricula(matricula);
            
            if(nodoEncontrado!=null){
                NodoLEG nodoViaje = nodoEncontrado.getListaSecundaria().buscar(codigo);
                Viaje viaje = (Viaje) nodoViaje.getDato();
                
                System.out.println("DATOS DEL VIAJE QUE QUIERE DAR DE BAJA");
                System.out.println("");
                System.out.println("Origen: "+viaje.getOrigen());
                System.out.println("Destino: "+viaje.getDestino());
                System.out.println("Hora: "+viaje.getHora());
                
                System.out.println("Desea dar de baja este viaje(S/N): ");
                respuesta = MyInput.readString().toUpperCase();
                
                if(respuesta.equals("S")){
                    nodoEncontrado.getListaSecundaria().eliminar(viaje);
                    System.out.println("Baja registrada");
                }
                else{
                    System.out.println("Proceso de baja abortado");
                }
            }
            else{
                System.out.println("ERROR: esta viaje no está registrado en el autobús.");
                System.out.println("Intentelo de nuevo.");
            }
            
            System.out.println("¿Desea dar de baja otro viaje?(S/N): ");
            respuesta = MyInput.readString().toUpperCase();
            
        }while(respuesta.equals("S"));
    }
    
    public void modificacionViaje(){
       String respuesta;
        NodoLDEG nodoEncontrado;
        do{
            System.out.println("Modificación de Viajes");
            System.out.println("");
            do{
                System.out.println("Introduzca la matricula del autobus del viaje que desea modificar: ");
                String matricula = MyInput.readString();
                nodoEncontrado = listaBuses.buscarPorMatricula(matricula);

                if(nodoEncontrado!=null){
                    Autobus autobus = (Autobus) nodoEncontrado.getDato();
                    System.out.println("LISTADO DE VIAJES DEL AUTOBUS CON MATRICULA: " + autobus.getMatricula());
                    System.out.printf("%-10s %-10s %-10s %-10s\n", "Codigo", "Origen", "Destino", "Hora");
                    System.out.println("--------------------------------------------------");
                    LEG listaViajes = nodoEncontrado.getListaSecundaria();
                    listaViajes.mostrarInfoViajes();
                    System.out.println("Introduzca el código del viaje que desea modificar: ");
                    int codigoViaje = MyInput.readInt();
                    NodoLEG nodoViaje = listaViajes.buscar(codigoViaje);
                    if(nodoViaje!=null){
                        Viaje viaje = (Viaje) nodoViaje.getDato();
                        System.out.println("Los datos del viaje " + viaje.getCodigo() + " son: ");
                        System.out.println("Origen: " + viaje.getOrigen());
                        System.out.println("Destino: " + viaje.getDestino());
                        System.out.println("Hora: " + viaje.getHora());
                        System.out.println("Introduzca el nuevo origen: ");
                        String nuevoOrigen = MyInput.readString();
                        viaje.setOrigen(nuevoOrigen);
                        System.out.println("Introduzca el nuevo destino: ");
                        String nuevoDestino = MyInput.readString();
                        viaje.setDestino(nuevoDestino);
                        System.out.println("Introduzca la nueva hora: ");
                        String nuevaHora = MyInput.readString();
                        viaje.setHora(nuevaHora);
                        System.out.println("Autobús " + autobus.getMatricula() + ": Viaje " + viaje.getCodigo() + " modificado correctamente");
                    }
                    else{
                        System.out.println("ERROR: este codigo no está registrado en la aplicación");
                    }
                }
                else{
                    System.out.println("ERROR: está matrícula no está registrada en la aplicación");
                }
            }while(nodoEncontrado==null);
            System.out.println("¿Desea modificar los datos de otro viaje?(S/N): ");
            respuesta = MyInput.readString().toUpperCase();
        }while(respuesta.equals("S"));
    }
}
