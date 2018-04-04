/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class ProyectoProgra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Luchador l = new Luchador();
        l.showStats();
        
        Random rnd = new Random();
        int sizeI = rnd.nextInt(25)+1;
        InventarioLuchadores inventario = new InventarioLuchadores();
        
        for (int i=0; i<sizeI; i++){
            Luchador luchador = new Luchador();
            inventario.addLuchador(luchador);
        }
        
        int sizeO = rnd.nextInt(10)+1;
        InventarioObjetos objetos = new InventarioObjetos();
        
        for (int i=0; i<sizeO; i++){
            ObjetoEquipable objeto = new ObjetoEquipable();
            objetos.addObjeto(objeto);
        }
        
        inventario.showInventario();
        inventario.howMany();
        int posI = rnd.nextInt(sizeI)+1;
        System.out.println("Posición " + posI + ":");
        inventario.showLuchador(posI);
        inventario.filterFaction("Fuego");
        int rank = rnd.nextInt(5)+1;
        System.out.println("Rango " + rank + "*");
        inventario.filterRank(rank);
        
        objetos.showInventario();
        int posO = rnd.nextInt(sizeO)+1;
        System.out.println("Posición " + posO + ":");
        objetos.showObjeto(posO);
        rank = rnd.nextInt(5)+1;
        System.out.println("Rango " + rank + "*");
        objetos.filterRank(rank);
        
        
    }
    
}
