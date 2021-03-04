/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Conexion {

    public Connection con = null;
    public PreparedStatement smtp = null;
    public ResultSet rs = null;
    

    public Connection conexion() {

        String urlDatabase = "jdbc:postgresql://localhost:5432/Peter_gr";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(urlDatabase, "postgres", "123456789");

        } catch (Exception e) {

            System.out.println("vistas.Login.conexion() " + e);
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    public void close() {
        try {
            con.close();
            smtp.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public ResultSet buscarLogin(String txtUser, String txtpass, String categoria) {
        con = conexion();
        try {
            smtp = con.prepareStatement("SELECT * FROM empleados WHERE empleados.cedula= ? AND empleados.\"contraseña\"= ? AND empleados.rol= ?");
            smtp.setString(1, txtUser);
            smtp.setString(2, txtpass);
            smtp.setString(3, categoria);

            rs = smtp.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Object[] BuscarCli(String ced) {
        con = conexion();
        String msj = null;
        Object[] arr = new Object[2];
        try {
            
            smtp = con.prepareStatement("SELECT * from cliente WHERE \"cedulaCli\" LIKE ?");
            smtp.setString(1, "%"+ced+"%");
            
            
            rs = smtp.executeQuery();
        } catch (Exception e) {
            msj = "error " + e;
        }
        arr[0] = rs;
        arr[1] = msj;

        return arr;

    }

    public Object[] BuscarCliId(int id) {
        con = conexion();
        String msj = null;
        Object[] arr = new Object[2];
        try {
            
            smtp = con.prepareStatement("SELECT * from cliente WHERE id_cliente= ? ");
            smtp.setInt(1, id);
            
            
            rs = smtp.executeQuery();
        } catch (Exception e) {
            msj = "error " + e;
        }
        arr[0] = rs;
        arr[1] = msj;

        return arr;

    }

    
    public Object[] Platos(String id,String nomPlatos) {
        con = conexion();
        String msj = null;
        Object[] arr = new Object[2];
        try {
            if(id==null && nomPlatos==null){
                smtp = con.prepareStatement("SELECT * FROM platos");
            }else if(id!=null && nomPlatos==null){
                smtp = con.prepareStatement("SELECT * FROM platos WHERE id_plato= ?");
                smtp.setString(1, id);
            }else if(id==null && nomPlatos!=null){
                smtp = con.prepareStatement("SELECT * FROM platos WHERE \"nombrePla\"= ?;");
                smtp.setString(1, nomPlatos);
            }
            
            rs = smtp.executeQuery();
        } catch (Exception e) {
            msj = "error " + e;
        }
        arr[0] = rs;
        arr[1] = msj;

        return arr;

    }
    public Object PlatosInser(int id_emp ,int id_cli, int id_pla, double valor){
        con=conexion();
        int count = 0;
        String msj=null;
        Object [] obs=new Object[2];
        try {
            smtp = con.prepareStatement("INSERT INTO public.compras(id_empleado, id_cliente, id_plato, valor) VALUES (?, ?, ?, ?)");
            
            smtp.setInt(1, id_emp);
            smtp.setInt(2, id_cli);
            smtp.setInt(3, id_pla);
            smtp.setDouble(4, valor);

            
            count = smtp.executeUpdate();

        } catch (SQLException ex) {
            msj="error "+ex;
        }
        obs[0]=count;
        obs[1]=msj;
        return obs;
    }
    public Object[] CompraCli(int id){
        con=conexion();
        int count =0;
        String msj=null;
        Object[] arr = new Object[2];
        try {
            smtp=con.prepareStatement("SELECT * FROM compras WHERE id_cliente= ?");
            smtp.setInt(1, id);
            rs = smtp.executeQuery();
        } catch (Exception e) {
             msj="erro "+e;
        }
        arr[0]=rs;
        arr[1]=msj;
        return arr;
    }

    public Object[] Platos(Object object, Object object0, Object object1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
