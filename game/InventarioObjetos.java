package game;

import java.util.ArrayList;
/**
 *
 * @author Sebastian
 */
public class InventarioObjetos extends Inventario{
    
    private ArrayList<ObjetoEquipable> inventario;
    
    public InventarioObjetos(){
        maximo = 10;
        inventario = new ArrayList();
    }
    
    public void addObjeto(ObjetoEquipable objeto){
        if (inventario.size()<maximo){
            inventario.add(objeto);
        }
        else{
            System.out.println("Inventario lleno. Intente eliminar objetos");
        }
    }
    
    @Override
    public void remove(int index){
        inventario.remove(index);
    }
    
    @Override
    public void showInventario(){
        for (int i=0; i<inventario.size(); i++) {
            ObjetoEquipable objeto = inventario.get(i);
            System.out.print((i+1)+".- ");
            System.out.println(objeto);
        }
        System.out.println();
    }
    
    @Override
    public void show(int index){
        if (0<index && index<=inventario.size()){
            System.out.print(inventario.get(index-1));
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    @Override
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
