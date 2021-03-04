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
public class Empleados extends Personas{
    public String ced;

    
    public String rol;

    public Empleados(String ced, String rol, String id_persona, String Nombre, String Apellido) {
        super(id_persona, Nombre, Apellido);
        this.ced = ced;
        this.rol = rol;
    }

    

    public String getCed() {
        return ced;
    }

    public String getRol() {
        return rol;
    }
    
    
}
