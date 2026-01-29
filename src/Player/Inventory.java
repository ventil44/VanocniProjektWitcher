package Player;

import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Potion> potions;
    private ArrayList<Weapon> weapons;

    public Inventory(ArrayList<Potion> potions, ArrayList<Weapon> weapons) {
        this.potions = potions;
        this.weapons = weapons;
    }

    public boolean isEmptyPotions(){
        if(potions.isEmpty()){
            return true;
        } return false;
    }
}
