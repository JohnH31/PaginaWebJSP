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
public class GruposPerDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conector c = new Conector();
    Connection con;
    
    public List listar(){
        List<GruposPer>lista=new ArrayList<>();
        String sql = "SELECT * FROM tbl_gruposPermisos";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                GruposPer p = new GruposPer();
                p.setId(rs.getInt(1));
                p.setIdgrupo(rs.getInt(2));
                p.setIdper(rs.getInt(3));
                
                lista.add(p);
            }
            
            
        } catch (Exception e){
            
            
        }
        return lista;
    }
    
    public int agregar(GruposPer p){
        int r=0;
        String sql = "INSERT INTO tbl_gruposPermisos(id_grupoPer,id_grupo_fk,id_permiso_fk)VALUE(?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getIdgrupo());
            ps.setInt(3, p.getIdper());
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
    
    public GruposPer listarId(String id){
        String sql="SELECT * FROM tbl_gruposPermisos WHERE id_grupoPer="+id;
        GruposPer p = new GruposPer();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setIdgrupo(rs.getInt(2));
                p.setIdper(rs.getInt(3));
            }
          
        } catch (Exception e){
              
        }
        return p;
    }

    public void actualizar(GruposPer p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_gruposPermisos SET id_grupo_fk=" + p.getIdgrupo()+ ",id_permiso_fk="+p.getIdper()+" WHERE id_grupoPer=" + p.getId();
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("Mensaje Actualizar " + e.getMessage());
        }
        c.desconectar();
    }
public void eliminar(GruposPer p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_gruposPermisos WHERE id_grupoPer =" + p.getId() + ";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje eliminar " + e.getMessage());
        }
        c.desconectar();
    }
}
