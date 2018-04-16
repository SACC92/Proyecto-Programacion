package proyectoprogra;

import java.util.ArrayList;
/**
 *
 * @author Sebastian
 */
public class InventarioObjetos {
    private int maximo = 10;
    private ArrayList<ObjetoEquipable> inventario = new ArrayList<>();
    
    public void addObjeto(ObjetoEquipable objeto){
        if (inventario.size()<maximo){
            inventario.add(objeto);
        }
        else{
            System.out.println("Inventario lleno. Intente eliminar objetos");
        }
    }
    
    public void removeObjeto(int index){
        if (0<index && index<=inventario.size()){
            inventario.remove(index-1);
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    public void showObjeto(int index){
        if (0<index && index<=inventario.size()){
            System.out.println(inventario.get(index-1));
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    public void showInventario(){
        for (int i=0; i<inventario.size(); i++) {
            ObjetoEquipable objeto = inventario.get(i);
            System.out.print((i+1)+".- ");
            System.out.println(objeto);
        }
        System.out.println();
    }
    
    public void filterRank(int rank){
        int count = 0;
        for (int i=0; i<inventario.size(); i++) {
            if (inventario.get(i).getRank()==rank){
                count += 1;
                System.out.println(inventario.get(i));
            }
        }
        if (count == 0){
            System.out.println("Filtro sin resultados");
        }
        System.out.println();
    }
    
}
