package proyectoprogra;

import java.util.Random;

/**
 *
 * @author Sebastian
 */
public class Monstruo {
    private int hp;
    private int atk;
    private int def;
    private int spd;
    
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
    
    private void crearMonstruo(){
        hp = pickBaseHP();
        atk = pickBaseATK();
        def = pickBaseDEF();
        spd = pickBaseSPD();
    }
    
    private void crearObjetoDropeable(){
        ObjetoEquipable objeto = new ObjetoEquipable();
        objeto.showStats();
    }
    
}
