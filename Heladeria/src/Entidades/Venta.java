/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import dao.VentaDao;
/**
 *
 * @author alumno
 */
public class Venta {
    private String helado;
    private int cantidad;
    private double importe;
    private String fecha;
    private int id;
    public Venta(int id, String helado,int cantidad, double importe, String fecha)
    {
        this.cantidad=cantidad;
        this.fecha=fecha;
        this.helado=helado;
        this.importe=importe;
        this.id= id;
    }
    public Venta()
    {}
    
    public static void GuardarVenta(Venta venta)
    {
        VentaDao ventadao = new VentaDao();
        ventadao.guardarVenta(venta);
    }
    
    public int GetId()
    {
        return this.id;
    }
    public void SetId(int id)
    {
        this.id=id;
    }
    public String GetHelado()
    {
        return this.helado;
    }
    public void SetHelado(String helado)
    {
        this.helado = helado;
    }
    public int GetCantidad()
    {
        return this.cantidad;
    }
    public void SetCantidad(int cantidad)
    {
        this.cantidad=cantidad;
    }
    public String GetFecha()
    {
        return this.fecha;
    }
    public void SetFecha(String fecha)
    {
        this.fecha=fecha;
    }
    public Double GetImporte()
    {
        return this.importe;
    }
    public void SetImporte(Double importe)
    {
        this.importe=importe;
    }
}
