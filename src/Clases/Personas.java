/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author PC
 */
public class Personas {
    public String id_persona;
    public String Nombre;
    public String Apellido;

    public Personas(String id_persona, String Nombre, String Apellido) {
        this.id_persona = id_persona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
    
}
