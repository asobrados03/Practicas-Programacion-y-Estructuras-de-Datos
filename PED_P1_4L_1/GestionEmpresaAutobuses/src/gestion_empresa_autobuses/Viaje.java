/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_empresa_autobuses;

import java.io.Serializable;


/**
 * Esta clase contiene los métodos y atributos del viaje
 * @author Raúl Colindres y Alfredo Sobrados
 */
public class Viaje implements Serializable{
    private int codigo;
    private String origen;
    private String destino;
    private String hora;
    
    public Viaje(int codigo, String origen, String destino, String hora){
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    public String getDestino(){
        return this.destino;
    }
    
    public String getHora(){
        return this.hora;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
