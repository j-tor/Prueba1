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
public class MovieItem extends BlockBusterItem{
    String estado;
    Calendar fecha = Calendar.getInstance();

    public MovieItem(String estado, int Código, String nombre, double precio_renta, Date fecha) {
        super(Código, nombre, precio_renta, fecha);
        this.estado = "ESTRENO";
    }

   

    @Override
    public double pagoRenta(int días) {
        long diferenciaDias = ((super.getFecha().getTimeInMillis() - fecha.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        if(diferenciaDias>2&&estado.equals("ESTRENO")){
        return super.getPrecio_renta()+(50*(diferenciaDias-2));
        }
        if(diferenciaDias>5&&estado.equals("NORMAL")){
        return super.getPrecio_renta()+(30*(diferenciaDias-5));
        }
        return super.getPrecio_renta();
    }

    @Override
    public String toString() {
        return super.toString()+" Estado: "+ estado+" movie"; 
    }
    
    public void evaluarEstado(){
        long diferenciaDias = ((super.getFecha().getTimeInMillis() - fecha.getTimeInMillis()) / (24 * 60 * 60 * 1000));
     if(diferenciaDias>150&&estado.equals("ESTRENO")){
         estado="NORMAL";
        }
    }
}
