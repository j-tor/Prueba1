/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1q4;

/**
 *
 * @author aleja
 */
public class VideoGameItem extends BlockBusterItem{
private String nombre_consola;
public static final String PLAYSTATION_STRING="PLAYSTATION";
public static final String XBOX_STRING="XBOX";
public static final String WII_STRING="WII";


    public VideoGameItem(String nombre_consola, int Código, String nombre, double precio_renta,String tipo) {
        super(Código, nombre, precio_renta,tipo);
        this.nombre_consola = nombre_consola;
    }

    @Override
    public double pagoRenta(int dias) {
     return 30*dias;
    }

    @Override
    public String toString() {
        return super.toString()+" Consola: "+nombre_consola+" Game";
    }

}