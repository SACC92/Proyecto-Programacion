/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class Personaje {
    protected int hp;
    protected int atk;
    protected int def;
    protected int spd;
    protected String faction;
    
    protected ArrayList<String> factionList(){
        ArrayList<String> factions = new ArrayList<>();
        factions.add("Agua");
        factions.add("Fuego");
        factions.add("Planta");
        return factions;
    }
    
    protected String pickFaction(ArrayList<String> factions){
        Random picker = new Random();
        int index = picker.nextInt(3);
        String randFaction = factions.get(index);
        return randFaction;
    }
    
    public int getHP(){
        return this.hp;
    }
    
    public int getATK(){
        return this.atk;
    }
    
    public int getDEF(){
        return this.def;
    }
    
    public int getSPD(){
        return this.spd;
    }
    
    public String getFaction(){
        return this.faction;
    }
    
}
