/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_empresa_autobuses;

import java.io.Serializable;


/**
 * Esta clase contiene los métodos y atributos del autobus
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class Autobus implements Comparable<Autobus>, Serializable{
    private String matricula;
    private int anioCompra;
    private int numPlazas;
    
    public Autobus(String matricula, int anioCompra, int numPlazas){
        this.matricula = matricula;
        this.anioCompra = anioCompra;
        this.numPlazas = numPlazas;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public int getAnioCompra(){
        return this.anioCompra;
    }
    
    public int getNumPlazas(){
        return this.numPlazas;
    }
    
    public void setNumPlazas(int nPlazas){
        this.numPlazas = nPlazas;
    }
    
    public void setAnioCompra(int aCompra){
        this.anioCompra = aCompra;
    }

    @Override
    public int compareTo(Autobus otroAutobus) {
        return Integer.compare(this.numPlazas, otroAutobus.numPlazas);
    }
}
