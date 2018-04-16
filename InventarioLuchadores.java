package proyectoprogra;

import java.util.ArrayList;
/**
 *
 * @author Sebastian
 */
public class InventarioLuchadores {
    private int maximo = 25;
    private ArrayList<Luchador> inventario = new ArrayList<>();
    
    public void howMany(){
        System.out.println("Dispone de " + inventario.size() + " luchadores en su inventario\n");
    }
    
    public void addLuchador(Luchador luchador){
        if (inventario.size()<maximo){
            inventario.add(luchador);
        }
        else{
            System.out.println("Inventario lleno. Intente borrar luchadores");
        }
    }
    
    public void removeLuchador(int index){
        if (0<index && index<=inventario.size()){
            inventario.remove(index-1);
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    public void showLuchador(int index){
        if (0<index && index<=inventario.size()){
            System.out.print(inventario.get(index-1));
        }
        else{
            System.out.println("Fuera de rango\n");
        }
    }
    
    public void showInventario(){
        for (int i=0; i<inventario.size(); i++) {
            Luchador luchador = inventario.get(i);
            System.out.println((i+1)+".- "+luchador.getName()+" de los de "+luchador.getFaction()+". "+luchador.getRank()+"*");
        }
        System.out.println();
    }
    
    public void filterRank(int rank){
        int count = 0;
        for (int i=0; i<inventario.size(); i++) {
            if (inventario.get(i).getRank()==rank){
                count += 1;
                System.out.println(inventario.get(i).getName()+" de los de "+inventario.get(i).getFaction()+". "+inventario.get(i).getRank()+"*");
            }
        }
        if (count == 0){
            System.out.println("Filtro sin resultados");
        }
        System.out.println();
    }
    
    public void filterFaction(String faction){
        int count = 0;
        for (int i=0; i<inventario.size(); i++) {
            if (inventario.get(i).getFaction().equals(faction)){
                count += 1;
                System.out.println(inventario.get(i).getName()+" de los de "+inventario.get(i).getFaction()+". "+inventario.get(i).getRank()+"*");
            }
        }
        if (count == 0){
            System.out.println("Filtro sin resultados");
        }
        System.out.println();
    }
    
}
