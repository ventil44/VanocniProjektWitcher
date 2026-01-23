package Command;

import Items.Item;
import Items.Potion;
import Player.Inventory;
import Player.Player;

public class HealCommand implements Command{

    private Player p;
    private Inventory inv;
    private Potion potion;


    @Override
    public String execute() {
        if(inv.isEmptyPotions()){
            p.setCurrentHealth(p.getCurrentHealth()+ potion.getHealAmount());
        }

        return "Healed " + potion.getHealAmount() + ". You now have " + p.getCurrentHealth() + "HP";
    }
}
