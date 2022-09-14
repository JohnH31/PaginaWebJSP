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
public class ClienteDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conector c = new Conector();
    Connection con;

    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_cliente";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setId(rs.getInt(1));
                p.setNit(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setApellido(rs.getString(4));
                p.setTel(rs.getInt(5));

                lista.add(p);
            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Cliente p) {
        int r = 0;
        String sql = "INSERT INTO tbl_cliente(id_cliente,nit_cliente,nombres_cliente,apellidos_cliente,telefono_cliente)VALUE(?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getNit());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setInt(5, p.getTel());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {

        }
        return r;
    }

    public Cliente listarId(String id) {
        String sql = "SELECT * FROM tbl_cliente WHERE id_cliente=" + id;
        Cliente p = new Cliente();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNit(rs.getInt(2));
                p.setNombre(rs.getString(3));
                p.setApellido(rs.getString(4));
                p.setTel(rs.getInt(5));
            }

        } catch (Exception e) {

        }
        return p;
    }

    public void actualizar(Cliente p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_cliente SET nit_cliente=" + p.getNit()
                    + ",nombres_cliente='" + p.getNombre()+ "',apellidos_cliente='" 
                    + p.getApellido()+"',telefono_cliente=" + p.getTel()
                    + " WHERE id_cliente=" + p.getId();
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("Mensaje Actualizar " + e.getMessage());
        }
        c.desconectar();
    }

    public void eliminar(Cliente p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_cliente WHERE id_cliente =" + p.getId() + ";";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje eliminar " + e.getMessage());
        }
        c.desconectar();
    }
}
