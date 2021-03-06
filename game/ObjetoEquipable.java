package game;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class ObjetoEquipable {
    private String name;
    private String attribute;
    private int bonus;
    private int rank;
    
    public ObjetoEquipable(){
        setStats();
    }
    
    private ArrayList<String> attributeList(){
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("HP");
        attributes.add("ATK");
        attributes.add("DEF");
        attributes.add("SPD");
        return attributes;
    }
    
    private ArrayList<String> nameList(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Amuleto");
        names.add("Arma");
        names.add("Armadura");
        names.add("Botas");
        return names;
    }
    
    private String pickAttribute(ArrayList<String> attributes){
        Random picker = new Random();
        int index = picker.nextInt(4);
        String randAttribute = attributes.get(index);
        return randAttribute;
    }
    
    private int pickBaseBonus(){
        Random picker = new Random();
        int baseBonus = picker.nextInt(9)+1;
        return baseBonus;
    }
    
    private int pickRank(){
        Random picker = new Random();
        Double chance = picker.nextDouble()*100;
        int randRank;
        if(chance<20){
            randRank = 1;
        }
        else if(chance<40){
            randRank = 2;
        }
        else if(chance<60){
            randRank = 3;
        }
        else if(chance<75){
            randRank = 4;
        }
        else if(chance<85){
            randRank = 5;
        }
        else if(chance<90){
            randRank = 6;
        }
        else if(chance<94){
            randRank = 7;
        }
        else if(chance<97){
            randRank = 8;
        }
        else if(chance<99){
            randRank = 9;
        }
        else{
            randRank = 10;
        }
        return randRank;
    }
    
    private int calcFinalBonus(int baseBonus, int rank){
        int finalBonus = baseBonus*rank;
        return finalBonus;
    }
    
    private void setStats(){
        attribute = pickAttribute(attributeList());
        name = nameList().get(attributeList().indexOf(attribute));
        rank = pickRank();
        bonus = calcFinalBonus(pickBaseBonus(),rank);
    }
    
    @Override
    public String toString(){
        return name + " da bonus de "+ bonus + " a " + attribute + ". Rango " + rank +"*\n";
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getAttribute(){
        return this.attribute;
    }
    
    public int getBonus(){
        return this.bonus;
    }
    
    public int getRank(){
        return this.rank;
    }
    
}
