package proyectoprogra;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class Batalla {
    private int max = 6;
    private ArrayList<Luchador> team = new ArrayList<>();
    private Monstruo enemy = new Monstruo();
    Random dado = new Random();
    
    public Batalla(ArrayList<Luchador> inventario){
        int partySize = Math.min(max,inventario.size());
        fillTeam(inventario, partySize);
        int rawDiceLuck = dado.nextInt(8)-dado.nextInt(6);
    }
    
    private void fillTeam(ArrayList<Luchador> inventario, int partySize){
        ArrayList<Integer> nonRepeat = new ArrayList<>();
        for (int i=0; i < partySize; i++){
            int index = dado.nextInt(inventario.size());
            if (nonRepeat.contains(index)){
                i--;
            } else{
                team.add(inventario.get(index));
                nonRepeat.add(index);
            }
        }
    }
    
    private ArrayList<String> factionList(){
        ArrayList<String> factions = new ArrayList<>();
        factions.add("Agua");
        factions.add("Fuego");
        factions.add("Planta");
        return factions;
    }
    
    private double calcDamage(int atk, String atkFaction, int def, String defFaction, int diceLuck){
        int dmg;
        int determinant = factionList().indexOf(atkFaction)-factionList().indexOf(defFaction);
        switch (determinant) {
            case -1:
            case 2:
                dmg = (int) (diceLuck*(1.5*atk-def));
            case 1:
            case -2:
                dmg = (int) (diceLuck*(0.75*atk-def));
            default:
                dmg = (int) (diceLuck*(atk-def));
        }
        if (dmg<0){
            dmg = 0;
        }
        return dmg;
    }
    
    //private ArrayList<Integer> atkOrder(ArrayList<Luchador> team, Monstruo enemy){
        
    //}
    
}
