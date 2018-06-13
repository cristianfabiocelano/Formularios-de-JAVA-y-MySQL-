/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class VentaDao {

    public void guardarVenta(Venta venta) {

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO HELADO (HELADO, CANTIDAD, IMPORTE, FECHA) VALUES (?,?,?,?)");
            ps.setString(1, venta.GetHelado());
            ps.setInt(2, venta.GetCantidad());
            ps.setDouble(3, venta.GetImporte());
            ps.setString(4, venta.GetFecha());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Los datos fueron cargados correctamente!");
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public ArrayList<Venta> listarVentas() {

        ArrayList<Venta> lista = new ArrayList<Venta>();
        Venta venta;

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM VENTA");
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()) {
                venta = new Venta();
                venta.SetId(Integer.parseInt(rs.getString("idVenta")));
                venta.SetHelado(rs.getString("nombreHelado"));
                venta.SetCantidad(Integer.parseInt(rs.getString("cantidad")));
                venta.SetImporte(Double.parseDouble(rs.getString("importe")));
                venta.SetFecha(rs.getString("fecha"));

                lista.add(venta);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return lista;
    }
}
