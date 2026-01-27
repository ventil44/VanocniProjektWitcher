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
        player.heal(potion.getHealAmount());
        return "Healed for " + potion.getHealAmount() + " HP.\n" +
                "Current HP: " + player.getHealth();
    }
}

