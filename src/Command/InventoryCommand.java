package Command;

import Player.Player;
import Items.Item;

import java.util.ArrayList;

/**
 * Command that displays the items in players inventory
 * If there arent any items, a message informing the user is displayed
 * @author Denis Vesely
 */
public class InventoryCommand implements Command {

    private final Player player;


    public InventoryCommand(Player player) {
        this.player = player;
    }

    /**
     * Excutes inventory command
     * @return a list of items in players inventory or a message that it is empty
     */
    @Override
    public String execute() {
        ArrayList<Item> items = player.getInventory();

        if (items.isEmpty()) {
            return "Inventory is empty.";
        }

        String result = "Inventory:";

        for (int i = 0; i < items.size(); i++) {
            result += (i + 1) + " - " + items.get(i).getName() + "\n";
        }

        return result;
    }
}