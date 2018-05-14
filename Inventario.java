/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public abstract class Inventario {
    protected int maximo;
    protected ArrayList inventario;
    
    public void remove(int index){
        if (0<index && index<=inventario.size()){
            inventario.remove(index-1);
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    public abstract void show(int index);
    
    public abstract void showInventario();
    
    public abstract void filterRank(int rank);
}
