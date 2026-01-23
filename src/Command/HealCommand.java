package Command;

import Items.Item;
import Items.Potion;
import Player.Inventory;
import Player.Player;

public class HealCommand implements Command{

    private Player p;
    private Inventory inv;
    private Potion potion;

    public HealCommand(Player p, Inventory inv, Potion potion) {
        this.p = p;
        this.inv = inv;
        this.potion = potion;
    }

    @Override
    public String execute() {
        if(!inv.isEmptyPotions()){
            p.setCurrentHealth(p.getCurrentHealth()+ potion.getHealAmount());
            System.out.println("Healed " + potion.getHealAmount() + ". You now have " + p.getCurrentHealth() + "HP");
            return "";
        } else {
            System.out.println("You have no potions");
            return "";
        }



    }
}
