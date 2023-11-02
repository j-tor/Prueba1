/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1q4;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author aleja
 */
public abstract class BlockBusterItem {
    
    private int codigo;
    private String nombre;
    private double precio_renta;
    private Calendar fecha;
    private String tipo;

    public BlockBusterItem(int Código, String nombre, double precio_renta,String tipo) {
        this.codigo = Código;
        this.nombre = nombre;
        this.precio_renta = precio_renta;
        this.fecha = Calendar.getInstance();
        this.tipo  = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCódigo() {
        return codigo;
    }

    public void setCódigo(int Código) {
        this.codigo = Código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_renta() {
        return precio_renta;
    }

    public void setPrecio_renta(double precio_renta) {
        this.precio_renta = precio_renta;
    }

    public abstract double pagoRenta(int dias);
    
    @Override
    public String toString(){
        return "Codigo: "+codigo+" Nombre: "+nombre+" Precio: "+precio_renta;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
}
