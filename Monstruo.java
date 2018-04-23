package proyectoprogra;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class Monstruo {
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private String faction;
    
    public Monstruo(){
        crearMonstruo();
    }
    
    private int pickBaseHP(){
        Random picker = new Random();
        int baseHP = picker.nextInt(501)+3500;
        return baseHP;
    }
    
    private int pickBaseATK(){
        Random picker = new Random();
        int baseATK = picker.nextInt(501)+1000;
        return baseATK;
    }
    
    private int pickBaseDEF(){
        Random picker = new Random();
        int baseDEF = picker.nextInt(21)+5;
        return baseDEF;
    }
    
    private int pickBaseSPD(){
        Random picker = new Random();
        int baseSPD = picker.nextInt(91)+10;
        return baseSPD;
    }
    
    private ArrayList<String> factionList(){
        ArrayList<String> factions = new ArrayList<>();
        factions.add("Agua");
        factions.add("Fuego");
        factions.add("Planta");
        return factions;
    }
    
    private String pickFaction(ArrayList<String> factions){
        Random picker = new Random();
        int index = picker.nextInt(3);
        String randFaction = factions.get(index);
        return randFaction;
    }
    
    private void crearMonstruo(){
        hp = pickBaseHP();
        atk = pickBaseATK();
        def = pickBaseDEF();
        spd = pickBaseSPD();
        faction = pickFaction(factionList());
    }
    
    private void crearObjetoDropeable(){
        ObjetoEquipable objeto = new ObjetoEquipable();
        System.out.println(objeto);
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
