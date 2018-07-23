package game;

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
    private int rawDiceLuck;
    private int teamDiceLuck = 1;
    private int enemyDiceLuck = 1;
    Random dado = new Random();
    
    public Batalla(ArrayList<Luchador> inventario){
        int partySize = Math.min(max,inventario.size());
        fillTeam(inventario, partySize);
        rawDiceLuck = dado.nextInt(8)-dado.nextInt(6);
        setDiceLuck(rawDiceLuck);
        ArrayList<Integer> order = atkOrder(team, enemy);
        battle(partySize, order);
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
    
    private void setDiceLuck(int rawDiceLuck){
        if (rawDiceLuck > 0){
            teamDiceLuck = rawDiceLuck;
        }
        else if (rawDiceLuck < 0){
            enemyDiceLuck = -rawDiceLuck;
        }
    }
    
    private int calcDamage(int atk, String atkFaction, int def, String defFaction, int diceLuck){
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
    
    private ArrayList<Integer> moddedBubbleSort(ArrayList<Integer> list) { 
        ArrayList<Integer> copy = list;
        ArrayList<Integer> indexes = new ArrayList<>();
        int size = copy.size(); 
        int aux; 
        int auxind;
        for(int i=0; i<size; i++){
            indexes.add(i);
        }
        for(int i=0; i<size; i++){ 
            for(int j=1; j < (size-i); j++){ 
                if(copy.get(j-1) > copy.get(i)){ 
                    aux = copy.get(j-1); 
                    auxind = indexes.get(j-1);
                    copy.set(j-1,copy.get(j)); 
                    indexes.set(j-1,indexes.get(j)); 
                    copy.set(j,aux);
                    indexes.set(j,auxind);
                } 
            } 
        }
        return indexes;
    }
    
    private ArrayList<Integer> atkOrder(ArrayList<Luchador> team, Monstruo enemy){
        ArrayList<Integer> speeds = new ArrayList<>();
        for (int i=0; i<team.size(); i++){
            speeds.add(team.get(i).getSPD());
        }
        ArrayList<Integer> order = moddedBubbleSort(speeds);
        int check = 0;
        for (int i=0; i<speeds.size()-1; i++){
            if(speeds.get(i) < enemy.getSPD() && enemy.getSPD() < speeds.get(i+1)){
                order.add(i+1,-1);
                check = 1;
            }
        }
        if (check == 0){
            order.add(-1);
        }
        return order;
    }
    
    private void battle(int partySize, ArrayList<Integer> order){
        Luchador fighter;
        while(team.size() > 0 && enemy.getHP() > 0){
            for (int i=0; i<partySize+1; i++){
                if(order.get(i)<0){
                    fighter = team.get(0);
                    fighter.setHP(fighter.getHP()- calcDamage(enemy.getATK(),enemy.getFaction(),fighter.getDEF(),fighter.getFaction(),enemyDiceLuck));
                    if (fighter.getHP()==0){
                        team.remove(0);
                    }
                }
                else{
                    fighter = team.get(i);
                    enemy.setHP(enemy.getHP()- calcDamage(fighter.getATK(),fighter.getFaction(),enemy.getDEF(),enemy.getFaction(),teamDiceLuck));
                }
            }
        }
    }
    
}
