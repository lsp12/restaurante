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
public class Clientes extends Personas{
    public String cedula;

    public Clientes( String id_persona,String cedula, String Nombre, String Apellido) {
        super(id_persona, Nombre, Apellido);
        this.cedula = cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
