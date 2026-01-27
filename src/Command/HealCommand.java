package Command;

import Player.Player;
import Items.Potion;

public class HealCommand implements Command {

    private final Player player;
    private final Potion potion;

    public HealCommand(Player player, Potion potion) {
        this.player = player;
        this.potion = potion;
    }

    @Override
    public String execute() {
        if(player.getInventory().contains(potion)) {
            player.heal(potion.getHealAmount());
            return "Healed for " + potion.getHealAmount() + " HP.\n" +
                    "Current HP: " + player.getHealth();
        }
        else {
            return "You don't have a potion to heal";
        }
    }
}

