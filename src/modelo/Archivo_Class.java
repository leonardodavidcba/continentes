/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author leonardodavid
 * 
 *  ESTA CLASE ES PARA CUANDO QUIERAMOS ENVIAR ARCHIVOS NO ELIMINAR!
 */
public class Archivo_Class 
{
    public String nombre;
    public String ruta;
    
    // constructor
    public Archivo_Class()
    {
        this.nombre = "";
        this.ruta ="";
    }
    
    
    // constructor
    public Archivo_Class(String nombre, String ruta)
    {
        this.nombre = nombre;
        this.ruta = ruta;
    }
}
