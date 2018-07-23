/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public abstract class Inventario {
    protected int maximo;
    protected ArrayList inventario;
    
    public abstract void remove(int index);
    
    public abstract void show(int index);
    
    public abstract void showInventario();
    
    public abstract void filterRank(int rank);
}
