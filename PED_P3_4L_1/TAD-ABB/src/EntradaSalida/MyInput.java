/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntradaSalida;

import java.io.*;
import java.util.ArrayList;
/**
 * Esta clase contiene los metodos y atributos de los procesos E/S que se precisan en este programa.
 * @author Raul Colindres y Alfredo Sobrados
 */
public class MyInput {
    /**
     * Metodo que lee una cadena de caracteres desde el teclado.
     * @return string devuelve el string leído a traves de la pantalla
     */
public static String readString() {
    BufferedReader br = new BufferedReader(new
    InputStreamReader(System.in),1);
    String string="";
    try {
        string = br.readLine(); }
    catch (IOException ex) {
        System.out.println(ex); }
    return string; }

/**
 * Metodo que lee un dato tipo int desde el teclado.
 * @return Integer devuelve el entero leído a traves de la pantalla
 * @throws NumberFormatException arroja esta excepción cuando el formato del número no es correcto
 * Postcondition: El valor que devuelve debe ser un número entero
 */
public static int readInt() throws NumberFormatException{
    return Integer.parseInt(readString()); 
}

/**
 * Metodo que lee un fichero que este en la carpeta raíz del proyecto.
 * @param nombreFichero es el string que contiene el nombre del fichero 
 * @return v ArrayList de Strings que contiene la información del fichero leído
 */
public static ArrayList <String> leeFichero(String nombreFichero){
    ArrayList <String> v = new ArrayList <String>();
    File fichero=null;
    FileReader fr=null;
    BufferedReader br=null;
    try{
        fichero=new File(nombreFichero);
        fr=new FileReader(fichero);
        br=new BufferedReader(fr);
        String linea;
        while ((linea=br.readLine())!=null){
        v.add(linea);}
    }
    catch (Exception e){
        e.printStackTrace();
    }
    finally {
    try {
        if (null!= fr){
        fr.close();
        br.close();}
        }
        catch (Exception e1){
        e1.printStackTrace();
        }
    }
    return v;
    }
/**
 * Metodo que realiza la serialización y deserialización.
 * @param <A> parametro descocido para mi
 * @param a parametro descocido para mi
 * @param nombreFichero nombre del fichero a guardar en en la carpeta raíz del proyecto desde el programa o cargar desde la carpeta raíz hacía el programa
 */
    public static <A> void serialize(A a, String nombreFichero) {
        System.out.println("Serializando...");
        try {
            FileOutputStream fos = new FileOutputStream(nombreFichero) ;
            ObjectOutputStream oos = new ObjectOutputStream(fos) ;
            oos.writeObject(a) ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
    }
    public static <A> A deserialize(String nombreFichero) {
        System.out.println("DeSerializing...");
        try {
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (Exception e) {
            System.err.println("Problem: "+e) ;
        }
        return null ;
}

}