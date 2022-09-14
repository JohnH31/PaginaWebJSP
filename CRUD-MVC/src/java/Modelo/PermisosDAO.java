/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario Local
 */
public class PermisosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conector c = new Conector();
    Connection con;
    
    public List listar(){
        List<Permisos>lista=new ArrayList<>();
        String sql = "SELECT * FROM tbl_permisos";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Permisos p = new Permisos();
                p.setId(rs.getInt(1));
                p.setPermiso(rs.getString(2));
                lista.add(p);
            }
            
            
        } catch (Exception e){
            
            
        }
        return lista;
    }
    
    public int agregar(Permisos p){
        int r=0;
        String sql = "INSERT INTO tbl_permisos(id_permiso,nombre_permiso)VALUE(?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getPermiso());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e){
            
        }
        return r;
    }
    
    public Permisos listarId(String id){
        String sql="SELECT * FROM tbl_permisos WHERE id_permiso="+id;
        Permisos p = new Permisos();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setPermiso(rs.getString(2));
            }
          
        } catch (Exception e){
              
        }
        return p;
    }
    
//    public int actualizar(Permisos p){
//        int r=0;
//        String sql2 = "UPDATE tbl_permisos SET nombre_permiso=? WHERE id_permiso=?";
//        try {
//            con = c.conectar();
//            ps = con.prepareStatement(sql2);
//            ps.setInt(1, p.getId());
//            ps.setString(2, p.getPermiso());
//            System.out.println(p.getId());
//            System.out.println(p.getPermiso());
//            System.out.println(r);
//            r = ps.executeUpdate();  
//            System.out.println(r);
//            if(r==1){
//                r=1;
//            }else{
//                r=0;
//            }
//        } catch (Exception e){
//            
//        }
//        return r;
//    }
    public void actualizar(Permisos p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_permisos SET nombre_permiso='" + p.getPermiso() + "' WHERE id_permiso=" + p.getId();
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("Mensaje Actualizar " + e.getMessage());
        }
        c.desconectar();
    }
public void eliminar(Permisos p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_permisos WHERE id_permiso =" + p.getId() + ";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje eliminar " + e.getMessage());
        }
        c.desconectar();
    }
}
