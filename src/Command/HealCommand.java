package Command;

import Player.Player;
import Items.Item;
import Items.Potion;

public class HealCommand implements Command {

    private final Player player;

    public HealCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        for (Item item : player.getInventory()) {
            //na instanceof jsem pouzil ai moc se omlouvam za svuj rih
            if (item instanceof Potion) {
                Potion potion = (Potion) item;

                player.heal(potion.getHealAmount());
                player.getInventory().remove(item);

                return "Healed for " + potion.getHealAmount() + " HP.\n" +
                        "Current HP: " + player.getHealth();
            }
        }

        return "You don't have a potion to heal.";
    }
}