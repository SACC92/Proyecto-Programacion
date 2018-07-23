package game;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Sebastian
 */
public class Luchador extends Personaje{
    private String name;
    private int rank;
    
    public Luchador(){
        setStats();
    }
    
    private ArrayList<String> nameList(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Giskard");
        names.add("Murdock");
        names.add("Aneninen");
        names.add("Sukeena");
        names.add("Yxonumei");
        names.add("Th-Ts");
        names.add("Banboil");
        names.add("Furk");
        names.add("LinHuan");
        names.add("Vestiyana");
        names.add("Grey-Oh");
        names.add("Lisa");
        names.add("Laura");
        names.add("Ziggy");
        names.add("Samara");
        return names;
    }
    
    private String pickName(ArrayList<String> names){
        Random picker = new Random();
        int index = picker.nextInt(15);
        String randName = names.get(index);
        return randName;
    }
    
    private int pickBaseHP(){
        Random picker = new Random();
        int baseHP = picker.nextInt(301)+200;
        return baseHP;
    }
    
    private int pickBaseATK(){
        Random picker = new Random();
        int baseATK = picker.nextInt(51)+20;
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
    
    private int pickRank(){
        Random picker = new Random();
        Double chance = picker.nextDouble()*100;
        int randRank;
        if(chance<40){
            randRank = 1;
        }
        else if(chance<70){
            randRank = 2;
        }
        else if(chance<85){
            randRank = 3;
        }
        else if(chance<95){
            randRank = 4;
        }
        else{
            randRank = 5;
        }
        return randRank;
    }
    
    private int calcFinalStat(int baseStat, int rank){
        int finalStat = baseStat*rank;
        return finalStat;
    }
    
    private void setStats(){
        name = pickName(nameList());
        faction = pickFaction(factionList());
        rank = pickRank();
        hp = calcFinalStat(pickBaseHP(),rank);
        atk = calcFinalStat(pickBaseATK(),rank);
        def = calcFinalStat(pickBaseDEF(),rank);
        spd = calcFinalStat(pickBaseSPD(),rank);
    }
    
    @Override
    public String toString(){
        return name + ", de los de " + faction + "\nRank: " + rank + "*\nHP: " + hp + "\nATK: " + atk + "\nDEF: " + def + "\nSPD: " + spd +"\n";
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getRank(){
        return this.rank;
    }
    
}
