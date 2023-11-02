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

    public BlockBusterItem(int Código, String nombre, double precio_renta, Date fecha) {
        this.codigo = Código;
        this.nombre = nombre;
        this.precio_renta = precio_renta;
        this.fecha = Calendar.getInstance();
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

    public abstract double pagoRenta(int días);
    
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
