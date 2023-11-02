/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1q4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
class BlockBuster {
    private ArrayList<BlockBusterItem> items;
    private  MovieItem movie;
    private  VideoGameItem game;

    public BlockBuster() {
        items = new ArrayList<>();
        
    }

    public BlockBusterItem  buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item.getCódigo() == codigo && item.getTipo().equalsIgnoreCase(tipo)) {
                return item;
            }
        }
        return null;
    }
    
        
    public void agregarItem(int codigo, String nombre, String tipoItem) {
        if (buscarItem(codigo, tipoItem) == null) {
            if (tipoItem.equalsIgnoreCase("MOVIE")) {
                movie = new MovieItem(codigo, nombre);
                items.add(movie);
            } else if (tipoItem.equalsIgnoreCase("GAME")) {
                game = new VideoGameItem(codigo, nombre);
                items.add(game);
            } else {
                System.out.println("Tipo de ítem no válido.");
            }
        } else {
            System.out.println("Ya existe un ítem con ese código y tipo.");
        }
    }

    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            item.mostrarInfo();
            double monto = item.calcularMonto(dias);
            System.out.println("Monto a pagar: " + monto);
        } else {
            System.out.println("Item No Existe");
        }
    }

    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado();
            }
        }
    }
    
    
}
