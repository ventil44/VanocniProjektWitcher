package Command;

import Player.Player;
import Items.Item;
import Items.Potion;

/**
 * Command that allows the user to heal by using a potion from their inventory
 * If a potion is found in users inventory it heals him and removes to potion
 * If a potion isnt found in users inventory it tells him he doesnt have a potion to heal with
 * @author Denis Vesely
 */
public class HealCommand implements Command {

    private final Player player;

    public HealCommand(Player player) {
        this.player = player;
    }

    /**
     * Executes heal command
     * Checks the users invenotry for a potion if a potion is found it heals him
     * @return a message describing the healing result or a message that theres no potion to heal from
     */
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