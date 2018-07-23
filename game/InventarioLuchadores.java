package game;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Sebastian
 */
public class InventarioLuchadores extends Inventario{
    
    private ArrayList<Luchador> inventario;
    
    public InventarioLuchadores(){
        maximo = 25;
        inventario  = new ArrayList();
    }
    
    public void howMany(){
        System.out.println("Dispone de " + inventario.size() + " luchadores en su inventario\n");
    }
    
    public int size(){
        return inventario.size();
    }
    
    public void addLuchador(Luchador luchador){
        if (inventario.size()<maximo){
            inventario.add(luchador);
        }
        else{
            System.out.println("Inventario lleno. Intente borrar luchadores");
        }
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
    public void showInventario(){
        for (int i=0; i<inventario.size(); i++) {
            Luchador luchador = inventario.get(i);
            System.out.println((i+1)+".- "+luchador.getName()+" de los de "+luchador.getFaction()+". "+luchador.getRank()+"*");
        }
        System.out.println();
    }
    
    @Override
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
    
    public void randomInventario(){
        Random rnd = new Random();
        int sizeI = rnd.nextInt(25)+1;
        for (int i=0; i<sizeI; i++){
            Luchador luchador = new Luchador();
            this.addLuchador(luchador);
        }
    }
    
}
